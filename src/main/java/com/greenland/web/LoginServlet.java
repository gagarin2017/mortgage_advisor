package com.greenland.web;

import com.greenland.model.Authenticator;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet {

	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException, ServletException {

		final Authenticator auth = new Authenticator();
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		
		final boolean accessGranted = auth.accessGrantedForName(userName, password);

		request.setAttribute("accessGranted",accessGranted);
		final RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);

		// response.setContentType("text/html");
		// final PrintWriter out = response.getWriter();
		// out.println("<h1>Welcome, dear "+userName+"!</h1>");
	}

}