package library.view;

import java.util.List;

import library.po.Book;

public interface BookView {

	public List<Book> showBookList(Integer borrowerId);
	public void saveBook(Integer borrowerId);
	public void removeBook(Integer borrowerId);
	public void showBookborrower(Integer bookId);
}
