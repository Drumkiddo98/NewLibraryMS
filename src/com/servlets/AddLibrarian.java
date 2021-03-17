package com.servlets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DB;
import com.library.Librarian;

@WebServlet("/addlibrarian")
public class AddLibrarian extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		String libName= req.getParameter("libname");
		String libMail= req.getParameter("libmail");
		String libPass= req.getParameter("libpass");
		String libSecretCode= req.getParameter("secretcode");
		int a=1;
		DB db = new DB();
 		if(libSecretCode.equals("11")) {
		Librarian lb = new Librarian(libName, libMail, libPass);
		db.addLibrarian(lb);
		req.getRequestDispatcher("index.html").forward(req, res);
	}
 		else {
 			req.getRequestDispatcher("index.html").forward(req, res); 			
}
	}
}
