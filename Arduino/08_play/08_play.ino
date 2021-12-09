const int melody[] = {263, 294, 330, 349, 392, 440, 494, 523};

void setup()
{
  pinMode(11, INPUT);
  pinMode(10, INPUT);
  pinMode(9, INPUT);
}

void loop()
{
  int doBtn = digitalRead(11);
  int reBtn = digitalRead(10);
  int miBtn = digitalRead(9);
  
  if(doBtn == 1){
    tone(3, melody[0], 100);
    delay(50);
  }
  
  if(reBtn == 1){
    tone(3, melody[1], 100);
    delay(50);
  }
  
  if(miBtn == 1){
    tone(3, melody[2], 100);
    delay(50);
  }
}
