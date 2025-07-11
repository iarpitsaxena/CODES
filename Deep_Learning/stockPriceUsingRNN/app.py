import streamlit as st
import yfinance as yf
import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler
from sklearn.metrics import mean_squared_error, mean_absolute_error
from keras.models import Sequential
from keras.layers import SimpleRNN, Dense

st.title('Stock Price using RNN :-')

# Input fields for stock symbol, start date, end date, and prediction date
company_name = st.text_input('Company name', placeholder=' Enter Company name')
start_date = st.date_input('Enter Start date')
end_date = st.date_input('Enter End date')
date_for_prediction = st.date_input('Select Date for prediction')

# Download stock data and display
df = yf.download(company_name, start=start_date, end=end_date)
st.write(df)

# Visualization of stock data
st.area_chart(df['Volume'])
st.bar_chart(df[['High', 'Low']])

# When Predict button is clicked
if st.button('Predict'):
    # Prepare data for RNN
    data = df['Close'].values.reshape(-1, 1)
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_data = scaler.fit_transform(data)
    
    # Split the data into training and testing sets (80% train, 20% test)
    train_size = int(len(scaled_data) * 0.8)
    train_data = scaled_data[:train_size]
    test_data = scaled_data[train_size - 60:]  # Start 60 steps back for test data
    
    # Function to create dataset with look-back
    def create_dataset(dataset, look_back=60):
        X, y = [], []
        for i in range(len(dataset) - look_back - 1):
            X.append(dataset[i:(i + look_back), 0])
            y.append(dataset[i + look_back, 0])
        return np.array(X), np.array(y)
    
    look_back = 60
    X_train, y_train = create_dataset(train_data, look_back)
    X_test, y_test = create_dataset(test_data, look_back)

    # Reshape X to [samples, time steps, features]
    X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1], 1))
    X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))
    
    # Build the RNN model using SimpleRNN instead of LSTM
    model = Sequential()
    model.add(SimpleRNN(units=50, return_sequences=True, input_shape=(X_train.shape[1], 1)))
    model.add(SimpleRNN(units=50))
    model.add(Dense(units=1))
    
    # Compile the model
    model.compile(optimizer='adam', loss='mean_squared_error')
    
    # Train the model
    model.fit(X_train, y_train, epochs=10, batch_size=32)
    
    # Make predictions on the test set
    predictions_scaled = model.predict(X_test)
    
    # Inverse scaling to get back to original values
    predictions = scaler.inverse_transform(predictions_scaled)
    y_test_original = scaler.inverse_transform([y_test])
    
    # Display predictions
    st.write(f"Predicted closing price for {date_for_prediction}: {predictions[-1][0]:.2f}")
    
    # Calculate accuracy metrics
    mse = mean_squared_error(y_test_original[0], predictions[:, 0])
    mae = mean_absolute_error(y_test_original[0], predictions[:, 0])
    
    st.write(f"Mean Squared Error: {mse:.4f}")
    st.write(f"Mean Absolute Error: {mae:.4f}")