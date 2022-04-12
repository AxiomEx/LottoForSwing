package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MySQLDB {
	
	public int login(String loginID, String loginPW) {
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
			String dbID = "root";
			String dbPW = "rootroot";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dbURL, dbID, dbPW);
				
				String sql = "select mID, mPW from memberTBL where mID = ? and mPW = ?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, loginID);
				pstmt.setString(2, loginPW);
				rs = pstmt.executeQuery();

				if(rs.next()) {
					
					String resultID = rs.getString("mID");
					String resultPW = rs.getString("mPW");
					if(resultID.equals(loginID) && resultPW.equals(loginPW)) {
						System.out.println("로그인 성공");
						return 1000;
					}
					
				} else {
					System.out.println("로그인 실패");
				}
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return 0;
			
		}
		
		
	
	
	public boolean idDuplicate(String mID){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
			
			String sql = "select mID from memberTBL where mID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mID);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("중복되는 ID가 존재합니다");
				
				return true;
			} else {
				System.out.println("사용 가능합니다.");
				
				return false;
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	

public void insert(String mID, String mPW) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
			
			String sql = "insert into memberTBL(mID, mPW) values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mID);
			pstmt.setString(2, mPW);
			pstmt.executeUpdate();
			
			System.out.println("MemberDTO insert() 메서드 실행 완료");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

}
