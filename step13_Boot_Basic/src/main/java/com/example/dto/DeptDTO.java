//package com.example.dto;
//
//import javax.persistence.Column;
//import javax.persistence.Id;
//
//import com.example.model.Dept;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class DeptDTO {
//
//	@Id
//	@Column(name = "DEPTNO")
//	private Long deptno;
//
//	private String dname;
//
//	private String loc;
//
//	public DeptDTO(Long deptno) {
//		if (deptno != null) {
//			this.deptno = deptno;
//		}
//	}
//
//	public Dept dtoToEntity(DeptDTO deptDTO) {
//		Dept deptEntity = Dept.builder().dname(deptDTO.getDname()).loc(deptDTO.getLoc()).build();
//
//		return deptEntity;
//	}
//
//}
