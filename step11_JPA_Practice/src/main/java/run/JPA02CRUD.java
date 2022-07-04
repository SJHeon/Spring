package run;

import java.util.List;

import javax.persistence.EntityManager;

import entity.User;

public class JPA02CRUD {
	public static void create(EntityManager em, Long id, String name, Integer age) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);

		em.persist(user);
		System.out.println(user);
	}

	public static void read(EntityManager em, Long id) {
		User user = em.find(User.class, id);
		System.out.println(user);
	}

	public static void readAll(EntityManager em) {
		List<User> allUser = em.createQuery("select m from User m", User.class).getResultList();
		System.out.println(allUser);
	}

	public static void update(EntityManager em, Long id, String name, Integer age) {
		User user = em.find(User.class, id);
		user.setAge(age);
		user.setName(name);
		System.out.println(user);
	}

	public static void delete(EntityManager em, Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}

}
