package lti.quiz.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.OptionBean;
import lti.quiz.bean.QuizBean;
import lti.quiz.bean.RegisterBean;
import lti.quiz.dao.QuizDaoImpl;
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
		// Creates a  fresh new session in the server if no session id  found in request header,
		// otherwise old session identified by id in request header
		HttpSession session = request.getSession(); 
		
		if(request.getParameter("logout")!= null) {
			// user request to logout
			session.invalidate(); // destroying session
			response.sendRedirect("index.jsp"); //sends user to login page
			
		}
		else if (referer.contains("index")) {
			// Request is for login authentication
			LoginBean login = new LoginBean();

			// Reading request parameters
			login.setEmail(request.getParameter("email"));
			login.setPassword(request.getParameter("password"));
			RegisterBean user = service.authenticate(login);
			if (user != null) {
				// Login successful
				session.setAttribute("USER", user); 
				//set user details by getting the authenticated user
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
				// setting the email or remembering the email 
				///so that on change page, we only have to update the password
				session.setAttribute("EMAIL", forget.getEmail());
				
				response.sendRedirect("change.jsp");
			} else
				response.sendRedirect("forget.jsp?invalid=yes");

		}

		else {
			// request to change Password
			LoginBean change = new LoginBean();

			// Reading request parameters
			change.setPassword(request.getParameter("password"));
			
			// remembering the email as set in forget
			change.setEmail((String)session.getAttribute("EMAIL")); 
	
			
			if (service.update(change)) {
			    session.removeAttribute("EMAIL"); 
			    // As its work of changing password is done, we remove it
				response.sendRedirect("index.jsp");
			}else
				response.sendRedirect("change.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
