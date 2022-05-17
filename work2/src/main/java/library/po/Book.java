package library.po;

public class Book {

	private Integer bookId;
	private String bookName;
	private String bookExplain;
	private String booklenddate;
	private Integer borrowerId;
	
	@Override
	public String toString() {
		return "\n书目编号："+this.bookId+
			   "\n书目名称："+this.bookName+
			   "\n书目介绍："+this.bookExplain+
			   "\n书目借出时间："+this.booklenddate+
			   "\n书目借阅者编号："+this.borrowerId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookExplain() {
		return bookExplain;
	}

	public void setBookExplain(String bookExplain) {
		this.bookExplain = bookExplain;
	}

	public String getBooklenddate() {
		return booklenddate;
	}

	public void setBooklenddate(String booklenddate) {
		this.booklenddate = booklenddate;
	}

	public Integer getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}
}
