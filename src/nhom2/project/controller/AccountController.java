package nhom2.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import nhom2.project.data.CustomerDAO;
import nhom2.project.model.Customer;

@WebServlet("/account")
public class AccountController extends HttpServlet {
	
	private CustomerDAO customerDAO;
	
	public AccountController(){
		super();
		customerDAO = new CustomerDAO();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("cid"));
		
		
		String name = request.getParameter("fullName");
//		String email = request.getParameter("email");
		String phone = request.getParameter("phoneNumber");
//		String city = request.getParameter("city");
		String requsetdistrict = request.getParameter("district");
		JSONObject jsDistrict = new JSONObject(requsetdistrict);
		Object objDistrict = jsDistrict.get("name");
		String district = (String) objDistrict;
		
		String requestward = request.getParameter("ward");
		JSONObject jsWard = new JSONObject(requestward);
		Object objWard = jsWard.get("name");
		String ward = (String) objWard;
		String add = request.getParameter("address");
		
		

		String address = add + ", " + ward + ", " + district + ", TPHCM";

		Customer customer = customerDAO.getCustomer(id);
		customer.setName(name);
//		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setAddress(add);
		customer.setCity("TPHCM");
		customer.setDistrict(district);
		customer.setWard(ward);
		customerDAO.updateCustomer(customer);
		
		HttpSession ss = request.getSession();
		ss.setAttribute("customer", customer);
		ss.setAttribute("address", address);
		request.setAttribute("customerUpdate", customer);
		getServletContext().getRequestDispatcher("/account.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	

}
