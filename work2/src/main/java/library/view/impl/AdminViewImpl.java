package library.view.impl;

import java.util.Scanner;

import library.dao.AdminDao;
import library.dao.impl.AdminDaoImpl;
import library.po.Admin;
import library.view.AdminView;

public class AdminViewImpl implements AdminView{
	
	private Scanner input = new Scanner(System.in);

	@Override
	public Admin login() {
		System.out.println("请输入管理员名称：");
		String adminName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		
		AdminDao dao = new AdminDaoImpl();
		return dao.getAdminByNameByPass(adminName, password);
	}
}
