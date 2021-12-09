void setup()
{
  // 직렬통신 초기화(9600비트로 데이터 전송)
  Serial.begin(9600);
  pinMode(7, INPUT);
  pinMode(8, OUTPUT);
}

void loop()
{
  int readValue = digitalRead(7);
  Serial.println(readValue);
 // if(readValue == 1){
  if(readValue == HIGH){
    digitalWrite(8, 1); // HIGH를 1로 바꿔도 됨
 // } else if(readValue == 0){
  } else if(readValue == LOW){
    digitalWrite(8, 0); // LOW를 0으로 바꿔도 됨
  }
}
