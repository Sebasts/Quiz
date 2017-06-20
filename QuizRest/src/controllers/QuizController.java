package controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Quiz;

@RestController
public class QuizController {
	
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping(){
		return "pong";
	}
	

//	public List<Quiz> index();
//	public Quiz show(int id);
//	public Quiz create(String quizJSON, HttpServletResponse res);
//	public Quiz update(int id, String quizJSON, HttpServletResponse res);
//	public boolean destroy(int id);
//	public Set<Question> showQuestions(int id);
//	public Question createQuestions(int id, String questionJson, HttpServletResponse res);
//	public  boolean destroyQuestions(int id, int questid);
}
