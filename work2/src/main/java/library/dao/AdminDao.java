package library.dao;

import library.po.Admin;

public interface AdminDao {

	public Admin getAdminByNameByPass(String adminName,String password);
}
