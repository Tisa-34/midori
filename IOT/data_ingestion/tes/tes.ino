#include <WiFi.h>
#include <PubSubClient.h>

const char* ssid = "Mahasiswa";
const char* password = "@Keretacepat2023";

const char* mqtt_server = "broker.hivemq.com";
const char* topic = "polindra/iot/ultrasonik";

// Pin ultrasonik
#define TRIG 14
#define ECHO 12

WiFiClient espClient;
PubSubClient client(espClient);

long readUltrasonic() {
  digitalWrite(TRIG, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG, LOW);

  long duration = pulseIn(ECHO, HIGH);
  long distance = duration * 0.034 / 2;
  return distance;
}

void setup_wifi() {
  delay(10);
  Serial.println("Connecting to WiFi...");
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("\nWiFi connected");
}

void reconnect() {
  while (!client.connected()) {
    Serial.print("Connecting to MQTT...");
    if (client.connect("ESP32Client")) {
      Serial.println("connected");
    } else {
      Serial.print("Failed, rc=");
      Serial.println(client.state());
      delay(2000);
    }
  }
}

void setup() {
  Serial.begin(115200);

  pinMode(TRIG, OUTPUT);
  pinMode(ECHO, INPUT);

  setup_wifi();
  client.setServer(mqtt_server, 1883);
}

void loop() {
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  long jarak = readUltrasonic();
  Serial.print("Jarak: ");
  Serial.println(jarak);

  // Convert ke string
  char msg[10];
  sprintf(msg, "%ld", jarak);

  // Publish ke MQTT
  client.publish(topic, msg);

  delay(1000);
}
