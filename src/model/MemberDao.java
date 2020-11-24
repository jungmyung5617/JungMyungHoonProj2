package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

public class MemberDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public MemberDao(ServletContext context) {
		try {
	         Context ctx = new InitialContext();
	         DataSource source = (DataSource)ctx.lookup("java:comp/env/kosmo");
	         conn = source.getConnection();
	         System.out.println("연결성공");
	      } catch (NamingException | SQLException e) {e.printStackTrace();}
	}/////MemberDAO
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException e) {e.printStackTrace();}
	}////close
	
	public boolean isMember(String id,String pwd) {
		String sql="SELECT COUNT(*) FROM member WHERE id=? AND pwd=?";
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0) return false;
		}
		
		
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}////////////isMember
	
	public void insert(String id,String pwd,String name,int age,String address,String email,int phoneNumber,String gender,String grade) {
		
		String sql="INSERT INTO member(id,pwd,name,age,address,email,phoneNumber,gender,grade) VALUES(?,?,?,?,?,?,?,?,?)";
			try {
				psmt=conn.prepareStatement(sql);
				
				psmt.setString(1,id);
				psmt.setString(2,pwd);
				psmt.setString(3,name);
				psmt.setInt(4,age);
				psmt.setString(5,address);
				psmt.setString(6,email);
				psmt.setInt(7,phoneNumber);
				psmt.setString(8,gender);
				psmt.setString(9,grade);
				
				psmt.execute();
			}
			catch(Exception e) {e.printStackTrace();}
	}/////insert
	
}//////MemberDAO
