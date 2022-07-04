package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step04.entity.Member;
import step04.entity.Team;

public class Step04Test {

	static void logic(EntityManager em) {
		// team vs member??? -> team 우선 생성
		Team teamA = new Team();
		teamA.setName("TeamA");
		em.persist(teamA);

		Member member1 = new Member();
		member1.setName("coffee");
		member1.setAge(27);
		member1.setTeam(teamA);
		em.persist(member1);

		teamA.getMembers().add(member1);

		Member member2 = new Member();
		member2.setName("coffee2");
		member2.setAge(28);
		member2.setTeam(teamA);
		em.persist(member2);

		teamA.getMembers().add(member2);

		em.flush();
		em.clear();

		Member findMember = em.find(Member.class, member1.getId());
		System.out.println("member Info : " + findMember.getName());

//		Team findTeam = findMember.getTeam();
//		System.out.println("team Info : " + findTeam.getName());

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
