package lti.quiz.service;

import java.util.List;

import lti.quiz.bean.QuizBean;

public interface QuizService {
	List<QuizBean> loadQuiz();
	
	String getResult(List<String> scores);
}
