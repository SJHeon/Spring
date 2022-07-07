package com.example.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpRestController {

	@Autowired
	EmpServiceImpl empService;

//	CREATE --------------------	
	@PostMapping(value = "/emp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertEmp(@RequestBody Emp emp) {
		emp.setEmpno(emp.getEmpno());
		emp.setEname(emp.getEname());
		emp.setJob(emp.getJob());
		emp.setMgr(emp.getMgr());
		emp.setHiredate(emp.getHiredate());
		emp.setSal(emp.getSal());
		emp.setComm(emp.getComm());
		emp.setDept(emp.getDept());
//		emp.setDeptno(emp.getDeptno());
		empService.insertEmp(emp);
	}

//	READ --------------------	
	@GetMapping(value = "/emps")
	public List<Emp> getEmps() {
		return empService.getEmpAll();
	}

	@GetMapping(value = "/emp/{empno}")
	public Emp getEmpByEmpno(@PathVariable("empno") Long empno) {
		System.out.println(empno);
		return empService.getEmpByEmpno(empno);
	}

//	UPDATE --------------------	
	@PutMapping(value = "emp/{empno}")
//	public void updateEmpByEmpno(@PathVariable("empno") Long empno, @RequestBody HashMap<String, Object> data) {
	public void updateEmpByEmpno(@PathVariable("empno") Long empno, @RequestBody Emp emp) {
		System.out.println(empno);
		System.out.println(emp);
		emp.setEmpno(empno);
//		Emp emp = new Emp(empno, (String) data.get("ename"), (String) data.get("job"), (Integer) data.get("mgr"),
//				(String) data.get("hiredate"), (Double) data.get("sal"), (Double) data.get("comm"),
//				(Integer) data.get("deptno"));
		if (empService.getEmpByEmpno(empno) != null) {
			empService.insertEmp(emp);
		} else {
			System.out.println("없는 empno");
		}
	}

//	DELETE --------------------	

	@DeleteMapping(value = "emp/{empno}")
	public void deleteEmpByEmpno(@PathVariable("empno") Long empno) {
		System.out.println(empno);
		empService.deleteEmpByEmpno(empno);
	}

}
