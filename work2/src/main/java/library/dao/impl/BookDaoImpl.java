package library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import library.dao.BookDao;
import library.po.Book;
import library.util.DBUtil;

public class BookDaoImpl implements BookDao{
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public List<Book> listBookByBorrowerId(Integer borrowerId) {
		List<Book> list = new ArrayList<>();
		String sql = "select * from book where borrowerId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, borrowerId);
			rs = pst.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookExplain(rs.getString("bookExplain"));
				book.setBooklenddate(rs.getString("booklenddate"));
				book.setBorrowerId(rs.getInt("borrowerId"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return list;
	}

	@Override
	public List<Book> listBook() {
		List<Book> list = new ArrayList<>();
		String sql = "select * from book";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookExplain(rs.getString("bookExplain"));
				book.setBorrowerId(rs.getInt("borrowerId"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return list;
	}

//	@Override
//	public void updateBook(String bookName,Integer borrowerId,String booklenddate){
//		String sql="update from book set borrowerId=?,booklenddate=? where bookName=?";
//		try {
//			con = DBUtil.getConnection();
//			pst = con.prepareStatement(sql);
//			pst.setInt(1, borrowerId);
//			pst.setString(2, booklenddate);
//			pst.setString(3, bookName);
//			rs = pst.executeUpdate();
//			while(rs.next()) {
//				Book book = new Book();
//				book.setBookId(rs.getInt("bookId"));
//				book.setBookName(rs.getString("bookName"));
//				book.setBookExplain(rs.getString("bookExplain"));
//				book.setBooklenddate(rs.getString("booklenddate"));
//				book.setBorrowerId(rs.getInt("borrowerId"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(rs, pst, con);
//		}
//	}
	@Override
	public int saveBook(Book book) {
		int result = 0;
		String sql = "insert into book values(null,?,?,?,?)";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, book.getBookName());
			pst.setString(2, book.getBookExplain());
			pst.setString(3, book.getBooklenddate());
			pst.setInt(4, book.getBorrowerId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
	
	@Override
	public Book getBookById(Integer bookId) {
		Book book = null;
		String sql = "select * from book where bookId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, bookId);
			rs = pst.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookExplain(rs.getString("bookExplain"));
				book.setBooklenddate(rs.getString("booklenddate"));
				book.setBorrowerId(rs.getInt("borrowerId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return book;
	}
	
	@Override
	public int updateBook(Book book) {
		int result = 0;
		String sql = "update book set bookName=?,bookExplain=?,bookPrice=? where bookId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, book.getBookName());
			pst.setString(2, book.getBookExplain());
			pst.setString(3, book.getBooklenddate());
			pst.setInt(4, book.getBookId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
	
	@Override
	public int removeBook(Integer bookId) {
		int result = 0;
		String sql = "update  book set bookName='',borrowerId='0' where bookId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, bookId);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}

//	@Override
//	public int getBorrowerId(Integer bookId){
//		int result = 0;
//		String sql = "select borrowerId from book where bookId=?";
//		try {
//			con = DBUtil.getConnection();
//			pst = con.prepareStatement(sql);
//			pst.setInt(1, borrowerId);
//			result = pst.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(null, pst, con);
//		}
//		return result;
//	}
}
