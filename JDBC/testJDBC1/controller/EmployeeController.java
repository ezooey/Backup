package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;
import com.kh.view.Menu;

public class EmployeeController {
	private Menu menu = new Menu();
	private EmployeeDAO empDAO = new EmployeeDAO();
	
	public void selectAll() {
		ArrayList<Employee> list = empDAO.selectAll(); //list를 반환하기 때문에 ArrayList로 받아줌
		
		if(!list.isEmpty()) {
			// list 안에 저장된 데이터가 있다면 조회결과를 출력하는 view로 이동
			menu.selectAll(list); // list 값을 보고 싶은 거니까 list를 매개변수로 해서 보냄
		} else {
			// list 안에 저장된 데이터가 없다면 에러를 띄우는 view로 이동
			menu.displayError("조회결과가 없습니다.");
		}
		// -> controller는 view와 model을 이어주는 것이기 때문에 어떤 뷰를 보여줄지 결정 가능
	}

	public void selectEmployee() {
		// 사번을 받기 위해 view로 이동
		int empNo = menu.selectEmpNo();
		
		// 전달 받은 값을 DAO로 전달
		Employee emp = empDAO.selectEmployee(empNo);
		
		if(emp != null) {
			menu.selectEmployee(emp);
		} else {
			menu.displayError("해당 사번에 대한 결과가 없습니다.");
		}
	}

	public void insertEmployee() {
		Employee emp = menu.insertEmployee();
		
		int result = empDAO.insertEmployee(emp);
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 추가되었습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}

	public void updateEmployee() {
		int empNo = menu.selectEmpNo();
		
		Employee e = menu.updateEmployee();
		e.setEmpNo(empNo);
		
		int result = empDAO.updateEmployee(e);
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 수정되었습니다.");
		} else {
			menu.displayError("데이터 수정 과정 중 오류 발생");
		}
	}

	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();
		
		char check = menu.deleteEmployee();
		
		if(check == 'y') {
			int result = empDAO.deleteEmployee(empNo);
			
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 삭제되었습니다.");
			} else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
		} else if(check == 'n') {
			menu.displayError("사원 정보 삭제 취소");
		} else {
			menu.displayError("잘못 입력하셨습니다(y 또는 n 입력)");
		}
		
	}

}
