package lti.quiz.bean;

public class OptionBean {
	private String option, score;

	public OptionBean(String option, String score) {
		this.option = option;
		this.score = score;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
}
