package lti.quiz.dao;

import java.util.List;

import lti.quiz.bean.QuizBean;

public interface QuizDao {
	List<QuizBean> loadQuiz();
	
	String getResult(String code);
}
