package step03.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("p1")
public class People {
	private String name;
	private int age;

	@Autowired
	private Car myCar;

	public People() {
		System.out.println("People 기본 생성자");
	}

	public People(String name, int age, Car myCar) {
		this.name = name;
		this.age = age;
		this.myCar = myCar;
		System.out.println("People 생성자");
	}
}
