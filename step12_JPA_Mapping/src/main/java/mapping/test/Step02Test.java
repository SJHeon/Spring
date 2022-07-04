package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step02.entity.Member;
import step02.entity.Team;

public class Step02Test {

	static void logic(EntityManager em) {
		// team vs member??? -> team 우선 생성
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);

		Member member2 = new Member();
		member2.setName("yh");
		member2.setAge(26);
		member2.setTeam(team);
		em.persist(member2);

		Member member02 = em.find(Member.class, 1L);
		System.out.println(member02);

		Team team02 = em.find(Team.class, team.getId());
		System.out.println(team02);
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA_Mapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // 안해줘도 되지만 명시적으로 해주는 편
		} finally {
			em.clear();
			emf.close();
		}
	}

}
