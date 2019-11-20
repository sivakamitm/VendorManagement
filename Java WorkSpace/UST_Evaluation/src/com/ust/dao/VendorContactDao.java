package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.VendorContactBean;

public class VendorContactDao implements IVendorContactDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// inserting into vendor Table
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#insertVendor(com.ust.model.VendorContactBean)
	 */
	@Override
	public int insertVendor(VendorContactBean vcBean) {
		String sql = "insert into vendor(vendorName,address,location,service,pincode,isActive) values('"
				+ vcBean.getVendorName()
				+ "','"
				+ vcBean.getAddress()
				+ "','"
				+ vcBean.getLocation()
				+ "','"
				+ vcBean.getService()
				+ "','"
				+ vcBean.getPincode() + "',1)";
		if (template.update(sql) != 0) {

			return insertContact(vcBean);

		} else {
			return 0;
		}

	}

	// inserting into contact table
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#insertContact(com.ust.model.VendorContactBean)
	 */
	@Override
	public int insertContact(VendorContactBean vcBean) {
		String sql = "select max(vId) from vendor";
		int vId = template.queryForObject(sql, Integer.class);

		System.out.println("vId:" + vId);

		String sql1 = "insert into contact(vId,cName,department,email,phone) values(?,?,?,?,?)";
		return template.update(sql1, new Object[] { vId, vcBean.getcName(),
				vcBean.getDepartment(), vcBean.getEmail(), vcBean.getPhone() });
	}

	// updating vendor Table and contact table
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#updateVendor(com.ust.model.VendorContactBean)
	 */
	@Override
	public int updateVendor(VendorContactBean vcBean) {

		// update query for vendor table
		String sql = "update vendor set vendorName='" + vcBean.getVendorName()
				+ "',address='" + vcBean.getAddress() + "',location='"
				+ vcBean.getLocation() + "',service='" + vcBean.getService()
				+ "',pincode='" + vcBean.getPincode() + "' where vId=?";

		template.update(sql, new Object[] { vcBean.getvId() });

		// update query for contact table
		String sql1 = "update contact set cName='" + vcBean.getcName()
				+ "',department='" + vcBean.getDepartment() + "',email='"
				+ vcBean.getEmail() + "',phone='" + vcBean.getPhone()
				+ "' where cId=?";
		return template.update(sql1, new Object[] { vcBean.getcId() });

	}

	// list all the vendors and contacts
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#getVendorList()
	 */
	@Override
	public List<VendorContactBean> getVendorList() {
		return template
				.query("select vendor.vId,vendorName,address,location,service,pincode,cName,department,email,phone from vendor join contact on vendor.vId=contact.vId where isActive=1 order by vendorName",
						new RowMapper<VendorContactBean>() {
							public VendorContactBean mapRow(ResultSet rs,
									int row) throws SQLException {
								VendorContactBean vc = new VendorContactBean();
								vc.setvId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setAddress(rs.getString(3));
								vc.setLocation(rs.getString(4));
								vc.setService(rs.getString(5));
								vc.setPincode(rs.getString(6));
								vc.setcName(rs.getString(7));
								vc.setDepartment(rs.getString(8));
								vc.setEmail(rs.getString(9));
								vc.setPhone(rs.getString(10));
								return vc;

							}

						});
	}

	// select the details of a single vendor and contact using id
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#getVendorById(int)
	 */
	@Override
	public VendorContactBean getVendorById(int vId) {

		String sql = "select vendor.vId,vendorName,address,location,service,pincode,cName,department,email,phone from vendor join contact on vendor.vid=contact.vid where vendor.vId ="
				+ vId + "";
		return (VendorContactBean) template.queryForObject(sql,
				new Object[] {}, new BeanPropertyRowMapper<VendorContactBean>(
						VendorContactBean.class));
	}

	// search using vendor name,contact person name, location or service
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#getVendorSearch(java.lang.String)
	 */
	@Override
	public List<VendorContactBean> getVendorSearch(String search) {
		return template
				.query("select vendor.vId,vendorName,address,location,service,pincode,cName,department,email,phone,isActive from vendor join contact on vendor.vid=contact.vid where (isActive=1) and (location like '"
						+ search
						+ "%' or service like '"
						+ search
						+ "%' or vendorName like '"
						+ search
						+ "%' or cName like '" + search + "%')",
						new RowMapper<VendorContactBean>() {
							public VendorContactBean mapRow(ResultSet rs,
									int row) throws SQLException {
								VendorContactBean vc = new VendorContactBean();
								
								vc.setvId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setAddress(rs.getString(3));
								vc.setLocation(rs.getString(4));
								vc.setService(rs.getString(5));
								vc.setPincode(rs.getString(6));
								vc.setcName(rs.getString(7));
								vc.setDepartment(rs.getString(8));
								vc.setEmail(rs.getString(9));
								vc.setPhone(rs.getString(10));
								vc.setIsActive(rs.getInt(11));
								return vc;

							}

						});
	}

	// disable a vendor using id
	/* (non-Javadoc)
	 * @see com.ust.dao.IVendorContactDao#disableVendor(com.ust.model.VendorContactBean)
	 */
	@Override
	public int disableVendor(VendorContactBean vcBean) {
		String sql = "update vendor set isActive=0 where vId=?";
		return template.update(sql, new Object[] { vcBean.getvId() });

	}

}
