package com.zensar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestAction = request.getParameter("requestAction");
		
		if (requestAction.equalsIgnoreCase("Login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			StudentRepository studentRepository = new StudentRepository();
			boolean loginResult = studentRepository.checkLogin(username, password);
			String message = "Invalid Credentials";
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			if(loginResult) {
				rd.forward(request, response);
			} else {
				request.setAttribute("message", message);
				RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
				try {
					rd1.forward(request, response);
				} catch (ServletException e) {
					System.out.println("Exception occurred: " + e);
				} catch (IOException e) {
					System.out.println("Exception occurred: " + e);
				}
			}
			
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
