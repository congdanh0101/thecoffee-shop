package nhom2.project.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import nhom2.project.data.BillDetailDAO;

public class Cart implements Serializable {
	private ArrayList<LineItem> items;

	public Cart() {
		items = new ArrayList<LineItem>();
	}

	public ArrayList<LineItem> getItems() {
		return items;
	}

	
	public int getCount() {
		return items.size();
	}

	public void addItem(LineItem item) {
		String codeProduct = item.getProduct().getCode();
		String codeSize = item.getSize().getCode();
		String codeTopping = item.getTopping().getCode();
		int quantity = item.getQuantity();
		for (int i = 0; i < items.size(); i++) {
			LineItem lineItem = items.get(i);
			if (lineItem.getProduct().getCode().equals(codeProduct) && lineItem.getSize().getCode().equals(codeSize)
					&& lineItem.getTopping().getCode().equals(codeTopping)) {
				lineItem.setQuantity(quantity);
				return;
			}
		}
		items.add(item);
	}

	public void removeItem(LineItem item) {
		String codeProduct = item.getProduct().getCode();
		String codeSize = item.getSize().getCode();
		String codeTopping = item.getTopping().getCode();
		for (int i = 0; i < items.size(); i++) {
			LineItem lineItem = items.get(i);
			if (lineItem.getProduct().getCode().equals(codeProduct) && lineItem.getSize().getCode().equals(codeSize)
					&& lineItem.getTopping().getCode().equals(codeTopping)) {
				items.remove(i);
				return;
			}
		}
	}

	public int getSubTotal() {
		int total = 0;
		for (int i = 0; i < items.size(); i++) {
			LineItem item = items.get(i);
			total = total + item.getTotal();
		}
		return total;
	}

	public String getSubTotalCurrencyFormat() {
//    	Locale lc = new Locale("nv", "VN");
//		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		DecimalFormat currency = new DecimalFormat("###,###,###");
		return currency.format(this.getSubTotal()) + " VNĐ";
	}

	public void insertBillDetail(Bill bill) {
		for (int i = 0; i < items.size(); i++) {
			LineItem item = items.get(i);
			BillDetail billdetail = new BillDetail();
			billdetail.setProduct(item.getProduct());
			billdetail.setQuantity(item.getQuantity());
			billdetail.setSize(item.getSize());
			billdetail.setTopping(item.getTopping());
			billdetail.setBill(bill);
			billdetail.setPrice(item.getPrice());
			billdetail.setTotal(item.getTotal());
			BillDetailDAO billdetailDAO = new BillDetailDAO();
			billdetailDAO.saveBillDetail(billdetail);
		}
	}
	
	public String EmailBill(Bill bill) {
		String html = "<table style =\"width:100%;\"><thead><td><h2>Sản phẩm</h2></td><td><h2>Size</h2></td><td><h2>Topping</h2></td><td><h2>Đơn giá</h2></td><td><h2>Số lượng</h2></td><td><h2>Thành tiền</h2></td></thead><tbody>";
		String str="Sản phẩm\t\t\tSize\t\t\tTopping\t\t\tĐơn giá\n";
		
		for(int i = 0;i<items.size();i++) {
			LineItem item = items.get(i);
			String a ="";
			if(item.getTopping().getName()==null || item.getTopping().getName()=="") {
				a="";
			}
			else a = item.getTopping().getName();
			html += "<tr><td><h3>"+item.getProduct().getName()+"</h3></td><td><h3>"+item.getSize().getName()+"</h3></td><td><h3>"+a+"</h3></td><td><h3>"+item.getPriceCurrencyFormat()+"</h3></td><td><h3>"+item.getQuantity()+"</h3></td><td><h3>"+item.getTotalCurrencyFormat()+"</h3></td></tr>";
//			str+= item.getProduct().getName() + "\t\t\t";
//			str+= item.getSize().getName() + "\t\t\t";
//			str+= a +"\t\t\t";
//			str+= item.getTotalCurrencyFormat();
//			str+="\n";
		}
		html+="<td><h3>Phí vận chuyển</h3></td><td></td><td></td><td></td><td></td><td><h3>25,000 VNĐ</h3></td>";
		html+="</tbody></table><br><br><hr>";
		html+= "<h2 style=\"color: red;\">Tổng cộng: "+getSubTotalCurrencyFormatIncludeShip() +"</h2>";
		return html;
	}
	
	public String getFeeShipCurrencyFormat() {
		DecimalFormat currency = new DecimalFormat("###,###,###");
		return currency.format(25000) + " VNĐ";
	}
	
	public String getSubTotalCurrencyFormatIncludeShip() {
//    	Locale lc = new Locale("nv", "VN");
//		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		DecimalFormat currency = new DecimalFormat("###,###,###");
		return currency.format(this.getSubTotal()+25000) + " VNĐ";
	}
}
