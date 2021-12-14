package nhom2.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String code;
	private String phone;
	private String address;
	private String password;
	private String city;
	private String district;
	private String ward;
	
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private Bill bill;

	public Customer() {
		super();
		name = "";
		email = "";
		code = "";
		phone = "";
		address = "";
		password="";
	}

	public Customer(String name, String email, String code, String phone, String address,String password,String city,String district,String ward) {
		super();
		this.name = name;
		this.email = email;
		this.code = code;
		this.phone = phone;
		this.address = address;
		this.password= password;
		this.city = city;
		this.district = district;
		this.ward = ward;
	}

	public Customer(int id, String name, String email, String code, String phone, String address,String password,String city,String district,String ward) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.code = code;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.city = city;
		this.district = district;
		this.ward = ward;
	}
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
