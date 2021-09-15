package com.kh.example.chap06_method.model.vo;

public class Trainee {
	// - name:String
	// - ACADEMY:String = "KH"
	// - classRoom:char
	// - time:String
	// - score:double
	//	 ------------
	
	// + Trainee()	// ������
	// + Trainee(name:String, classRoom:char, time:String, score:double)
	
	private String name;
	private final String ACADEMY = "KH";
	private char classRoom;
	private String time;
	private static double score;
	
	public Trainee() {	// �⺻������
		
	}

	public Trainee(String name, char classRoom, String time, double score) { // �Ű����� ������(�ʱ�ȭ�ؾ�)
		this.name = name;
		// ACADEMY�� ���� ���� ����? ACADEMY�� final����(=���)�̱� ������ �� ����x
		//							�����ڿ��� ���ο� ������ �ʱ�ȭ �Ұ����ϱ� ������ ���ܵ�
		this.classRoom = classRoom;
		this.time = time;
		Trainee.score = score;
		// this.score�� ��� �޼����� �ߴ� ����? this�� �ڽ��� �ּ� ���� ���� �ִ� ���۷��� ����(=��������)
		//									�ּ� ���� �����ٴ� ���� heap �޸� ������ ������ ����ٴ� ��, �� ��ü�� �����
		//									�ٽ� ����, this�� �����ϴ� ���� ��ü�� ����� �����ϴ� �Ͱ� ����
		//									static ����/�޼ҵ�� ��ü�� ����� ������ �� �ƴ϶� Ŭ������. ���� �����ؾ� ��

	}

	public String inform() {
		return ACADEMY + " " + name + " �Ʒû��� " + classRoom + time + "���̰�, ������ " + score + "���Դϴ�.";
	}
	
	// ���ݱ����� �ʵ忡 �ִ� ���� �ʱ�ȭ �ϰ� ������ �Ű����� �ִ� �����ڸ� �̿��Ͽ���
	// �Ű����� �ִ� �����ڸ� �̿��Ͽ� ���� �� �ִ� ä�� ��ü�� ������µ�
	// ������ ���� �߸����� ���, ��� �����͸� ������ ���ΰ�?
	// -> �ʵ� �ϳ����� ���� �ִ� ��ü�� ����� ���� ������? X
	// �Ϻ� �ʵ常 �����͸� ��ȸ�ϰ� ������ ��� �� ���ΰ�?
	
	// name�� ���� setter, getter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {	// ���� �� �Ŵϱ� �Ű����� �ʿ����
		return name;
	}
	
	// ACADEMY�� ���� getter // ACADEMY�� ����ϱ� �� ���� �Ұ�, setter �Ұ�
	public String getACADEMY() {
		return ACADEMY;
	}
	
	// classRoom�� ���� setter, getter
	public void setClassRoom(char classRoom) {
		this.classRoom = classRoom;
	}
	
	public char getClassRoom() {
		return classRoom;
	}
	
	// time�� ���� setter, getter
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	// score�� ���� setter, getter
	public static void setScore(double score) {
		Trainee.score = score;		// static�̴ϱ� this. ��� Trainee.
	}
	public static double getScore() {
		return score;
	}
}
