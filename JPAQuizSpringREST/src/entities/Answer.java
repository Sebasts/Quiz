package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="question_id")
	private int questionId;
	private String content;
	private byte isCorrect;
	@ManyToOne()
	@JoinColumn(name="question_id", insertable=false, updatable=false)
	@JsonIgnore
	private Question question;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(byte isCorrect) {
		this.isCorrect = isCorrect;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", questionId=" + questionId + ", content=" + content + ", isCorrect=" + isCorrect
				+ "]";
	}
	
	
	
}
