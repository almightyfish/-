package library.view;

import library.po.Borrower;

public interface BorrowerView {

	public void listBorrowerAll();
	public void listBorrower();
	public void saveBorrower();
	public void removeBorrower();

	public Borrower login();

	public void showBorrower(Integer borrowerId);
	public void editBorrower(Integer borrowerId);
	public void updateBorrowerByPassword(Integer borrowerId);
	public void updateBook();
}
