package library.dao;

import java.util.List;

import library.po.Borrower;

public interface BorrowerDao {

	public List<Borrower> listBorrower(String borrowerName,String borrowerXY);
	public int saveBorrower(Integer borrowerId,String borrowerName);
	public int removeBorrower(int borrowerId);
	
	public Borrower getBorrowerByIdByPass(Integer borrowerId,String password);
	public Borrower getBorrowerById(Integer borrowerId);
	public int updateBorrower(Borrower borrower);
	public int updateBorrowerByPassword(Integer borrowerId,String password);
}
