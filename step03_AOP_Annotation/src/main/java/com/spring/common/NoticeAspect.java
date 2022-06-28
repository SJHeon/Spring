package com.spring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
public class NoticeAspect {

	@Before("execution(* com.spring.aop.Car.buy*(..))")
	// 구매 전 공통 로직
	public void noticeBuyStart() {
		System.out.println("구매 하시겠습니까?");
	}

	// 구매 후 공통 로직
	@After("execution(* com.spring.aop.Car.buy*(..))")
	public void noticeBuyEnd() {
		System.out.println("구매를 완료하셨습니다.");
	}

	// 리턴 값이 있는 메소드에만 적용하는 공통 로직
	@AfterReturning(pointcut = "execution(* com.spring.aop.Car.buy*(..))", returning = "v")
	public void noticeReturnValue(String v) {
		if (v != null) {
			System.out.println("리턴 후 처리 로직 : " + v);
		}
	}

	// 예외 처리를 하는 공통 로직
	@AfterThrowing(pointcut = "execution(* com.spring.aop.Car.sell*(..))", throwing = "exception")
	public void noticeSellException(Exception exception) {
		System.out.println("발생된 예외 : " + exception.getMessage());
	}
}
