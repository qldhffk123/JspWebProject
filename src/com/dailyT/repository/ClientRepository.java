package com.dailyT.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dailyT.db.DBconnection;
import com.dailyT.dto.subReplyView;
import com.dailyT.model.Customer;
import com.dailyT.model.Product;
import com.dailyT.model.SubProduct;
import com.dailyT.model.SubReply;

public class ClientRepository {
	private static final String TAG="AdminRepository : ";
	
	//싱글톤 패턴 제작
	private static ClientRepository instance = new ClientRepository();
	private ClientRepository() {}
	public static ClientRepository getInstance() {
		return instance;
	}
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public List<subReplyView> findSubReply(int subid) {
		final String SQL="select replyid,subreply.custid,nickname,score,content " + 
				"from subreply,customer " + 
				"where subreply.custid=customer.custid and subid=? order by replyid desc";
		List<subReplyView> subReplies=new ArrayList<>();
		subReplyView subReply=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, subid);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subReply=subReplyView.builder()
						.replyid(rs.getInt("replyid"))
						.custid(rs.getInt("custid"))
						.nickname(rs.getString("nickname"))
						.score(rs.getInt("score"))
						.content(rs.getString("content"))
						.build();
				subReplies.add(subReply);
			}
			
			return subReplies;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"findSubReply : "+e.getMessage());
		}
		return null;
	}
	
	public int subReplySave(SubReply subReply) {
		final String SQL="insert into subReply (replyid,custid,subid,score,content) " + 
				"VALUES (subreply_SEQ.nextval,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, subReply.getCustid());
			pstmt.setInt(2, subReply.getSubid());
			pstmt.setInt(3, subReply.getScore());
			pstmt.setString(4, subReply.getContent());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"subReplySave : "+e.getMessage());
		}
		return -1;
	}
		
	public SubProduct findSubProductBySubID(int subId) {
		final String SQL="select subId, subname,subPrice,subsale,subDate,subPhoto,subPreview,subContent from subproduct where subId=?";

		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, subId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subId"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subPrice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subphoto"))
						.subPreview(rs.getString("subPreview"))
						.subContent(rs.getString("subcontent"))
						.build();
				return subproduct;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"findSubProductBySubID : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindAllSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate,subPhoto,subPreview from subproduct";
		List<SubProduct> subproducts=new ArrayList<>();
		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subid"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subprice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subPhoto"))
						.subPreview(rs.getString("subPreview"))
						.build();
				subproducts.add(subproduct);
			}
			
			return subproducts;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllSubProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindOriginSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate,subPhoto,subPreview from subproduct where subdate is null";
		List<SubProduct> subproducts=new ArrayList<>();
		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subid"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subprice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subPhoto"))
						.subPreview(rs.getString("subPreview"))
						.build();
				subproducts.add(subproduct);
			}
			
			return subproducts;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllSubProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<SubProduct> FindSeasonSubProduct() {
		final String SQL="select subid,subname,subprice,subsale,subdate,subPhoto,subPreview from subproduct where subdate is not null";
		List<SubProduct> subproducts=new ArrayList<>();
		SubProduct subproduct=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				subproduct=SubProduct.builder()
						.subId(rs.getInt("subid"))
						.subName(rs.getString("subname"))
						.subPrice(rs.getInt("subprice"))
						.subSale(rs.getInt("subsale"))
						.subDate(rs.getString("subdate"))
						.subPhoto(rs.getString("subPhoto"))
						.subPreview(rs.getString("subPreview"))
						.build();
				subproducts.add(subproduct);
			}
			
			return subproducts;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllSubProduct : "+e.getMessage());
		}
		return null;
	}
	
	public List<Product> FindAllProduct() {
		final String SQL="select proid,proname,proprice,prosale,prokind,prostock,prodate from product";
		List<Product> products=new ArrayList<>();
		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proid"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("proSale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("proStock"))
						.proDate(rs.getString("proDate"))
						.build();
				products.add(product);
			}
			
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"FindAllProduct : "+e.getMessage());
		}
		return null;
	}
	
	public int proSave(String proname,int proPrice, int proSale, String prokind, int proStock, String proDate, String proPhoto,String preview,String proContent) {
		final String SQL="insert into Product (proid,proname,proPrice,prosale,prokind,proStock,proDate,proPhoto,preview,proContent) " + 
				"VALUES (PRODUCT_SEQ.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, proname);
			pstmt.setInt(2, proPrice);
			pstmt.setInt(3, proSale);
			pstmt.setString(4, prokind);
			pstmt.setInt(5, proStock);
			pstmt.setString(6, proDate);
			pstmt.setString(7, proPhoto);
			pstmt.setString(8, preview);
			pstmt.setString(9, proContent);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG+"proSave : "+e.getMessage());
		}
		return -1;
	}
		
	public int productUpdate(String proname,int proPrice, int proSale, String prokind, int proStock, String proDate, String proPhoto,String preview,String proContent, int proid) {
		final String SQL="update product set proname=?, proPrice=?, proSale=?, prokind=?, proStock=?, proDate=?, proPhoto=?,preview=?, proContent=? where proid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, proname);
			pstmt.setInt(2, proPrice);
			pstmt.setInt(3, proSale);
			pstmt.setString(4, prokind);
			pstmt.setInt(5, proStock);
			pstmt.setString(6, proDate);
			pstmt.setString(7, proPhoto);
			pstmt.setString(8, preview);
			pstmt.setString(9, proContent);
			pstmt.setInt(10, proid);
			
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"productUpdate : "+e.getMessage());
			
		}
		return -1;
	}
	
	public int subproductUpdate(String subName,int subPrice, int subSale, String subDate, String subPhoto,String subPreview,String subContent, int subid) {
		final String SQL="update subproduct set subName=?, subPrice=?, subSale=?, subDate=?, subPhoto=?, subPreview=?,subContent=? where subid=?";

		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, subName);
			pstmt.setInt(2, subPrice);
			pstmt.setInt(3, subSale);
			pstmt.setString(4, subDate);
			pstmt.setString(5, subPhoto);
			pstmt.setString(6, subPreview);
			pstmt.setString(7, subContent);
			pstmt.setInt(8, subid);
			
			
			int result=pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"subproductUpdate : "+e.getMessage());
		
		}
		return -1;
	}
	
	public Product findProductByProID(int proId) {
		final String SQL="select proId, proname,proPrice,prosale,prokind,proStock,proDate,proPhoto,preview,proContent from product where proId=?";

		Product product=null;
		try {
			conn=DBconnection.DBconn();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, proId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				product=Product.builder()
						.proId(rs.getInt("proId"))
						.proName(rs.getString("proname"))
						.proPrice(rs.getInt("proPrice"))
						.proSale(rs.getInt("prosale"))
						.prokind(rs.getString("prokind"))
						.proStock(rs.getInt("prostock"))
						.proDate(rs.getString("prodate"))
						.proPhoto(rs.getString("prophoto"))
						.preview(rs.getString("preview"))
						.proContent(rs.getString("procontent"))
						.build();
				return product;
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