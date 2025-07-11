from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def index():
    print('Hello from the console!')
    return render_template('index.html')

@app.route('/predict', methods=['POST'])
def predict():
    gender = request.form['gender']
    married = request.form['married']
    dependents = request.form['dependents']
    education = request.form['education']
    Self_Employed = request.form['Self_Employed']
    applicant_income = request.form['applicant_income']
    co_applicant_income = request.form['co_applicant_income']
    loan_amount = request.form['loan_amount']
    term = request.form['term']
    credit_history = request.form['credit_history']
    Property_Area = request.form['Property_Area']


    dependents = int(dependents)
    applicant_income = int(applicant_income)
    co_applicant_income = int(co_applicant_income)
    loan_amount = int(loan_amount)
    term = int(term)
    credit_history = int(credit_history)

    from sklearn.preprocessing import LabelEncoder
    le = LabelEncoder()
    gender = le.fit_transform([gender])[0]
    married = le.fit_transform([married])[0]
    education = le.fit_transform([education])[0]
    Self_Employed = le.fit_transform([Self_Employed])[0]
    Property_Area = le.fit_transform([Property_Area])[0]

    from sklearn.preprocessing import StandardScaler
    import numpy as np
    sc = StandardScaler()
    applicant_income = sc.fit_transform(np.array([[applicant_income]]))[0][0]
    co_applicant_income = sc.fit_transform(np.array([[co_applicant_income]]))[0][0]
    loan_amount = sc.fit_transform(np.array([[loan_amount]]))[0][0]
    term = sc.fit_transform(np.array([[term]]))[0][0]

    input_data = np.array([[gender, married, dependents, education, Self_Employed, 
                        applicant_income, co_applicant_income, loan_amount, 
                        term, credit_history, Property_Area]])
    
    import pandas as pd
    data = pd.read_csv('train.csv')

    data.dropna(inplace=True)
    data=data.drop('Loan_ID', axis=1)

    from sklearn.preprocessing import OneHotEncoder
    le=OneHotEncoder()
    data['Gender']=le.fit_transform(data['Gender'].values.reshape(-1,1)).toarray()
    data['Married']=le.fit_transform(data['Married'].values.reshape(-1,1)).toarray()
    data['Education']=le.fit_transform(data['Education'].values.reshape(-1,1)).toarray()
    data['Self_Employed']=le.fit_transform(data['Self_Employed'].values.reshape(-1,1)).toarray()
    data['Property_Area']=le.fit_transform(data['Property_Area'].values.reshape(-1,1)).toarray()
    data['Loan_Status']=le.fit_transform(data['Loan_Status'].values.reshape(-1,1)).toarray()

    from sklearn.preprocessing import StandardScaler
    sc=StandardScaler()
    data['ApplicantIncome']=sc.fit_transform(data['ApplicantIncome'].values.reshape(-1,1))
    data['CoapplicantIncome']=sc.fit_transform(data['CoapplicantIncome'].values.reshape(-1,1))
    data['LoanAmount']=sc.fit_transform(data['LoanAmount'].values.reshape(-1,1))
    data['Loan_Amount_Term']=sc.fit_transform(data['Loan_Amount_Term'].values.reshape(-1,1))

    data['Dependents']=data['Dependents'].replace('3+', 3)

    X=data.drop('Loan_Status', axis=1)
    y=data['Loan_Status']

    from sklearn.model_selection import train_test_split
    from keras.models import Sequential
    from keras.layers import Dense
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    model=Sequential()
    model.add(Dense(128, activation='relu'))
    model.add(Dense(128, activation='relu'))
    model.add(Dense(1, activation='sigmoid'))

    model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
    model.fit(X_train, y_train, epochs=30)

    str = model.predict(input_data)
    output = ""

    print(float(str[0]))

    if float(str[0])>=0.5:
        output= 'Loan Approved'
    else:
        output= 'Loan Not Approved'

    return render_template('result.html', output=output)

if __name__ == '__main__':
    app.run()