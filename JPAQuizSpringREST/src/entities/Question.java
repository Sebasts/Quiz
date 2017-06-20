package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne()
	@JoinColumn(name="quiz_id")
	@JsonIgnore
	private Quiz quiz;
	private String content;

	@OneToMany(mappedBy="question", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private Set<Answer> answers;
	
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", quizId=" + /*quizId +*/ ", content=" + content + ", answers=" +/* answers +*/ "]";
	}
	
	
}
