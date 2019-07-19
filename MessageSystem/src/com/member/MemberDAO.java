package com.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


public class MemberDAO {
		private Connection conn = null;
		private PreparedStatement psmt = null;
		
		private ResultSet rs;
		private String login_id;
		private static MemberDAO dao;
		private int cnt;
		
		private MemberDAO() {
			
		}
		public static MemberDAO getDAO() {
			if(dao==null)
				dao=new MemberDAO();
			return dao;
		}

		private void getConnection(){ // 드라이버 로딩와 커넥션해주는 메소드
			
			InputStream in=this.getClass().getResourceAsStream("db.properties");
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

		public int join(MemberDTO dto) {
			// TODO Auto-generated method stub
			getConnection();
			try {

				String sql = "insert into web_member values(?,?,?,?,2)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getEmail());
				psmt.setString(2, dto.getPw());
				psmt.setString(3, dto.getTel());
				psmt.setString(4, dto.getAdd());
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
		public MemberDTO login(MemberDTO dto) {
			getConnection();
			MemberDTO m=null;
			try {
				String sql="select * from web_member where email =? and pw=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getEmail());
				psmt.setString(2, dto.getPw());
				
				rs=psmt.executeQuery();
				
				if (rs.next()) {
					String email=rs.getString(1);
					String pw=rs.getString(2);
					String tel=rs.getString(3);
					String add=rs.getString(4);
					int admin=rs.getInt(5);
					m=new MemberDTO(email,pw,tel,add,admin);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				close();
			}
			return m;
		}
		public MemberDTO update(MemberDTO dto) {
			getConnection();
			
			try {
				String sql="update web_member set pw=?, tel=?, address=? where  email=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getPw());
				psmt.setString(2, dto.getTel());
				psmt.setString(3, dto.getAdd());
				psmt.setString(4, dto.getEmail());
				cnt=psmt.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				close();
			}
			if (cnt>0) {
				return dto;
			}
			return null;
		
		}
		public ArrayList<MemberDTO> selectAll() {
			getConnection();
			ArrayList<MemberDTO> m=new ArrayList<MemberDTO>();
			try {
				String sql="select * from web_member where admin=2";
				psmt = conn.prepareStatement(sql);
				
				rs=psmt.executeQuery();
				
				while (rs.next()) {
					String email=rs.getString(1);
					String pw=rs.getString(2);
					String tel=rs.getString(3);
					String add=rs.getString(4);
					int admin=rs.getInt(5);
					m.add(new MemberDTO(email,pw,tel,add,admin));
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				close();
			}
			return m;
		}		

}
