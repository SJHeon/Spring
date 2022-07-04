package step03.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
//@Entity
@ToString(exclude = { "members" })
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String name;

	@OneToMany(mappedBy = "team")
	List<Member> members = new ArrayList<Member>();

//	public String toString() {
//		return id + " " + name;
//	}

}
