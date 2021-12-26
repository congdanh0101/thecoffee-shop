package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.BillDAO;
import nhom2.project.data.StatusDAO;
import nhom2.project.model.Bill;
import nhom2.project.model.Status;

@SuppressWarnings("serial")
@WebServlet({"/changeStatusFilter","/changeStatus"})
public class ChangeBillStatusController extends HttpServlet {
	private BillDAO billDAO;
	private StatusDAO statusDAO;

	public ChangeBillStatusController() {
		super();
		billDAO = new BillDAO();
		statusDAO = new StatusDAO();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri  =req.getRequestURI();
		List<Bill> listBill = new ArrayList<Bill>();
		List<Status> listStatus = new ArrayList<Status>();
		if(uri.contains("Filter")) {
			
			String changeStatus = req.getParameter("changeStatus");
			Status status = new Status();
			if (changeStatus != null && changeStatus != "") {
				
				int sid = Integer.parseInt(changeStatus);
				listBill = billDAO.getAllBillByStatus(sid);
				
				listStatus = statusDAO.getAllStatus();
				status = statusDAO.getStatus(sid);
				
			}else {
				listBill = billDAO.getAllBill();
				listStatus = statusDAO.getAllStatus();
			}
			
			
			req.setAttribute("StatusFilter", status);
			req.setAttribute("listStatus", listStatus);
			req.setAttribute("listBill", listBill);
			
		}else {
			int bid = Integer.parseInt(req.getParameter("bid"));
			int sid = Integer.parseInt(req.getParameter("nextstatus"));
			Bill bill = new Bill();
			bill = billDAO.getBill(bid);
			Status status = new Status();
			status = statusDAO.getStatus(sid);
			bill.setStatus(status);
			billDAO.updateBill(bill);
			
			listBill = billDAO.getAllBill();
			listStatus = statusDAO.getAllStatus();
			req.setAttribute("listStatus", listStatus);
			req.setAttribute("listBill", listBill);
//			req.getRequestDispatcher("/admin?action=bill").forward(req, resp);
		}
		req.getRequestDispatcher("/admin_bill.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
