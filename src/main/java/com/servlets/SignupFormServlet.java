package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class SignupFormServlet
 */
@WebServlet("/SignupFormServlet")
public class SignupFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("SignupForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		String un = request.getParameter("username");
		String psw = request.getParameter("password");
		
		// send data in database
		
		User u = new User();
		u.setFname(fn);
		u.setLname(ln);
		u.setUsername(un);
		u.setPassword(psw);
		
		UserService us = new UserServiceImpl();
		us.signup(u);
		
		
		
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		
	
	}

}
