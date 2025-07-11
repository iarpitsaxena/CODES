import streamlit as st
import yfinance as yf
import pandas as pd
import matplotlib.pyplot as plt


st.title("StockPrice Prediction")
cp_name = st.text_input('Company Name',placeholder="company name")
start_date = st.date_input('Start date')
end_date = st.date_input('End date')
date_for_prediction = st.date_input('date for prediction')
st.button('Predict')

#url = st.text_input("Enter the URL of the dataset:", "")
df = yf.download(cp_name, start_date, end_date)
st.write(df)
st.line_chart(df['Close'])
st.area_chart(df['Volume'])
st.bar_chart(df[['High','Low']])
#ticker = st.text_input("Enter Stock Ticker Symbol (e.g., AAPL, TSLA):", "")


