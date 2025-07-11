from flask import Flask, request, jsonify
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing.image import img_to_array, load_img
import numpy as np
import os

app = Flask(__name__)

# Load the model (make sure model.h5 is in the same directory or specify the correct path)
MODEL_PATH = "model.h5"
if not os.path.exists(MODEL_PATH):
    raise FileNotFoundError(f"Model file not found: {MODEL_PATH}")
model = load_model(MODEL_PATH)

@app.route('/predict', methods=['POST'])
def predict():
    # Check if an image file is in the request
    if 'file' not in request.files:
        return jsonify({"error": "No file part in the request"}), 400

    file = request.files['file']
    if file.filename == '':
        return jsonify({"error": "No selected file"}), 400

    try:
        # Load and preprocess the image
        img = load_img(file, target_size=(128, 128))  # Change target size to match model input size
        img_array = img_to_array(img) / 255.0  # Normalize the image
        img_array = np.expand_dims(img_array, axis=0)  # Add batch dimension

        # Make prediction
        prediction = model.predict(img_array)
        predicted_class = int(np.argmax(prediction, axis=1)[0])
        confidence = float(prediction[0][predicted_class])

        return jsonify({
            "predicted_class": predicted_class,
            "confidence": confidence
        })
    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
