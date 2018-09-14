package lti.quiz.service;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;

public interface UserService {
	 RegisterBean authenticate(LoginBean login);
	 
     boolean register(RegisterBean register);
     
     boolean validate(ForgetBean forget);
     
     boolean update(LoginBean change);
}
