int i = 100;
void setup()
{
  pinMode(8, OUTPUT);
}

void loop()
{
  digitalWrite(8, HIGH);
  delay(i);
  digitalWrite(8, LOW);
  delay(1000);
  i += 100;
  if(i >= 2000){
    i = 100;
  }
}
