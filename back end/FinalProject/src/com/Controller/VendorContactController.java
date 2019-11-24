package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.VendorContactDAO;

import com.Model.VendorContactBean;

@RestController
public class VendorContactController {

	@Autowired
	VendorContactDAO dao;

	// view vendor and contact list
	@RequestMapping(value = "/viewlist", headers = "Accept=application/json", method = RequestMethod.GET)
	public List viewVendorContactList(@ModelAttribute("vc") VendorContactBean vc) {
		List viewList = dao.viewVendorContactList();
		return viewList;
	}

	// insert and update details
	@RequestMapping(value = "/insertDetails", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void insertDetails(@RequestBody VendorContactBean vc) {

		if (vc.getVendorId() == 0) {

			System.out.println("vendorId is null");
			dao.insertVendor(vc);

		} else {
			System.out.println("vendorId not null");
			dao.updateVendor(vc);
		}
	}
	

	// find by name or location or service
	@RequestMapping(value = "/find/{searchString}", method = RequestMethod.GET, produces = "application/json")
	public List<VendorContactBean> findDetails(
			@PathVariable("searchString") String searchString) {
		List findList = dao.getBySearch(searchString);
		return findList;
	}

	
	
	//Disable vendor
	@RequestMapping(value = "/disablevendor/{vendorId}", method = RequestMethod.PUT)
	public void staffDisable(@PathVariable("vendorId") int vendorId) {
	dao.disableVendor(vendorId);
	}
	
	
	//Login
	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	public VendorContactBean getRole(@PathVariable("username") String username,@PathVariable("password") String password)
	{
	return  dao.verifyLogin(username, password);

	}
	
	

//get getails by id	
	@RequestMapping(value = "/getById/{vendorId}", method = RequestMethod.GET, produces = "application/json")
	public VendorContactBean getStaff(@ModelAttribute("vc") VendorContactBean vc,@PathVariable("vendorId") int vendorId) {
		List staff=dao.getById(vendorId);
		vc=(VendorContactBean) staff.get(0);
		return  vc;
	}


}
