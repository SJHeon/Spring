package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper deptMapper;

	@Override
	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}

	@Override
	public String getDeptNameByDeptno(int deptno) {
		return deptMapper.getDeptNameByDeptno(deptno);
	}

	@Override
	public HashMap<String, Object> getDeptMap(int deptno) {
		return deptMapper.getDeptMap(deptno);
	}

	@Override
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}

	@Override
	public List<HashMap<String, Object>> getAllDeptsMap() {
		return deptMapper.getAllDeptsMap();
	}

	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	}

	@Override
	public void updateDeptByDeptnoAndDname(Map data) {
		deptMapper.updateDeptByDeptnoAndDname(data);
	}

	@Override
	public void updateDeptByDeptno(Dept dept) {
		deptMapper.updateDeptByDeptno(dept);
	}

	@Override
	public void deleteDept(String loc) {
		deptMapper.deleteDept(loc);
	}

	@Override
	public void deleteDept(int deptno) {
		deptMapper.deleteDept(deptno);
	}

}
