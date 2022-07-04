package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAFinalTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02_JPA_Basic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
//			JPA02CRUD.create(em, (long) 1, "heon", 26);
//			JPA02CRUD.create(em, (long) 2, "jong", 26);
//			JPA02CRUD.create(em, (long) 3, "seong", 26);
//			JPA02CRUD.read(em, (long) 2);
			JPA02CRUD.readAll(em);
//			JPA02CRUD.update(em, (long) 1, "jong1", 29);
//			JPA02CRUD.delete(em, (long) 1);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
