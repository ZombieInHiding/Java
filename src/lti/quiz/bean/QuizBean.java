package lti.quiz.bean;

import java.util.ArrayList;

public class QuizBean {
	private String question;
	private ArrayList<OptionBean> options;
	
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
