package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Model.VendorContactBean;

public class VendorContactDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// view vendor and contact details
	public List<VendorContactBean> viewVendorContactList() {
		return template
				.query("select vendorId,vendorName,address,location,service,pinCode,vendorStatus,contactId,contactName,department,email,phone from tb_vendor join tb_contact using (vendorId) where vendorStatus='yes'",
						new RowMapper<VendorContactBean>() {

							@Override
							public VendorContactBean mapRow(ResultSet rs,
									int row) throws SQLException {
								// TODO Auto-generated method stub

								// creating object
								VendorContactBean vc = new VendorContactBean();

								vc.setVendorId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setAddress(rs.getString(3));
								vc.setLocation(rs.getString(4));
								vc.setService(rs.getString(5));
								vc.setPinCode(rs.getString(6));
								vc.setVendorStatus(rs.getString(7));
								vc.setContactId(rs.getInt(8));
								vc.setContactName(rs.getString(9));
								vc.setDepartment(rs.getString(10));
								vc.setEmail(rs.getString(11));
								vc.setPhone(rs.getString(12));

								return vc;
							}
						});

	}

	// insert vendor and contact details

	public int insertVendor(VendorContactBean vc) {

		
		String sql = "insert into tb_vendor(vendorName,address,location,service,pinCode,vendorStatus) values(?,?,?,?,?,'yes')";

		template.update(sql, new Object[] { vc.getVendorName(),vc.getAddress(),vc.getLocation(),vc.getService(),vc.getPinCode()});
		
		// get maximum vendorId
					String sq2 = "select max(vendorId) from tb_vendor";
					int vendorId = template.queryForObject(sq2, Integer.class);

					// insert contact details
					String sql3 = "insert into tb_contact(contactName,vendorId,department,email,phone) values(?,?,?,?,?)";

					return template.update(sql3, new Object[] { vc.getContactName(),
							vendorId, vc.getDepartment(), vc.getEmail(), vc.getPhone() });
		
		
	}
	
	

	// update vendor and contact details

	public int updateVendor(VendorContactBean vc) {

		// update vendor
		String sql = "update tb_vendor set vendorName='" + vc.getVendorName()
				+ "',address='" + vc.getAddress() + "',location='"
				+ vc.getLocation() + "',service='" + vc.getService()
				+ "',pinCode='" + vc.getPinCode() + "' where vendorId= "
				+ vc.getVendorId() + "";
		template.update(sql, new Object[] {});

		// update contact
		String sql1 = "update tb_contact set contactName='"
				+ vc.getContactName() + "',department='" + vc.getDepartment()
				+ "',email='" + vc.getEmail() + "',phone='" + vc.getPhone()
				+ "' where vendorId=" + vc.getVendorId() + "";
		return template.update(sql1, new Object[] {});

	}
	
	
	
	
	
	//search
	public List<VendorContactBean> getBySearch(String searchString) {

		return template.query("select vendorId,vendorName,address,location,service,pinCode,vendorStatus,contactId,contactName,department,email,phone from tb_vendor join tb_contact using (vendorId) where vendorStatus='yes' and vendorName like '"+ searchString+ "%' or location like '"+ searchString+ "%' or service like '"+searchString+"%'", new RowMapper<VendorContactBean>() {
					public VendorContactBean mapRow(ResultSet rs, int row)
							throws SQLException {
						VendorContactBean vc = new VendorContactBean();
						
						vc.setVendorId(rs.getInt(1));
						vc.setVendorName(rs.getString(2));
						vc.setAddress(rs.getString(3));
						vc.setLocation(rs.getString(4));
						vc.setService(rs.getString(5));
						vc.setPinCode(rs.getString(6));
						vc.setVendorStatus(rs.getString(7));
						vc.setContactId(rs.getInt(8));
						vc.setContactName(rs.getString(9));
						vc.setDepartment(rs.getString(10));
						vc.setEmail(rs.getString(11));
						vc.setPhone(rs.getString(12));

						return vc;
					}
				});

	}
	
	

	
	
	//Disable vendor
	public int disableVendor(int vendorId) {
	   String sql = "update tb_vendor set vendorStatus = 'no'  where vendorId = ?";
	   return template.update(sql,new Object[]{vendorId});
	   }
	
	
	
	

	// Login
	public VendorContactBean verifyLogin(String username, String password) {

	String sql = "select userId from tb_login where username = ? and password = ?";
	VendorContactBean mod= template.queryForObject(sql,
	new Object[] { username, password },
	new BeanPropertyRowMapper<VendorContactBean>(VendorContactBean.class));
	int userId=mod.getUserId();
	return mod;
	}
	
	
	// view vendor and contact details by id
		public List<VendorContactBean> getById(int vendorId) {
			return template
					.query("select vendorId,vendorName,address,location,service,pinCode,vendorStatus,contactId,contactName,department,email,phone from tb_vendor join tb_contact using (vendorId) where vendorStatus='yes' and vendorId="+vendorId+"",
							new RowMapper<VendorContactBean>() {

								@Override
								public VendorContactBean mapRow(ResultSet rs,
										int row) throws SQLException {
									// TODO Auto-generated method stub

									// creating object
									VendorContactBean vc = new VendorContactBean();

									vc.setVendorId(rs.getInt(1));
									vc.setVendorName(rs.getString(2));
									vc.setAddress(rs.getString(3));
									vc.setLocation(rs.getString(4));
									vc.setService(rs.getString(5));
									vc.setPinCode(rs.getString(6));
									vc.setVendorStatus(rs.getString(7));
									vc.setContactId(rs.getInt(8));
									vc.setContactName(rs.getString(9));
									vc.setDepartment(rs.getString(10));
									vc.setEmail(rs.getString(11));
									vc.setPhone(rs.getString(12));

									return vc;
								}
							});

		}
	
	
}
