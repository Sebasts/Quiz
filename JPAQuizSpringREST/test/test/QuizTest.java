package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Quiz;

public class QuizTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAQuizSpringREST");
		em = emf.createEntityManager();
	}

	@Test
	public void test_address_country_mappings() {
		Quiz q = em.find(Quiz.class, 1);
		

		assertEquals("food", q.getName());


	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
