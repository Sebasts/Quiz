package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.QuizDAO;
import entities.Question;
import entities.Quiz;

@RestController
public class QuizController {

	@Autowired
	private QuizDAO dao;

	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path = "quizzes", method = RequestMethod.GET)
	public List<Quiz> index() {
		return dao.index();
	}

	@RequestMapping(path = "quizzes/{id}", method = RequestMethod.GET)
	public Quiz show(@PathVariable int id) {
		return dao.show(id);
	}

	@RequestMapping(path = "quizzes", method = RequestMethod.POST)
	public Quiz create(@RequestBody String quizJSON, HttpServletResponse res) {
		ObjectMapper om = new ObjectMapper();
		Quiz q = null;
		try {
			q = om.readValue(quizJSON, Quiz.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.create(q);
		res.setStatus(201);
		return q;

	}

	@RequestMapping(path="quizzes/update/{id}", method=RequestMethod.PUT)
	public Quiz update(@PathVariable int id, @RequestBody String quizJSON, HttpServletResponse res) {
		ObjectMapper om = new ObjectMapper();
		Quiz quiz = null;
		try {
			quiz = om.readValue(quizJSON, Quiz.class);
			return dao.update(id, quiz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		res.setStatus(417);
		return quiz;
	}
	
	@RequestMapping(path="quizzes{id}", method=RequestMethod.DELETE)
	 public boolean destroy(@PathVariable int id){
		 if(dao.destroy(id)){
			 return true;
		 }
		 return false;
	 }
	
	@RequestMapping(path="quizzes/questions/{id}", method=RequestMethod.GET)
	 public Set<Question> showQuestions(int id){
		 return dao.showQuestions(id);
	 }
	
	// public Question createQuestions(int id, String questionJson,
	// HttpServletResponse res);
	// public boolean destroyQuestions(int id, int questid);
}
