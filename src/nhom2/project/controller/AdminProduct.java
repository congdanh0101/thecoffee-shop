package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom2.project.data.CategoryDAO;
import nhom2.project.data.ProductDAO;
import nhom2.project.model.Category;
import nhom2.project.model.Product;

/**
 * Servlet implementation class AdminProduct
 */
@WebServlet({ "/AdminProduct", "/admin_productdetail", "/UpdateProduct" })
public class AdminProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;

	public AdminProduct() {
		super();
		productDAO = new ProductDAO();
		categoryDAO = new CategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doPost(request, response);
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String strID = request.getParameter("pid");
		int pid = Integer.parseInt(strID);
		String uri = request.getRequestURI();
		if (uri.contains("detail")) {
//			String haha = "editName" + strID;
//			System.out.println(haha);
//			String name = request.getParameter("editName" + strID);
//			String price = request.getParameter("editPrice" + strID);
//			String description = request.getParameter("editDescription" + strID);
//			String category = request.getParameter("editCategory" + strID);
//			System.out.println(name);
//			System.out.println(price);
//			System.out.println(description);
//			System.out.println(category);
//			System.out.println(pid);

			Product product = new Product();
			product = productDAO.getProduct(pid);
			request.setAttribute("product", product);
			request.getRequestDispatcher("admin_productdetail.jsp").forward(request, response);

		} else {
			productDAO.deleteProduct(pid);
		}
		request.getRequestDispatcher("/admin?action=product").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if(uri.contains("Update")) {
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String description = request.getParameter("description");
			int cid = Integer.parseInt(request.getParameter("category"));
			int pid = Integer.parseInt(request.getParameter("productId"));
			String strPrice = "";
			Product product = productDAO.getProduct(pid);
			
			for(int i = 0 ;i<price.length();i++) {
				if(price.charAt(i) >=48 && price.charAt(i) <=57 )
					strPrice+=price.charAt(i);
			}
			
			product.setPrice(Integer.parseInt(strPrice));
			product.setDescription(description);
			product.setName(name);
			product.setCategory(categoryDAO.getCategory(cid));
			productDAO.updateProduct(product);
		}
		else {
			String code = null;
			String name = request.getParameter("name");
			String image = request.getParameter("img");
			String description = request.getParameter("description");
			int price = Integer.parseInt(request.getParameter("price"));
			int cid = Integer.parseInt(request.getParameter("category"));

			if (name != null && name != "" && image != null && image != "") {
				if (description == null)
					description = "";
				if (code == null)
					code = "";
				Product product = new Product(name, price, new CategoryDAO().getCategory(cid), image, description, code);
				productDAO.saveProduct(product);
			}
		}
		

//		List<Product> listProduct = new ArrayList<Product>();
//		listProduct = productDAO.getAllProduct();
//
//		request.setAttribute("listProduct", listProduct);
		request.getRequestDispatcher("/admin?action=product").forward(request, response);

	}
}
