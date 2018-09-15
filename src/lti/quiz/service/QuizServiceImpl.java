package lti.quiz.service;

import java.util.Arrays;
import java.util.List;

import lti.quiz.bean.QuizBean;
import lti.quiz.dao.QuizDao;
import lti.quiz.dao.QuizDaoImpl;

public class QuizServiceImpl implements QuizService {
	private QuizDao dao;
	private String[] codes = {"SP","SM","IM","BM","DP","BP","HK"};
	
	public QuizServiceImpl() {
		dao = new QuizDaoImpl();
	}
	
	@Override
	public List<QuizBean> loadQuiz() {
		List<QuizBean> questions = dao.loadQuiz();
		return questions;
	}

	@Override
	public String getResult(List<String> scores) {
		int[] result = new int[7];
		for (String value : scores) {
			String[] star = value.split("");
			for (int i = 0; i < star.length; i++) {
				result[i] += Integer.parseInt(star[i]);
			}
		}
		int[] clone = result.clone();
		Arrays.sort(clone);
		
		int idx = -1;
		for(int i=0;i<result.length; i++) {
			if(result[i] == clone[6]) {
				idx = i;
				break;
			}
		}
		return dao.getResult(codes[idx]);
	}
}
