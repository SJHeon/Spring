package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicUpdate
@Entity
public class Dept {

	@Id
	@Column(name = "DEPTNO")
	private Long deptno;

	private String dname;

	private String loc;

}

//@Entity // - db에 영향을 주기때문에 set 쓰면 안된다
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Builder
//public class Dept {
//
//	@Id
//	@Column(nullable = false)
//	private Long deptno;
//
//	private String dname;
//
//	private String loc;
//
//	public Dept(Long deptno) {
//		if (deptno != null) {
//			this.deptno = deptno;
//		}
//	}

//}
