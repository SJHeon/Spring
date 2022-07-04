package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	// id
	@Id
	@Column(name = "user_id")
	private Long id;

	// length = 20
	@Column(name = "user_name", length = 20)
	private String name;

	// length = 3
	@Column(name = "user_age", length = 3)
	private Integer age;
}
