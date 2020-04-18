#include <Servo.h>
char incomingByte;  // incoming data
int  Zona1 = 22;//4;      // LED pin
int  Zona2 = 24;//7;
int  Zona3 = 26;//8;
int  Zona4 = 28;//12;
int  Zona5 = 30;//13;
int  Zona6 = 32;//14;
int  Zona7 = 34;//15;
int  Zona8 = 36;//16;
// motores
int m1i= 40;
int m1d= 41;
int m2i= 42;
int m2d= 43;
int m3i= 44;
int m3d= 45;
int m4i= 46;
int m4d= 47;



//Nombrar los Servos
Servo puerta1;
Servo puerta2;
Servo puerta3;
Servo puerta4;
Servo ventana1;
Servo ventana2;
Servo ventana3;

//Determinar los pines a usar para los Servos
int puerta1Pin = 2;//3;
int puerta2Pin = 3;//5;
int puerta3Pin = 4;//6;
int puerta4Pin = 5;//9;
int ventana1Pin = 6;//10;
int ventana2Pin = 7;//11;
int ventana3Pin = 8;

//Variables para almacenar la posición de los Servos
int p1=5;
int p2=5;
int p3=5;
int p4=5;
int v1=5;
int v2=5;
int v3=5;


void setup() {
Serial.begin(9600); // initialization

//Pines para conectar los Servos
  puerta1.attach(puerta1Pin);
  puerta2.attach(puerta2Pin);
  puerta3.attach(puerta3Pin);
  puerta4.attach(puerta4Pin);
  ventana1.attach(ventana1Pin);
  ventana2.attach(ventana2Pin);
  ventana3.attach(ventana3Pin);
  
 //Configuramos los pines como salidas.
 pinMode(Zona1, OUTPUT);
 pinMode(Zona2, OUTPUT);
 pinMode(Zona3, OUTPUT);
 pinMode(Zona4, OUTPUT);
 pinMode(Zona5, OUTPUT);
 pinMode(Zona6, OUTPUT);
 pinMode(Zona7, OUTPUT);
 pinMode(Zona8, OUTPUT);
 // ventanas
 pinMode(m1i, OUTPUT);
 pinMode(m1d, OUTPUT);
 pinMode(m2i, OUTPUT);
 pinMode(m2d, OUTPUT);
 pinMode(m3i, OUTPUT);
 pinMode(m3d, OUTPUT);
 pinMode(m4i, OUTPUT);
 pinMode(m4d, OUTPUT);

 //Inician todas las puertas y ventanas cerradas

 puerta1.write(p1);
 puerta2.write(p2);
 puerta3.write(p3);
 puerta4.write(p4);
 ventana1.write(v1);
 ventana2.write(v2);
 ventana3.write(v3);
}

