package step02.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class People {
	private String name;
	private int age;

	@Autowired(required = false) // (required = true(default))참조하는 것이 있어쟈만 DI가 가능
	@Qualifier("c3") // 한정된 Bean에 한해서만 참조가능
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
