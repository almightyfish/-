package library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import library.dao.BorrowerDao;
import library.po.Borrower;
import library.util.DBUtil;

public class BorrowerDaoImpl implements BorrowerDao{
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	@Override
	public List<Borrower> listBorrower(String borrowerName,String borrowerXY) {
		List<Borrower> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from borrower where 1=1 ");
		if(borrowerName!=null&&!borrowerName.equals("")) {
			sql.append(" and borrowerName like '%"+borrowerName+"%' ");
		}
		if(borrowerXY!=null&&!borrowerXY.equals("")) {
			sql.append(" and borrowerAddress like '%"+borrowerXY+"%' ");
		}
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql.toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				Borrower borrower = new Borrower();
				borrower.setBorrowerId(rs.getInt("borrowerId"));
				borrower.setPassword(rs.getString("password"));
				borrower.setBorrowerName(rs.getString("borrowerName"));
				borrower.setBorrowerXY(rs.getString("borrowerXY"));
				list.add(borrower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return list;
	}
	
	@Override
	public int saveBorrower(Integer borrowerId,String borrowerName) {
		String sql = "insert into borrower(borrowerID,borrowerName,password) values(?,?,‘123’)";
		try {
			con = DBUtil.getConnection();
			//设置返回自增长列值
			pst = con.prepareStatement(sql.toString());
			pst.setString(2, borrowerName);
			pst.setInt(1, borrowerId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return borrowerId;
	}
	
	@Override
	public int removeBorrower(int borrowerId) {
		int result = 0;
		String delFootSql = "delete from book where borrowerId=?";
		String delBorrowerSql = "delete from borrower where borrowerId=?";
		try {
			con = DBUtil.getConnection();
			//开启一个事务
			con.setAutoCommit(false);
			
			pst = con.prepareStatement(delFootSql);
			pst.setInt(1, borrowerId);
			pst.executeUpdate();
			
			pst = con.prepareStatement(delBorrowerSql);
			pst.setInt(1, borrowerId);
			result = pst.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			result = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
	
	@Override
	public Borrower getBorrowerByIdByPass(Integer borrowerId,String password) {
		Borrower borrower = null;
		String sql = "select * from borrower where borrowerId=? and password=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, borrowerId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while(rs.next()) {
				borrower = new Borrower();
				borrower.setBorrowerId(rs.getInt("borrowerId"));
				borrower.setPassword(rs.getString("password"));
				borrower.setBorrowerName(rs.getString("borrowerName"));
				borrower.setBorrowerXY(rs.getString("borrowerXY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return borrower;
	}
	
	@Override
	public Borrower getBorrowerById(Integer borrowerId) {
		Borrower borrower = null;
		String sql = "select * from borrower where borrowerId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, borrowerId);
			rs = pst.executeQuery();
			while(rs.next()) {
				borrower = new Borrower();
				borrower.setBorrowerId(rs.getInt("borrowerId"));
				borrower.setPassword(rs.getString("password"));
				borrower.setBorrowerName(rs.getString("borrowerName"));
				borrower.setBorrowerXY(rs.getString("borrowerXY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst, con);
		}
		return borrower;
	}
	
	@Override
	public int updateBorrower(Borrower borrower) {
		int result = 0;
		String sql = "update borrower set borrowerName=?,borrowerXY=?  where borrowerId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, borrower.getBorrowerName());
			pst.setString(2, borrower.getBorrowerXY());
			pst.setInt(3, borrower.getBorrowerId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
	
	@Override
	public int updateBorrowerByPassword(Integer borrowerId,String password) {
		int result = 0;
		String sql = "update borrower set password=? where businessId=?";
		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, borrowerId);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst, con);
		}
		return result;
	}
}
