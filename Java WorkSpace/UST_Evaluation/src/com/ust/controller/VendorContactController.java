package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IVendorContactDao;
import com.ust.model.VendorContactBean;

@RestController
@RequestMapping("/ust")
public class VendorContactController {

	@Autowired
	IVendorContactDao vendorContactDao;

	//Insert or update according to the id 
	@RequestMapping(value = "/insert", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void doctorInsert(@RequestBody VendorContactBean vendorContactBean) {
		if (vendorContactBean.getvId() != 0) {
			vendorContactDao.updateVendor(vendorContactBean);
		} else {
			vendorContactDao.insertVendor(vendorContactBean);

		}
	}

	//select all the vendors and contact details
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public List<VendorContactBean> getAll() {
		List list = vendorContactDao.getVendorList();
		return list;
	}

	// select vendor By vendor Id
	@RequestMapping(value = "/{vId}", method = RequestMethod.GET)
	public VendorContactBean getMById(@PathVariable("vId") int vId) {

		return vendorContactDao.getVendorById(vId);
	}

	// search using location,name
	@RequestMapping(value = "/search/{searchString}", method = RequestMethod.GET)
	public List<VendorContactBean> getSearch(
			@PathVariable("searchString") String searchString) {
		List list = vendorContactDao.getVendorSearch(searchString);
		return list;
	}

	// Disabling a vendor
	@RequestMapping(value = "/disable", method = RequestMethod.PUT)
	public void disable(@RequestBody VendorContactBean vcBean) {
		vendorContactDao.disableVendor(vcBean);
	}

}
