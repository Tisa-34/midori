import mysql.connector
import paho.mqtt.client as mqtt

cnx = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="",
    database='iot_db'
)
cur = cnx.cursor()

# Query insert
query_insert = "INSERT INTO sersor (ultrasonik, waktu) VALUES (%s, NOW())"

def on_connect(client, userdata, flags, reason_code, properties):
    print(f"Connected with result code {reason_code}")
    client.subscribe("polindra/iot/ultrasonic")

def on_message(client, userdata, msg):
    payload = msg.payload.decode()

    print(f"{msg.topic} : {payload}")

    # Insert ke database setiap ada pesan baru
    try:
        cur.execute(query_insert, (payload,))
        cnx.commit()
        print("Data disimpan ke database.")
    except Exception as e:
        print("Gagal insert:", e)


mqttc = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
mqttc.on_connect = on_connect
mqttc.on_message = on_message

mqttc.connect("broker.hivemq.com", 1883, 60)

mqttc.loop_forever()
