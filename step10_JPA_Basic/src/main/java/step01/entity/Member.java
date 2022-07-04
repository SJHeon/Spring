package step01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
	@Id
	@Column(name = "memger_id", length = 40)
	private String id;

	@Column(name = "user_name")
	private String userName;

	private int age;
}
