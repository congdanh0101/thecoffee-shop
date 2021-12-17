package nhom2.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.model.Admin;

@WebServlet("/adminlogin")
public class AdminLoginVerify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession ss = req.getSession();
		if (username.equals("admin") && password.equals("admin")) {
			Admin admin  = new Admin(username,password);
			
			ss.setAttribute("admin", admin);
			sc.getRequestDispatcher("/admin.jsp").forward(req, resp);
		} else
			sc.getRequestDispatcher("/admin_login.jsp").forward(req, resp);
	}
}
