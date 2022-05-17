package library;

import java.util.Scanner;

import library.po.Borrower;
import library.view.BorrowerView;
import library.view.BookView;
import library.view.impl.BorrowerViewImpl;
import library.view.impl.BookViewImpl;

public class libBorrowerEntry {

	public void work() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t 图书馆后台管理系统  \t\t\t|");
		System.out.println("---------------------------------------------------------");
		
		BorrowerView borrowerView = new BorrowerViewImpl();
		
		//商家登录
		Borrower borrower = borrowerView.login();
		
		if(borrower!=null) {
			int menu = 0;
			while(menu!=5) {
				//输出一级菜单
				System.out.println("\n======= 一级菜单（借阅者管理）1.查看借阅者信息=2.修改借阅者信息=3.更新密码=4.借阅图书管理=5.退出系统=======");
				System.out.println("请输入你的选择：");
				menu = input.nextInt();
				
				switch(menu) {
					case 1:
						borrowerView.showBorrower(borrower.getBorrowerId());
						break;
					case 2:
						borrowerView.editBorrower(borrower.getBorrowerId());
						break;
					case 3:
						borrowerView.updateBorrowerByPassword(borrower.getBorrowerId());
						break;
					case 4:
						bookManager(borrower.getBorrowerId());
						break;
					case 5:
						System.out.println("------------------------欢迎下次光临图书馆后台管理系统-----------------------");
						break;	
					default:
						System.out.println("没有这个选项！\n");
						break;
				}
			}
		}else {
			System.out.println("借阅者编号或密码输入错误！");
		}
		
	}
	
	private void bookManager(int borrowerId) {
		Scanner input = new Scanner(System.in);
		
		BookView bookView = new BookViewImpl();
		
		int menu = 0;
		while(menu!=5) {
			//输出二级菜单
			System.out.println("\n======= 二级菜单（借阅图书管理）1.查看借阅图书列表=2.新增借阅图书=3.归还删除借阅名录=4.查询借阅人名单书=6.返回一级菜单 =======");
			System.out.println("请输入你的选择：");
			menu = input.nextInt();
			
			switch(menu) {
				case 1:
					bookView.showBookList(borrowerId);
					break;
				case 2:
					bookView.saveBook(borrowerId);
					break;
				case 3:
					bookView.removeBook(borrowerId);
					break;
				case 4:
					bookView.showBookborrower(borrowerId);//该地方为BookId
					break;
				default:
					System.out.println("没有这个选项！\n");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		new libBorrowerEntry().work();
	}
}
