package lti.quiz.dao;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;

public interface UserDao {
	RegisterBean authenticate(LoginBean login);
	 
    boolean register(RegisterBean register);
    
    boolean validate(ForgetBean forget);
    
    boolean update(LoginBean change);
}
