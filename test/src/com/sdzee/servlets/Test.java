package com.sdzee.servlets;

import com.sdzee.beans.Coyote;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String paramAuteur = request.getParameter("auteur");
		
		String message = "Transmission de variables : OK ! " + paramAuteur;
		
		Coyote premierBean = new Coyote();
		
		premierBean.setNom("Coyote");
		premierBean.setPrenom("Wile E.");
		
		request.setAttribute("test", message);
		request.setAttribute("coyote", premierBean);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}
	
}
