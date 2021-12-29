package nhom2.project.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.CustomerDAO;
import nhom2.project.model.Customer;
import nhom2.project.util.EmailUtils;

@WebServlet("/login")
public class Login extends HttpServlet {

	private String host;
	private String port;
	private String username;
	private String pass;
	private CustomerDAO customerDAO;
	private String message = "";
	private String url = "/login.jsp";

	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		username = "thecoffeeshop010101@gmail.com";
		pass = context.getInitParameter("pass");
	}

	public Login() {
		super();
		customerDAO = new CustomerDAO();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		Customer customer = null;

		if (action == null) {
			action = "join";
		}

		if (action.equals("join")) {
			action = "login";
		} else if (action.equals("add")) {
			Add(req, resp);
		} else {
			Signin(req, resp);
		}
		req.getSession().setAttribute("loggedIn", customer);
		req.setAttribute("message", message);
		System.out.println(url);
		System.out.println(action);
		getServletContext().getRequestDispatcher(url).forward(req, resp);

	}

	public void Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = null;
		String code = EmailUtils.getRandom();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirmpassword");
		if (email == null || email.equals("") || password == null || password.equals("")) {
			message = "Xin hãy nhập lại tài khoản và mật khẩu!";

		} else if (!password.equals(confirm)) {
			message = "Mật khẩu xác nhận không trùng khớp. Vui lòng nhập lại!";

		} else {
			if (customerDAO.checkCustomerExist(email)) {
				message = "Tài khoản đã tồn tại! Vui lòng thử một tài khoản khác!";
			}

			else {
				customer = new Customer();
				customer.setEmail(email);
				customer.setPassword(password);
				customer.setCode(code);

				boolean test;
				try {
					test = EmailUtils.sendEmail(host, port, username, pass, email, "Xác minh tài khoản",
							"Đăng ký tài khoản thành công. Vui lòng nhập mã xác thực sau để kích hoạt tài khoản: "
									+ customer.getCode());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					test = false;
				}
				if (test) {
					HttpSession session = request.getSession();
					session.setAttribute("customer", customer);
					getServletContext().getRequestDispatcher("/verify.jsp").forward(request, response);
				}
			}
		}
		request.setAttribute("message", message);
//		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	public void Signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = null;

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email == null || email.equals("") || password == null || password.equals("")) {
			message = "Xin hãy nhập lại tài khoản và mật khẩu!";
			url = "/login.jsp";
		} else if (customerDAO.checkCustomerExist(email)) {
			customer = customerDAO.getCustomerByEmail(email);
			if (password.equals(customer.getPassword())) {
				message = "Đăng nhập thành công!";
				if (customer.getName() != "" && customer.getAddress() != "" && customer.getPhone() != ""
						&& customer.getDistrict() != "" && customer.getWard() != "" && customer.getName() != null
						&& customer.getAddress() != null && customer.getPhone() != null
						&& customer.getDistrict() != null && customer.getWard() != null)
					url = "/home";
				else
					url = "/account.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("loggedIn", customer);
				session.setAttribute("customer", customer);
			} else {
				message = "Sai mật khẩu. Vui lòng nhập lại";
				url = "/login.jsp";
			}
		} else {
			message = "Tài khoản không tồn tại!";
		}
		request.setAttribute("message", message);

	}
}
