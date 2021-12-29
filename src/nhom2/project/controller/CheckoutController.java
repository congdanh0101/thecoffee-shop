package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.ProductDAO;
import nhom2.project.model.Cart;
import nhom2.project.model.Customer;
import nhom2.project.model.LineItem;
import nhom2.project.model.Product;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
	private ProductDAO productDAO;

	public CheckoutController() {
		super();
		// TODO Auto-generated constructor stub
		productDAO = new ProductDAO();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		System.out.println(customer);
		if (customer != null) {
			if (customer.getName() != "" && customer.getAddress() != "" && customer.getPhone() != ""
					&& customer.getDistrict() != "" && customer.getWard() != "" && customer.getName() != null
					&& customer.getAddress() != null && customer.getPhone() != null && customer.getDistrict() != null
					&& customer.getWard() != null)
				sc.getRequestDispatcher("/checkout.jsp").forward(req, resp);
			else
				sc.getRequestDispatcher("/account.jsp").forward(req, resp);
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}
