package nhom2.project.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.BillDAO;
import nhom2.project.data.BillDetailDAO;
import nhom2.project.data.CustomerDAO;
import nhom2.project.data.StatusDAO;
import nhom2.project.model.Bill;
import nhom2.project.model.Cart;
import nhom2.project.model.Customer;
import nhom2.project.model.Status;

@WebServlet("/pay")
public class PayController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillDAO billDAO;
	private StatusDAO statusDAO;

	public PayController() {
		super();
		billDAO = new BillDAO();
		statusDAO = new StatusDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession ss = request.getSession();
		Customer customer = (Customer) ss.getAttribute("customer");
		Cart cart = (Cart) ss.getAttribute("cart");
		if (customer != null && cart != null) {
			Date dt = new Date();
			java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
			java.sql.Timestamp sqlTimeStamp = new Timestamp(dt.getTime());
			Bill bill = new Bill();
			bill.setCustomer(customer);
			bill.setDate(sqlDate);
			bill.setTime(sqlTimeStamp);
			int sid = 1;
			Status status = statusDAO.getStatus(sid);
			System.out.println(status);
			if (status != null)
				bill.setStatus(status);
			billDAO.saveBill(bill);
			cart.insertBillDetail(bill);
			ss.removeAttribute("cart");
			ss.removeAttribute("size");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
