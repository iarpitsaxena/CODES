from flask import Flask, request, render_template
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing.image import img_to_array, load_img
import numpy as np
import io
from PIL import Image

app = Flask(__name__)

# Load the saved model
model = load_model("/Users/arpit/Desktop/CODES/Deep_Learning/food image/foodcnn.h5")

# Food directory
food_dict = {
    0: 'biriyani', 1: 'bisibelebath', 2: 'butternaan', 3: 'chaat', 4: 'chappati',
    5: 'dhokla', 6: 'dosa', 7: 'gulab jamun', 8: 'halwa', 9: 'idly', 10: 'kathi roll',
    11: 'meduvadai', 12: 'noodles', 13: 'paniyaram', 14: 'poori', 15: 'samosa',
    16: 'tandoori chicken', 17: 'upma', 18: 'vada pav', 19: 'ven pongal'
}

@app.route('/', methods=['GET'])
def index():
    return render_template('index.html')

@app.route('/predict', methods=['POST'])
def predict():
    # Handle file upload from form
    file = request.files['file']
    
    # Convert the file to a PIL image using BytesIO
    img = Image.open(io.BytesIO(file.read()))
    
    # Resize the image acc. to model
    img = img.resize((224, 224))  # Assuming 224x224 is the expected input size
    
    # cnvrt img to array and normalize
    img_array = img_to_array(img) / 255.0  # normalize
    img_array = np.expand_dims(img_array, axis=0)  # add batch dimension
    
    # checking input shape
    if img_array.shape != (1, 224, 224, 3):
        raise ValueError("Input shape mismatch. Expected (1, 224, 224, 3), but got: " + str(img_array.shape))
    
    # predict image class
    prediction = model.predict(img_array)
    predicted_class = np.argmax(prediction, axis=1)[0]
    confidence = prediction[0][predicted_class] * 100  # Convert to percentage

    # food name with class index
    predicted_food = food_dict.get(predicted_class, "Unknown Food")

    # render result with prediction and confiddence
    return render_template('index.html', prediction=predicted_food, confidence=confidence)

if __name__ == '__main__':
    app.run(debug=True)
