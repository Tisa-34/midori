import paho.mqtt.client as mqtt
import mysql.connector

cnx = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="",
    database='iot_db')


cur = cnx.cursor()

tesTambahData = "INSERT INTO sersor (ultrasonik, waktu) VALUES (%s, NOW())"
#tesTambahData = ("INSERT INTO sensor " "(ultrasonik)" "VALUES (%s)")
data_ultrasonik = ("100",)
cur.execute(tesTambahData, data_ultrasonik)
cnx.commit()
cur.close()


# Close connection
cnx.close()


def on_connect(client, userdata, flags, reason_code, properties):
    print(f"Connected with result code {reason_code}")
    client.subscribe("polindra/iot")

def on_message(client, userdata, msg):
    print(msg.topic+" "+str(msg.payload)) #pesan yang keluar di terminal itu dari kodingan ini

mqttc = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
mqttc.on_connect = on_connect
mqttc.on_message = on_message

mqttc.connect("broker.hivemq.com", 1883, 60)

mqttc.loop_forever()