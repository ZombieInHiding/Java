package lti.quiz.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;
import lti.quiz.service.UserService;
import lti.quiz.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user.quiz") // Annotations
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;

	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer"); // For identifying which jsp is accessing the controller

		if (referer.contains("index")) {
			// Request is for login authentication
			LoginBean login = new LoginBean();

			// Reading request parameters
			login.setEmail(request.getParameter("email"));
			login.setPassword(request.getParameter("password"));

			if (service.authenticate(login) != null) {
				// Login successful
				response.sendRedirect("dashboard.jsp");
			} else {
				// Login failed
				response.sendRedirect("index.jsp?invalid=yes");
			}
		}

		else if (referer.contains("register")) {
			// Request is for user registration
			RegisterBean register = new RegisterBean();

			// Reading request parameters
			register.setEmail(request.getParameter("email"));
			register.setPassword(request.getParameter("password"));
			register.setAnswer(request.getParameter("hero"));

			if (service.register(register)) {
				response.sendRedirect("index.jsp");
			}

		}

		else if (referer.contains("forget")) {
			// Request to validate user
			ForgetBean forget = new ForgetBean();

			// Reading request parameters
			forget.setEmail(request.getParameter("email"));
			forget.setAnswer(request.getParameter("hero"));

			if (service.validate(forget)) {
				response.sendRedirect("change.jsp");
			} else
				response.sendRedirect("forget.jsp?invalid=yes");

		}

		else {
			// request to change Password
			LoginBean change = new LoginBean();

			// Reading request parameters
			change.setEmail(request.getParameter("email"));
			change.setPassword(request.getParameter("password"));

			if (service.update(change)) {
				response.sendRedirect("index.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
