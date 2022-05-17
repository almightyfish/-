package library.po;

public class Borrower {

	private Integer borrowerId;
	private String password;
	private String borrowerName;
	private String borrowerXY;

	@Override
	public String toString() {
		return "\n借阅者编号："+this.borrowerId+
			   "\n借阅者名称："+this.borrowerName+
			   "\n借阅者学院："+this.borrowerXY;
	}
	
	public Integer getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getBorrowerXY() {
		return borrowerXY;
	}
	public void setBorrowerXY(String borrowerXY) {
		this.borrowerXY = borrowerXY;
	}
}
