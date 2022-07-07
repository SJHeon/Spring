package com.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@RestController
@RequestMapping("/api")
public class DeptRestController {

	@Autowired
	DeptServiceImpl deptService;

//	CREATE --------------------	
	@PostMapping(value = "/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDept(@RequestBody Dept dept) {
		dept.setDeptno(dept.getDeptno());
		dept.setDname(dept.getDname());
		dept.setLoc(dept.getLoc());
		deptService.insertDept(dept);
	}

//	READ ----------------------	

	@GetMapping(value = "/depts")
	public List<Dept> getDepts() {
		return deptService.getDeptAll();
	}

	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable("deptno") Long deptno) {
		System.out.println(deptno);
		return deptService.getDeptByDeptno(deptno);
	}

//	UPDATE --------------------	
	// dynamicUpdate??

	@PutMapping(value = "/dept/{deptno}")
	public void updateDeptByDeptno(@PathVariable("deptno") Long deptno, @RequestBody HashMap<String, Object> data) {
		System.out.println(deptno);
		System.out.println(data);

		Dept dept = new Dept(deptno, (String) data.get("dname"), (String) data.get("loc"));
		System.out.println(dept);
		if (deptService.getDeptByDeptno(deptno) != null) {
			deptService.insertDept(dept);
		} else {
			System.out.println("없는 deptno");
		}
	}

//	DELETE --------------------	
	@Transactional
	@DeleteMapping(value = "/dept/{deptno}")
	public void deleteDeptByDeptno(@PathVariable("deptno") Long deptno) {
		System.out.println(deptno);
		deptService.deleteDeptByDeptno(deptno);
	}

}
