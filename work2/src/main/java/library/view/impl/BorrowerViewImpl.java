package library.view.impl;

import java.util.List;
import java.util.Scanner;

import library.dao.BookDao;
import library.dao.BorrowerDao;
import library.dao.impl.BookDaoImpl;
import library.dao.impl.BorrowerDaoImpl;
import library.po.Book;
import library.po.Borrower;
import library.view.BorrowerView;

public class BorrowerViewImpl implements BorrowerView{
	
	private Scanner input = new Scanner(System.in);

	@Override
	public void listBorrowerAll() {
		BorrowerDao dao = new BorrowerDaoImpl();
		List<Borrower> list = dao.listBorrower(null,null);
		System.out.println("借阅者学号\t借阅者姓名\t借阅者学院");
		for(Borrower b : list) {
			System.out.println(b.getBorrowerId()+"\t"+b.getBorrowerName()+"\t"+b.getBorrowerXY());
		}
	}
	
	@Override
	public void listBorrower() {
		String borrowerName = "";
		String borrowerXY = "";
		
		String inputStr = "";
		System.out.println("是否需要输入借阅者名称关键词(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入借阅者名称关键词：");
			borrowerName = input.next();
		}
		
		System.out.println("是否需要输入借阅者学院关键词(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入借阅者学院关键词：");
			borrowerXY = input.next();
		}
		
		BorrowerDao dao = new BorrowerDaoImpl();
		List<Borrower> list = dao.listBorrower(borrowerName, borrowerXY);
		System.out.println("借阅者学号\t借阅者姓名\t借阅者学院");
		for(Borrower b : list) {
			System.out.println(b.getBorrowerId()+"\t"+b.getBorrowerName()+"\t"+b.getBorrowerXY());
		}
	}
	
	@Override
	public void saveBorrower() {
		System.out.println("请输入借阅者名称：");
		String borrowerName = input.next();
		System.out.println("请输入借阅者学号：");
		Integer borrowerId = input.nextInt();
		BorrowerDao dao = new BorrowerDaoImpl();
		int BorrowerId = dao.saveBorrower(borrowerId,borrowerName);
		if(BorrowerId>0) {
			System.out.println("新建借阅者成功！");
		}else {
			System.out.println("新建借阅者失败！");
		}
	}
	
	@Override
	public void removeBorrower() {
		System.out.println("请输入借阅者学号：");
		int BorrowerId = input.nextInt();

		BorrowerDao dao = new BorrowerDaoImpl();
		System.out.println("确认要删除吗(y/n)：");
		if(input.next().equals("y")) {
			int result = dao.removeBorrower(BorrowerId);
			if(result==1) {
				System.out.println("删除借阅者成功！");
			}else {
				System.out.println("删除借阅者失败！");
			}
		}
	}
	
	@Override
	public Borrower login() {
		System.out.println("请输入借阅者学号：");
		int borrowerId = input.nextInt();
		System.out.println("请输入密码：");
		String password = input.next();

		BorrowerDao dao = new BorrowerDaoImpl();
		return dao.getBorrowerByIdByPass(borrowerId, password);
	}
	
	@Override
	public void showBorrower(Integer BorrowerId) {
		BorrowerDao dao = new BorrowerDaoImpl();
		Borrower borrower = dao.getBorrowerById(BorrowerId);
		System.out.println(borrower);
	}
	
	@Override
	public void editBorrower(Integer BorrowerId) {
		//先将商家信息查询出来显示，然后用户才能更新
		BorrowerDao dao = new BorrowerDaoImpl();
		Borrower borrower = dao.getBorrowerById(BorrowerId);
		System.out.println(borrower);
		
		String inputStr = "";
		System.out.println("是否修改借阅者名称(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的借阅者名称：");
			borrower.setBorrowerName(input.next());
		}
		
		System.out.println("是否修改借阅者学院(y/n)：");
		inputStr = input.next();
		if(inputStr.equals("y")) {
			System.out.println("请输入新的借阅者学院：");
			borrower.setBorrowerXY(input.next());
		}

		int result = dao.updateBorrower(borrower);
		if(result>0) {
			System.out.println("\n修改借阅者信息成功！\n");
		}else {
			System.out.println("\n修改借阅者信息失败！\n");
		}
	}
	
	@Override
	public void updateBorrowerByPassword(Integer BorrowerId) {
		BorrowerDao dao = new BorrowerDaoImpl();
		Borrower borrower = dao.getBorrowerById(BorrowerId);
		
		System.out.println("\n请输入旧密码：");
		String oldPass = input.next();
		System.out.println("\n请输入新密码：");
		String password = input.next();
		System.out.println("\n请再次输入新密码：");
		String beginPassword = input.next();
		
		if(!borrower.getPassword().equals(oldPass)) {
			System.out.println("\n旧密码输入错误！");
		}else if(!password.equals(beginPassword)) {
			System.out.println("\n两次输入密码不一致！");
		}else {
			int result = dao.updateBorrowerByPassword(BorrowerId, password);
			if(result>0) {
				System.out.println("\n修改密码成功！");
			}else {
				System.out.println("\n修改密码失败！");
			}
		}
	}
	@Override
	public void updateBook(){
		BookDao dao = new BookDaoImpl();
		List<Book>list = dao.listBook();
		System.out.println("请输入已归还书目名称：");
		String bookname=input.next();
		for(Book book:list){
//			System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t"+book.getBookExplain()+"\t"+book.getbooklenddate());-
			if(book.getBookName().equals(bookname)){
				book.setBorrowerId(0);
				System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t"+book.getBookExplain());
			}

		}
	}
}
