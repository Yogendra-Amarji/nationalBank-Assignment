package com.fullStack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fullStack.model.Employee;
import com.fullStack.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Employee> listEmployees = employeeService.listAll(keyword);
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("keyword", keyword);
        return "index";
	}
}
