package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dailyT.db.DBconnection;
import com.dailyT.model.Customer;

public class CustomerRepository {
	private static final String TAG="CustomerRepository : ";
	
	//싱글톤 패턴 제작
	private static CustomerRepository instance = new CustomerRepository();
	private CustomerRepository() {}
	public static CustomerRepository getInstance() {
		return instance;
	}
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public int custUpdate(String nickname, String email, String address, String cellphone, String userID) {
		final String SQL="update customer set nickname=?, email=?, address=?, cellphone=? where userid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, nickname);
			pstmt.setString(2, email);
			pstmt.setString(3, address);
			pstmt.setString(4, cellphone);
			pstmt.setString(5, userID);
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"custUpdate : "+e.getMessage());
			// TODO: handle exception
		}
		return -1;
	}
	
	public String FindPWByCustid(int custid) {
		final String SQL="select password from customer where custid=?";
		String resultPassword=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, custid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				resultPassword=rs.getString("password");
				return resultPassword;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int resetPW(String password, String userID) {
		final String SQL="update customer set password=? where userid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setString(2, userID);
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int save(String userID, String password, String username, String nickname, String email, String address, String cellphone) {
		final String SQL="insert into customer (custid,userid,password,username,nickname,email,address,cellphone,userrole,createdate) " + 
				"VALUES (CUSTID_SEQ.nextval,?,?,?,?,?,?,?,'사용자',sysdate)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
			pstmt.setString(4, nickname);
			pstmt.setString(5, email);
			pstmt.setString(6, address);
			pstmt.setString(7, cellphone);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		}
		return -1;
	}
	
	public int userIDCheck(String userID) {
		final String SQL="select count(userID) from customer where userid=?";
		int result=0;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result=rs.getInt(1);
			}
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public String FindIDByUsernameAndEmail(String username,String email) {
		final String SQL="select userID from customer where username=? and email=?";
		String result=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result=rs.getString("userID");
			}
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int FindIDByUserIDandUsernameAndEmail(String username, String userID, String email) {
		final String SQL="select count(*) from customer where username=? and userID=? and email=?";
		int result=0;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, userID);
			pstmt.setString(3, email);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				result=rs.getInt(1);
			}
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public Customer findByUserIDandPassword(String userID,String password) {
		final String SQL="select custid,userid,username,nickname,email,address,cellphone,userrole " + 
						"from customer " + 
						"where userid=? and password=?";
		Customer cust=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				cust=Customer.builder()
					.custid(rs.getInt("custid"))
					.userId(rs.getString("userid"))
					.username(rs.getString("username"))
					.nickname(rs.getString("nickname"))
					.email(rs.getString("email"))
					.address(rs.getString("address"))
					.cellphone(rs.getString("cellphone"))
					.userrole(rs.getString("userrole"))
					.build();
			}
			return cust;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findByUserIDandPassword : "+e.getMessage());
		}
		return null;
		
	}
	
}
