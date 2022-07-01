package com.spring.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
// @Controller + @Responsebody
@RequestMapping("/api")
public class RestController {
	@Autowired
	private DeptServiceImpl deptService;

//	CREATE ---------------------------------------------------------
	@PostMapping(value = "/insertDept", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@PostMapping(value = "/deptform", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // consumes의 기본값이.
	public void insertDeptForm(@ModelAttribute Dept dept) { // 기본 form형태 데이터 받는것, 기본값이다.
		System.out.println(dept);
		deptService.insertDept(dept);
	}

//	 READ  ---------------------------------------------------------
	// selectAll
	@GetMapping(value = "/getDepts")
	public List<Dept> getAllDepts() {
		System.out.println(deptService.getAllDepts());
		return deptService.getAllDepts();
	}

	// select
	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable int deptno) {
		System.out.println(deptno);
		System.out.println(deptService.getDeptByDeptno(deptno));
		return deptService.getDeptByDeptno(deptno);
	}

//	UPDATE ---------------------------------------------------------
	@PutMapping(value = "/updateDept")
	public void updateDeptByDeptnoAndDname(Map data) {
		System.out.println(data);
		deptService.updateDeptByDeptnoAndDname(data);
	}

	@PutMapping(value = "/updateDept/{dept.deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeptByDeptno(@PathVariable("dept.deptno") int deptno, Map data) {
		System.out.println(deptno);
		deptService.updateDeptByDeptno(deptno, data);
	}

//	DELETE ---------------------------------------------------------
	@DeleteMapping(value = "/deleteDept")
	public void deleteDept(String loc) {
		deptService.deleteDept(loc);
	}
}
