from flask import Flask, jsonify
import keras 
from flask import request
import numpy as np
from PIL import Image
from io import BytesIO
import base64
import cv2
import tensorflow as tf
from tensorflow.python.keras.backend import set_session
from tensorflow.python.keras.models import load_model
from keras.applications.imagenet_utils import preprocess_input
from keras.preprocessing import image


app = Flask(__name__)

@app.route("/flowerRecognition",  methods = ['POST'])
def flower_recognititon():
    print('a')
    im = request.data
    im_bytes = base64.b64decode(im)
    # nparr = np.fromstring(im_bytes, np.uint8)
    # img = cv2.imdecode(nparr, cv2.IMREAD_ANYCOLOR)
    img = BytesIO(im_bytes)
    img = Image.open(img)
    img.save('a.png', 'png')
    # Define data path
    list_flower = ["lotus", "daisy", "rose", "sunflower", "common dandelion", "common tulip", "camellia", "anthurium", "iris", "morning glory"]
    img = image.load_img('a.png', target_size=(224, 224))
    x = image.img_to_array(img)
    x = np.expand_dims(x, axis=0)
    x = preprocess_input(x)
    x = x/255
    with session.graph.as_default():
        set_session(session)
        result = custom_resnet_model_best.predict(x)
        position = result.argmax()
    flower_type = list_flower[position]
    print(result[0][position])
    if(result[0][position]<0.7):
        flower_type = "null" 
    print(position)

    return jsonify(
        flower_type=flower_type
        # score=result[0][position]
    )
    
if __name__ == "__main__":
    global session
    session = tf.compat.v1.Session(graph=tf.Graph())
    with session.graph.as_default():
        set_session(session)
        print("Loading model")
        custom_resnet_model_best = load_model('/home/hoangnv/Desktop/model/vgg16_flower.h5')
    app.run(host= '0.0.0.0', debug=True)
    # global graph
    # graph = tf.get_default_graph()