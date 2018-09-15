package lti.quiz.bean;

import java.util.ArrayList;
import java.util.List;

public class QuizBean {
	private int id;
	private String question;
	private ArrayList<OptionBean> options;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<OptionBean> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<OptionBean> options) {
		this.options = options;
	}
}
