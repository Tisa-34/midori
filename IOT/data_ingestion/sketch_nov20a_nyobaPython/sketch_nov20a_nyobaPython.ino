#include <ESP32Servo.h>

Servo myservo;  // Buat objek dari kelas Servo

void setup() {
  myservo.attach(14);  // Sambungkan servo ke pin D2
}

void loop() {
  myservo.write(0);       // Putar servo ke posisi 0 derajat
  delay(1000);            // Tunggu selama 1 detik
  myservo.write(90);      // Putar servo ke posisi 90 derajat
  delay(1000);            // Tunggu selama 1 detik
  myservo.write(180);     // Putar servo ke posisi 180 derajat
  delay(1000);            // Tunggu selama 1 detik
}