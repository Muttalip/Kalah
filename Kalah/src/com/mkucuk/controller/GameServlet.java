package com.mkucuk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mkucuk.model.Game;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GameServlet.processRequest");
		String pitRaw = request.getParameter("pit");
		int pit = -1;
		if (pitRaw != null) {
			pit = Integer.parseInt(pitRaw); // 0-11
		}

		HttpSession session = request.getSession();
		Game game = (Game) session.getAttribute("game");

		if (pit != -1) {
			game = game.playMove(pit);
		}

		session.setAttribute("game", game);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GameServlet.doGet");

		String nextJSP = "/WEB-INF/game.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GameServlet.doPost");

		processRequest(request, response);
		
		String nextJSP = "/WEB-INF/game.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		

	}

}