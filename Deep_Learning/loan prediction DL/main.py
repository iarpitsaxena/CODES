from flask import Flask,render_template,request
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler,LabelEncoder
from keras.models import Sequential , Model
from keras.layers import Dense , Flatten
import tensorflow

app=Flask(__name__)


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/search', methods=['POST'])
def search():
    df = pd.read_csv('Loan_data.csv')
    categorical=["Gender","Married","Dependents","Education","Self_Employed","Property_Area","Loan_Status","Loan_ID"]
    numerical=["ApplicantIncome","CoapplicantIncome","LoanAmount","Loan_Amount_Term"]
    label_encoder = LabelEncoder()
    for col in categorical:
        df[col] = label_encoder.fit_transform(df[col])
    for col in df.columns:
        df[col].fillna(df[col].mean(), inplace=True)
    scaler = MinMaxScaler()
    df_normalized = pd.DataFrame(scaler.fit_transform(df), columns=df.columns)
    df_normalized.head(10)
    x = df_normalized.drop(['Loan_ID','Gender','Married','Education','Dependents','CoapplicantIncome','Loan_Amount_Term','Property_Area','Loan_Status'], axis=1)
    y = df_normalized['Loan_Status']
    y = y.values.reshape(-1, 1)
    x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=42)
    model=Sequential()
    model.add(Dense(128,activation='relu'))
    model.add(Dense(128,activation='relu'))
    model.add(Dense(128,activation='relu'))
    model.add(Dense(128,activation='relu'))
    model.add(Dense(1,activation='sigmoid'))
    model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
    model.fit(x_train, y_train, epochs=50)
    model.evaluate(x_test, y_test)
    pred  = model.predict(x_test)
    return render_template('response.html', answer=result)




if __name__== "__main__":
    app.run()