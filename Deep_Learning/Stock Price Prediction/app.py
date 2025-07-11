from flask import Flask, render_template, request
import yfinance as yf
import numpy as np
import pandas as pd
from tensorflow.keras.models import load_model
import matplotlib.pyplot as plt
import io
import base64

app = Flask(__name__)

# Load your RNN model
model = load_model('stock_rnn_model.h5')

# Route for home page
@app.route('/')
def home():
    return render_template('index.html')

# Route for prediction
@app.route('/predict', methods=['POST'])
def predict():
    if request.method == 'POST':
        stock_ticker = request.form['ticker']
        start_date = request.form['start_date']
        end_date = request.form['end_date']

        # Download stock data
        stock_data = get_stock_data(stock_ticker, start_date, end_date)
        
        # Prepare and predict
        X, _, scaler = prepare_data(stock_data)
        predicted_prices = model.predict(X)
        predicted_prices = scaler.inverse_transform(predicted_prices)

        # Plotting
        img = io.BytesIO()
        plt.figure(figsize=(10, 6))
        plt.plot(stock_data[-len(predicted_prices):], label='Actual')
        plt.plot(predicted_prices, label='Predicted')
        plt.legend()
        plt.savefig(img, format='png')
        img.seek(0)
        plot_url = base64.b64encode(img.getvalue()).decode('utf8')
        
        return render_template('result.html', plot_url=plot_url)

if __name__ == "__main__":
    app.run(debug=True)
