package com.example.service;

import java.util.List;

import com.example.model.Dept;

public interface DeptService {
	public List<Dept> getDeptAll();

	public Dept getDeptByDeptno(Long deptno);

	public Dept insertDept(Dept dept);

	public void deleteDeptByDeptno(Long deptno);

}
