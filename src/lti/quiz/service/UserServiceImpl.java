package lti.quiz.service;

import java.util.Base64;
import java.util.Base64.Encoder;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;
import lti.quiz.dao.UserDao;
import lti.quiz.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public RegisterBean authenticate(LoginBean login) {
		Encoder encoder = Base64.getEncoder();

		String encodedPass = encoder.encodeToString(login.getPassword().getBytes());
		login.setPassword(encodedPass);

		return dao.authenticate(login);
	}

	@Override
	public boolean register(RegisterBean register) {

		Encoder encoder = Base64.getEncoder();

		String encodedPass = encoder.encodeToString(register.getPassword().getBytes());
		String encodedAns = encoder.encodeToString(register.getAnswer().getBytes());
		
		register.setPassword(encodedPass);
		register.setAnswer(encodedAns);

		return dao.register(register);
	}

	@Override
	public boolean validate(ForgetBean forget) {
		Encoder encoder = Base64.getEncoder();
		String encodedAns = encoder.encodeToString(forget.getAnswer().getBytes());
		
		forget.setAnswer(encodedAns);
		
		return dao.validate(forget);
	}

	@Override
	public boolean update(LoginBean change) {
		Encoder encoder = Base64.getEncoder();
		String encodedPass = encoder.encodeToString(change.getPassword().getBytes());
		
		change.setPassword(encodedPass);
		
		return dao.update(change);
	}

}
