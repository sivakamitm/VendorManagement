package com.ust.model;

public class VendorContactBean {
	
	//Vendor table fields
	private int vId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private String pincode ;
	private int isActive;
	
	//contact table fields
	private int cId;
	private String cName;
	private String department;
	private String email;
	private String phone;
	
	//default constructor of the model/bean class
	public VendorContactBean() {
		super();
	}

	//parameterized constructor of the bean/model class
	public VendorContactBean(int vId, String vendorName, String address,
			String location, String service, String pincode, int isActive,
			int cId, String cName, String department, String email, String phone) {
		super();
		this.vId = vId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
		this.cId = cId;
		this.cName = cName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	//getters and setters 
	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
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

	//overrided toString method 
	@Override
	public String toString() {
		return "VendorContactBean [vId=" + vId + ", vendorName=" + vendorName
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pincode=" + pincode
				+ ", isActive=" + isActive + ", cId=" + cId + ", cName="
				+ cName + ", department=" + department + ", email=" + email
				+ ", phone=" + phone + "]";
	}

}
