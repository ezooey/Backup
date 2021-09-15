package com.kh.example.chap06_method.model.vo;

public class Trainee {
	// - name:String
	// - ACADEMY:String = "KH"
	// - classRoom:char
	// - time:String
	// - score:double
	//	 ------------
	
	// + Trainee()	// 생성자
	// + Trainee(name:String, classRoom:char, time:String, score:double)
	
	private String name;
	private final String ACADEMY = "KH";
	private char classRoom;
	private String time;
	private static double score;
	
	public Trainee() {	// 기본생성자
		
	}

	public Trainee(String name, char classRoom, String time, double score) { // 매개변수 생성자(초기화해야)
		this.name = name;
		// ACADEMY가 들어가지 않은 이유? ACADEMY는 final변수(=상수)이기 때문에 값 변경x
		//							생성자에서 새로운 값으로 초기화 불가능하기 때문에 제외됨
		this.classRoom = classRoom;
		this.time = time;
		Trainee.score = score;
		// this.score에 경고성 메세지가 뜨는 이유? this는 자신의 주소 값을 갖고 있는 레퍼런스 변수(=참조변수)
		//									주소 값을 가진다는 말은 heap 메모리 영역에 공간이 생겼다는 뜻, 즉 객체가 생겼다
		//									다시 말해, this로 접근하는 것은 객체를 만들어 접근하는 것과 같음
		//									static 변수/메소드는 객체를 만들어 접근할 게 아니라 클래스명. 으로 접근해야 함

	}

	public String inform() {
		return ACADEMY + " " + name + " 훈련생은 " + classRoom + time + "반이고, 점수는 " + score + "점입니다.";
	}
	
	// 지금까지는 필드에 있는 값을 초기화 하고 싶으면 매개변수 있는 생성자를 이용하였음
	// 매개변수 있는 생성자를 이용하여 값이 들어가 있는 채로 객체를 만들었는데
	// 데이터 값이 잘못됐을 경우, 어떻게 데이터를 수정할 것인가?
	// -> 필드 하나씩만 갖고 있는 객체를 만들면 되지 않을까? X
	// 일부 필드만 데이터를 조회하고 싶으면 어떻게 할 것인가?
	
	// name에 대한 setter, getter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {	// 값을 뱉어낼 거니까 매개변수 필요없음
		return name;
	}
	
	// ACADEMY에 대한 getter // ACADEMY는 상수니까 값 변경 불가, setter 불가
	public String getACADEMY() {
		return ACADEMY;
	}
	
	// classRoom에 대한 setter, getter
	public void setClassRoom(char classRoom) {
		this.classRoom = classRoom;
	}
	
	public char getClassRoom() {
		return classRoom;
	}
	
	// time에 대한 setter, getter
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	// score에 대한 setter, getter
	public static void setScore(double score) {
		Trainee.score = score;		// static이니까 this. 대신 Trainee.
	}
	public static double getScore() {
		return score;
	}
}
