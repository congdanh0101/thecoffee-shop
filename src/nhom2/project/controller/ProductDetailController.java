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
import nhom2.project.data.SizeDAO;
import nhom2.project.data.ToppingDAO;
import nhom2.project.model.Category;
import nhom2.project.model.Product;
import nhom2.project.model.Size;
import nhom2.project.model.Topping;

@WebServlet({ "/product_detail", "/admin_detail" })

public class ProductDetailController extends HttpServlet {

	private ProductDAO productDAO;
	private SizeDAO sizeDAO;
	private ToppingDAO toppingDAO;
	private CategoryDAO categoryDAO;

	public ProductDetailController() {
		sizeDAO = new SizeDAO();
		toppingDAO = new ToppingDAO();
		productDAO = new ProductDAO();
		categoryDAO= new CategoryDAO();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("pid"));
		String uri = req.getRequestURI();
		Product product = new Product();
		product = productDAO.getProduct(id);

		List<Size> listSize = new ArrayList<Size>();
		listSize = sizeDAO.getAllSize();

		List<Topping> listTopping = new ArrayList<Topping>();
		listTopping = toppingDAO.gettAllTopping();
		
		List<Category> listCategory = new ArrayList<Category>();
		listCategory = categoryDAO.getAllCategory();

		req.setAttribute("listSize", listSize);
		req.setAttribute("listTopping", listTopping);
		req.setAttribute("product", product);
		req.setAttribute("listCategory", listCategory);
		if (uri.contains("admin"))
			req.getRequestDispatcher("admin_productdetail.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("product_detail.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
