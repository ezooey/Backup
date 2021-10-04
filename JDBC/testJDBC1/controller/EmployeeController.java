package com.kh.controller;

import com.kh.model.dao.EmployeeDAO;
import com.kh.view.Menu;

public class EmployeeController {
	private Menu menu = new Menu();
	private EmployeeDAO empDAO = new EmployeeDAO();
	
	public void selectAll() {
		empDAO.selectAll();
	}

}
