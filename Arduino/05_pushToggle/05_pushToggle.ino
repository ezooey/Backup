boolean current = LOW;
boolean last = LOW;
boolean led = false;
void setup()
{
  Serial.begin(9600);
  pinMode(7, INPUT);
  pinMode(8, OUTPUT);
}

void loop()
{
  current = digitalRead(7);
  Serial.println(current);
  
  if(last == LOW && current == HIGH){
    led =! led;
  }
  last = current;
  digitalWrite(8, led);
}
