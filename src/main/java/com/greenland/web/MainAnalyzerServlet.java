package com.greenland.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAnalyzerServlet extends HttpServlet {

	private static final long serialVersionUID = 9047908560545129234L;

	public void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, ServletException {
		processTheRequest(request, response);
	}

	public void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, ServletException {
		processTheRequest(request, response);
	}

	public void processTheRequest(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, ServletException {
		
		final HttpSession session = request.getSession();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/analysisResult.jsp");
		dispatcher.forward(request,response);
	}

}