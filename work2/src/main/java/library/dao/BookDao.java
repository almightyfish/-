package library.dao;

import java.util.List;

import library.po.Book;

public interface BookDao {

	public List<Book> listBookByBorrowerId(Integer borrowerId);
	public int saveBook(Book book);
	public Book getBookById(Integer bookId);
	public int updateBook(Book book);
//	public int getBorrowerId(Book book);
	public int removeBook(Integer bookId);
	public List<Book> listBook();
}
