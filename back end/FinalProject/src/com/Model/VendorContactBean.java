package com.Model;

public class VendorContactBean {

	//instance variable declaration
	//vendor table
	private String username;
	private String password;
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private String pinCode;
	private String vendorStatus;
	//contact table
	private int contactId;
	private String contactName;
	private String department;
	private String email;
	private String phone;
	
	//default contructor
	public VendorContactBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "VendorContactBean [username=" + username + ", password="
				+ password + ", vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", address=" + address + ", location="
				+ location + ", service=" + service + ", pinCode=" + pinCode
				+ ", vendorStatus=" + vendorStatus + ", contactId=" + contactId
				+ ", contactName=" + contactName + ", department=" + department
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public VendorContactBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
