package com.ust.dao;

import java.util.List;

import com.ust.model.VendorContactBean;

public interface IVendorContactDao {

	// inserting into vendor Table
	public abstract int insertVendor(VendorContactBean vcBean);

	// inserting into contact table
	public abstract int insertContact(VendorContactBean vcBean);

	// updating vendor Table and contact table
	public abstract int updateVendor(VendorContactBean vcBean);

	// list all the vendors and contacts
	public abstract List<VendorContactBean> getVendorList();

	// select the details of a single vendor and contact using id
	public abstract VendorContactBean getVendorById(int vId);

	// search using vendor name,contact person name, location or service
	public abstract List<VendorContactBean> getVendorSearch(String search);

	// disable a vendor using id
	public abstract int disableVendor(VendorContactBean vcBean);

}