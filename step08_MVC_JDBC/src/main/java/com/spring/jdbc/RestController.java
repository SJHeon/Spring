package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
// @Controller + @Responsebody
public class RestController {
	@Autowired
	private DeptServiceImpl deptService;

	@GetMapping(value = "/api/test")
	public String apiTest() {
		return "test";
	}

	@PostMapping(value = "/api/dept")
	public void insertDept(Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@GetMapping(value = "/api/getDepts")
	public List<Dept> getAllDepts() {
		System.out.println(deptService.getAllDepts());
		return deptService.getAllDepts();
	}

	@PostMapping(value = "/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@PostMapping(value = "/api/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // consumes의 기본값이.
	public void insertDeptForm(@ModelAttribute Dept dept) { // 기본 form형태 데이터 받는것, 기본값이다.
		System.out.println(dept);
		deptService.insertDept(dept);
	}
}
