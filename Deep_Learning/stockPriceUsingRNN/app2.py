import streamlit as st
import yfinance as yf
import pandas as pd

# Title
st.title('Stock Price Data for Specific Date')

# Input fields for stock symbol and the specific date
company_name = st.text_input('Enter Company Symbol', placeholder='E.g. AAPL, GOOGL, TSLA')
specific_date = st.date_input('Select Date for Data')

# Download stock data for the range including the specific date
if company_name and specific_date:
    # Download data for a range including the specific date
    start_date = specific_date - pd.Timedelta(days=1)  # Get one day before to ensure data availability
    end_date = specific_date + pd.Timedelta(days=1)    # Get one day after
    
    # Fetch stock data from Yahoo Finance
    df = yf.download(company_name, start=start_date, end=end_date)
    
    if not df.empty:
        # Extract data for the exact specific date if available
        specific_data = df[df.index == pd.to_datetime(specific_date)]
        
        if not specific_data.empty:
            st.write(f"Stock data for {company_name} on {specific_date}:")
            st.write(specific_data)
        else:
            st.error(f"No stock data available for {company_name} on {specific_date}.")
    else:
        st.error(f"Failed to retrieve data for {company_name}. Please check the stock symbol and try again.")
else:
    st.warning("Please enter a stock symbol and select a date.")
