package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Question;
import entities.Quiz;

@Transactional
public class QuizDAOImpl implements QuizDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Quiz> index() {
		String query = "SELECT q from Quiz q";
		return em.createQuery(query, Quiz.class).getResultList();
	}

	@Override
	public Quiz show(int id) {
		String query = "SELECT q from Quiz q WHERE id = :id";
		return em.createQuery(query, Quiz.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Quiz create(Quiz quiz) {
		em.persist(quiz);
		em.flush();
		return quiz;
	}

	@Override
	public Quiz update(int id, Quiz quiz) {
		Quiz temp = em.find(Quiz.class, id);
		temp.setName(quiz.getName());
		em.merge(temp);
		em.flush();
		return temp;
	}

	@Override
	public boolean destroy(int id) {
		try{
		em.remove(em.find(Quiz.class, id));
		return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
		 public Set<Question> showQuestions(int id){
			 return em.find(Quiz.class, id).getQuestions();
		 }
		 
		 public Question createQuestion(int id, Question q){
			 Quiz quiz = em.find(Quiz.class, id);
			 quiz.getQuestions().add(q);
			 em.merge(quiz);
			 em.flush();
			 return q;
		 }
		 

		@Override
		public boolean destroyQuestion(int id, int questid) {
			try{
			em.remove(em.find(Question.class, questid));
			return true;
			} catch(Exception e){
				e.printStackTrace();
				return false; 
			}
		}

}
