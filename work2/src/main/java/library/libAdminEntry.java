package library;

import java.util.Scanner;

import library.po.Admin;
import library.view.AdminView;
import library.view.BorrowerView;
import library.view.impl.AdminViewImpl;
import library.view.impl.BorrowerViewImpl;

public class libAdminEntry {

	public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t 图书馆后台管理系统  \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		AdminView adminView = new AdminViewImpl();
		BorrowerView borrowerView = new BorrowerViewImpl();
		Admin admin = adminView.login();
		
		//登录
		if(admin!=null) {
			int menu = 0;
			while(menu!=5) {
				//输出主菜单
				System.out.println("\n========= 1.所有借阅者列表=2.搜索借阅者=3.新建借阅者=4.删除借阅者=5.退出系统 =========");
				System.out.println("请输入你的选择：");
				menu = input.nextInt();
				switch(menu) {
					case 1:
						borrowerView.listBorrowerAll();
						break;
					case 2:
						borrowerView.listBorrower();
						break;
					case 3:
						borrowerView.saveBorrower();
						break;
					case 4:
						borrowerView.removeBorrower();
						break;
					case 6:
						System.out.println("------------------------欢迎下次光临图书馆后台管理系统-----------------------");
						break;
					default:
						System.out.println("没有这个选项！\n");
						break;
				}
			}
			
		}else {
			System.out.println("\n管理员名称或密码输入错误!\n");
		}
	}
	
	public static void main(String[] args) {
		new libAdminEntry().work();
	}

}
