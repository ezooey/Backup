package com.kh.example.family.controller;

import com.kh.example.family.model.vo.Baby;
import com.kh.example.family.model.vo.Basic;
import com.kh.example.family.model.vo.Family;
import com.kh.example.family.model.vo.Mother;

public class FamilyController {
	public void method() {
//		Family f = new Family();
		// �߻�Ŭ������ ��ü ���� �Ұ�, ������ ������ ����
		
		Family f1 = new Mother("����", 50, 70, "���");
		Family f2 = new Baby("�Ʊ�", 3.5, 70);
		
//		f1.eat(); // ������+�������̵����� �������ε� ����Ǿ� f1�� ������ Mother�� eat�� ��
//		f2.eat();
		
//		Basic b = new Basic();
		// �������̽��� ��ü ���� �Ұ�, ������ ������ ����
		Basic b1 = new Mother("����", 50, 70, "���");
		Basic b2 = new Baby("�Ʊ�", 3.5, 70);
		
		// ���� ���ε� �� ����
		b1.sleep();
		b2.sleep();
	}

}
