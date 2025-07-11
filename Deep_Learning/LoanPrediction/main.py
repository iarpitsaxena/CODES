import pickle
with open('model.pkl', 'rb') as model_file:
    model = pickle.load(model_file)

from flask import Flask, render_template, request

app=Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/search', methods=['post'])
def search():
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

    str = model.predict(input_data)
    if float(str)>=0.5:
        ans= 'Loan Approved'
    else:
        ans= 'Loan Not Approved'
    return render_template('result.html', answer=ans)


if __name__=='__main__':
    app.run()