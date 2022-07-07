package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Emp {

	@Id
	private Long empno;

	private String ename;

	private String job;

	private Integer mgr;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime hiredate;

	private Double sal;

	private Double comm;

//	private Integer deptno;

	@ManyToOne(optional = false)
	@JoinColumn(name = "DEPTNO")
	private Dept dept;
}
