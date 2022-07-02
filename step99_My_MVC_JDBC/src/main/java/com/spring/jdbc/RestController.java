package com.spring.jdbc;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
//@CrossOrigin("http://localhost:3000/")
public class RestController {
	@Autowired
	private DeptServiceImpl deptService;

//	CREATE ---------------------------------------------------------
	@PostMapping(value = "/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
	}

//	 READ  ---------------------------------------------------------
	// select All Depts
	@GetMapping(value = "/dept")
	public List<Dept> getAllDepts() {
		System.out.println(deptService.getAllDepts());
		return deptService.getAllDepts();
	}

	// select By Deptno
	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable int deptno) {
		System.out.println(deptno);
		System.out.println(deptService.getDeptByDeptno(deptno));
		return deptService.getDeptByDeptno(deptno);
	}

//	UPDATE ---------------------------------------------------------
	// update dname and loc By Deptno
	@PutMapping(value = "/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDeptByDeptno(@PathVariable("deptno") int deptno, @RequestBody HashMap<String, Object> data) {
		System.out.println(deptno);
		System.out.println(data);
		Dept dept = new Dept(deptno, (String) data.get("dname"), (String) data.get("loc"));
		deptService.updateDeptByDeptno(dept);
	}

//	DELETE ---------------------------------------------------------
	@DeleteMapping(value = "dept/{deptno}")
	public void deleteDept(@PathVariable("deptno") int deptno) {
		deptService.deleteDept(deptno);
	}
}
