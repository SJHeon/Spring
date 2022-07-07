package com.example.service;

import java.util.List;

import com.example.model.Emp;

public interface EmpService {
	public List<Emp> getEmpAll();

	public Emp getEmpByEmpno(Long empno);

	public Emp insertEmp(Emp emp);

	public void deleteEmpByEmpno(Long empno);
}
