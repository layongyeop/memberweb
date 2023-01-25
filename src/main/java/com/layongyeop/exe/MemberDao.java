package com.layongyeop.exe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class MemberDao {
	
	
	
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/webdb";
	String username = "root";
	String password = "1234";
	
	
	public int joinMember(String id , String pw , String name, String email) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO members(id,password,name,email) values(?,?,?,?)";
		int resultFlag=0;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			resultFlag = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		
		
		
		return resultFlag;
		
		
	}
	public int idCheck(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM members where id ='"+id+"'";
		
		int resultFlag = 0;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				resultFlag = 1;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		
		return resultFlag;
		
	}
	
	
	public int loginCheck(String id, String pw) {
		int idcheck = idCheck(id); // 1이면 가입된 아이디
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM members where id ='"+id+"'";
		
		
		int resultFlag = 0;
		if(idcheck ==1) {
			
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, username, password);
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					if(rs.getString("password").equals(pw)) { // 아이디 비밀번호 일치 => 로그인성공
						resultFlag = 1;
					}
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e2){
					e2.printStackTrace();
					
				}
			}
			
		}
		
		return resultFlag; // 1이면 로그인성공 아니면 실패
		
	}
	
	
	public MemberDto getMemberInfo(String id) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM members where id ='"+id+"'";
			
		MemberDto dto = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
		
				dto = new MemberDto();
//				dto = new MemberDto(did,dpw,dname,demail,djointime);
				
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setJointime(rs.getTimestamp("jointime"));


				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		
	
	
	
	return dto;
	}
	
	public int modify(String id,String pw, String name, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE members SET password = ?, name = ?, email = ? WHERE id = ?";
		
		int resultFlag = 0;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pw);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setString(4,id);
			
			resultFlag = pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		return resultFlag;
		
	}
	
	public int memberWithdraw(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM members WHERE id = ?";
		
		int resultFlag = 0;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			resultFlag = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		return resultFlag;
		
	}
}
