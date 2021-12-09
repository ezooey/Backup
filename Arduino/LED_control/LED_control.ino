void setup()
{
//  pinMode(9, OUTPUT); // 아날로그 출력 할 거라 필요없음
}

void loop()
{
  for(int i = 0; i <= 255; i++){
    analogWrite(9, i); // i만큼 중간값을 넣겠다
    delay(10);
  }
}
