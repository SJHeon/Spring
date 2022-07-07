package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Emp;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Emp insertEmp(Emp emp) {
		return empRepository.save(emp);
	}

	@Override
	public List<Emp> getEmpAll() {
		return empRepository.findAll();
	}

	@Override
	public Emp getEmpByEmpno(Long empno) {
		return empRepository.findEmpByEmpno(empno);
	}

	@Override
	public void deleteEmpByEmpno(Long empno) {
		empRepository.deleteById(empno);
	}

}
