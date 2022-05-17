package library.view.impl;

import java.util.List;
import java.util.Scanner;

import library.dao.BookDao;
import library.po.Book;
import library.view.BookView;
import library.dao.impl.BookDaoImpl;

public class BookViewImpl implements BookView{
	
	private Scanner input = new Scanner(System.in);

	@Override
	public List<Book> showBookList(Integer borrowerId) {
		BookDao dao = new BookDaoImpl();
		List<Book> list = dao.listBookByBorrowerId(borrowerId);
		System.out.println("图书编号\t图书名称\t图书介绍\t图书借出时间");
		for(Book book : list) {
			System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t"+book.getBookExplain()+"\t"+book.getBooklenddate());
		}
		return list;
	}
	
	@Override
	public void saveBook(Integer borrowerId) {
		Book book = new Book();
		System.out.println("请输入书目名称：");
		book.setBookName(input.next());
		System.out.println("请输入书目介绍：");
		book.setBookExplain(input.next());
		System.out.println("请输入书目借阅日期：");
		book.setBooklenddate(input.next());
		book.setBorrowerId(borrowerId);
		
		BookDao dao = new BookDaoImpl();
		int result = dao.saveBook(book);
		if(result>0) {
			System.out.println("\n新增借阅书目成功！\n");
		}else {
			System.out.println("\n新增借阅书目失败！\n");
		}
	}
	

	@Override
	public void removeBook(Integer borrowerId) {
		BookDao dao = new BookDaoImpl();
		List<Book> list = showBookList(borrowerId);
		
		if(list.size()==0) {
			System.out.println("没有任何借阅书目！");
		}else {
			System.out.println("请选择归还的借阅书目编号");
			int bookId = input.nextInt();
			
			System.out.println("确认已经归还吗(y/n)：");
			if(input.next().equals("y")) {
				int result = dao.removeBook(bookId);
				if(result>0) {
					System.out.println("\n归还书目成功！\n");
				}else {
					System.out.println("\n归还书目失败！\n");
				}
			}
		}
	}
	@Override
	public void showBookborrower(Integer bookId) {
		BookDao dao = new BookDaoImpl();
		List<Book>list = dao.listBook();
		System.out.println("请输入书目名称：");
		String bookname=input.next();
		for(Book book:list){
			//System.out.println(book.getBookId()+"\t"+book.getBookName()+"\t"+book.getBookExplain()+"\t"+book.getbooklenddate());
			if(book.getBookName().equals(bookname)){
				if(book.getBorrowerId()==0){
					System.out.println("\n还未借出\n");
				}
				else{
					System.out.println("\n已借出\n");
				}
			}

		}
	}

}