void loop() {
  if (Serial.available() > 0) {  // if the data came
    incomingByte = Serial.read(); // read byte
    //LEDs
    if(incomingByte == 'a') {
       digitalWrite(Zona1, LOW);  // if A, switch Zona5 Off
    }
    if(incomingByte == 'A') {
       digitalWrite(Zona1, HIGH); // if a, switch Zona1 on
    }
    if(incomingByte == 'b') {
       digitalWrite(Zona2, LOW);  // if B, switch Zona2 Off  
    }
    if(incomingByte == 'B') {
       digitalWrite(Zona2, HIGH); // if b, switch Zona2 on
    }
    if(incomingByte == 'c') {
       digitalWrite(Zona3, LOW); 
    }
    if(incomingByte == 'C') {
       digitalWrite(Zona3, HIGH);
    }
    if(incomingByte == 'd') {
       digitalWrite(Zona4, LOW); 
    }
    if(incomingByte == 'D') {
       digitalWrite(Zona4, HIGH);
    }
    if(incomingByte == 'e') {
       digitalWrite(Zona5, LOW); 
    }
    if(incomingByte == 'E') {
       digitalWrite(Zona5, HIGH);
    }
    if(incomingByte == 'f') {
       digitalWrite(Zona6, LOW); 
    }
    if(incomingByte == 'F') {
       digitalWrite(Zona6, HIGH);
    }
    if(incomingByte == 'g') {
       digitalWrite(Zona7, LOW); 
    }
    if(incomingByte == 'G') {
       digitalWrite(Zona7, HIGH);
    }
    if(incomingByte == 'h') {
       digitalWrite(Zona8, LOW); 
    }
    if(incomingByte == 'H') {
       digitalWrite(Zona8, HIGH);
    }
    //Servos
    if(incomingByte == 'I') {

      if(p1<180){
       for (p1; p1 <= 180; p1 += 1) { // goes from 0 degrees to 180 degrees
    // in steps of 1 degree
    puerta1.write(p1);              // tell servo to go to position in variable 'pos'
    delay(15); 
    }
    }
    }
    if(incomingByte == 'i') {
       if(p1>0){
       for (p1; p1 >= 5; p1 -= 1) { // goes from 180 degrees to 0 degrees
    puerta1.write(p1);              // tell servo to go to position in variable 'pos'
    delay(15);                       // waits 15ms for the servo to reach the position
    }
    }
    }
    if(incomingByte == 'J') {

      if(p2<180){
       for (p2; p2 <= 180; p2 += 1) { // goes from 0 degrees to 180 degrees
    // in steps of 1 degree
    puerta2.write(p2);              // tell servo to go to position in variable 'pos'
    delay(15); 
    }
    }
    }
    if(incomingByte == 'j') {
       if(p2>0){
       for (p2; p2 >= 5; p2 -= 1) { // goes from 180 degrees to 0 degrees
    puerta2.write(p2);              // tell servo to go to position in variable 'pos'
    delay(15);                       // waits 15ms for the servo to reach the position
    }
    }
    }
    if(incomingByte == 'K') {

      if(p3<180){
       for (p3; p3 <= 180; p3 += 1) { // goes from 0 degrees to 180 degrees
    // in steps of 1 degree
    puerta3.write(p3);              // tell servo to go to position in variable 'pos'
    delay(15); 
    }
    }
    }
    if(incomingByte == 'k') {
       if(p3>0){
       for (p3; p3 >= 5; p3 -= 1) { // goes from 180 degrees to 0 degrees
    puerta3.write(p3);              // tell servo to go to position in variable 'pos'
    delay(15);                       // waits 15ms for the servo to reach the position
    }
    }
    }
    if(incomingByte == 'L') {
       digitalWrite(m1i, LOW); 
       digitalWrite(m1d, HIGH); 
       delay(2000); 
       digitalWrite(m1i, LOW); 
       digitalWrite(m1d, LOW); 
       delay(10); 
      
    }

    if(incomingByte == 'l') {
       digitalWrite(m1i, HIGH); 
       digitalWrite(m1d, LOW); 
       delay(2000); 
       digitalWrite(m1i, LOW); 
       digitalWrite(m1d, LOW); 
       delay(10); 
      
    }
    if(incomingByte == 'M') {
       digitalWrite(m2i, HIGH); 
       digitalWrite(m2d, LOW); 
       delay(2000); 
       digitalWrite(m2i, LOW); 
       digitalWrite(m2d, LOW); 
       delay(10); 
    }
    if(incomingByte == 'm') {
       digitalWrite(m2i, LOW); 
       digitalWrite(m2d, HIGH); 
       delay(2000); 
       digitalWrite(m2i, LOW); 
       digitalWrite(m2d, LOW); 
       delay(10); 
    }
    if(incomingByte == 'N') {

       digitalWrite(m3i, HIGH); 
       digitalWrite(m3d, LOW); 
       delay(2000); 
       digitalWrite(m3i, LOW); 
       digitalWrite(m3d, LOW); 
       delay(10); 
    }
    if(incomingByte == 'n') {

       digitalWrite(m3i, LOW); 
       digitalWrite(m3d, HIGH); 
       delay(2000); 
       digitalWrite(m3i, LOW); 
       digitalWrite(m3d, LOW); 
       delay(10); 
    }
    if(incomingByte == 'O') {

       digitalWrite(m4i, HIGH); 
       digitalWrite(m4d, LOW); 
       delay(2000); 
       digitalWrite(m4i, LOW); 
       digitalWrite(m4d, LOW); 
       delay(10); 
    }
    if(incomingByte == 'o') {

       digitalWrite(m4i, LOW); 
       digitalWrite(m4d, HIGH); 
       delay(2000); 
       digitalWrite(m4i, LOW); 
       digitalWrite(m4d, LOW); 
       delay(10); 
    }
  }
}
