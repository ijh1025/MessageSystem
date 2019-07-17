package com.message;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


public class MessageDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private int cnt;
	private ResultSet rs;
	
	private void getConnection(){ // 드라이버 로딩와 커넥션해주는 메소드
		
		InputStream in=this.getClass().getResourceAsStream("../member/db.properties");
		Properties pro=new Properties();
		
		try {
		pro.load(in);
		String driver=pro.getProperty("driver");
		String url=pro.getProperty("url");
		String id=pro.getProperty("id");
		String pw=pro.getProperty("pw");
		
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1드라이버 로딩 forName안에
		catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			} // 5_0.순서대로 닫음
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public int join(MessageDTO dto) {
		// TODO Auto-generated method stub
		getConnection();
		try {

			String sql = "insert into web_message values(num.nextval,?,?,?,sysdate)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSend_name());
			psmt.setString(2, dto.getReceive_email());
			psmt.setString(3, dto.getContent());
			
			cnt = 0;
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	}
	public ArrayList<MessageDTO> selectMessage(String email) {
		getConnection();
		ArrayList<MessageDTO> list=new ArrayList<MessageDTO>();
		try {
			String sql="select * from web_message where receive_email =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				MessageDTO dto=new MessageDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	public int deleteOne(String num) {
		getConnection();
		try {

			String sql = "delete web_message where num=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			
			cnt = 0;
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	}
	public int deleteAll(String email) {
		getConnection();
		try {

			String sql = "delete web_message where receive_email=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			
			cnt = 0;
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	}
}
