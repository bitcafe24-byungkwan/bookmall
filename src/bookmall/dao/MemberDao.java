package bookmall.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.BookmallSetting;
import bookmall.vo.MemberVo;

public class MemberDao {
	

	public Boolean update(Long no, String status) {
		Boolean res = false;
		return res;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//
//			conn = BookmallSetting.getConnection();
//
//			String sql = "update book \r\n" + 
//					" set status = ? \r\n" + 
//					" where no= ? ";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, status);
//			pstmt.setLong(2, no);
//			
//			int count = pstmt.executeUpdate();			
//			res = (count == 1);
//			
//		} catch (SQLException e) {
//			System.out.println("error" + e);
//		} finally {	
//			try {
//
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return res;
	}
	public Boolean insert(MemberVo vo)
	{
		Boolean res = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "insert into member \r\n" + 
					"values \r\n" + 
					"(null,?,?,password(?))";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPhoneNumber());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPwd());
			
			int count = pstmt.executeUpdate();			
			res = (count == 1);
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {	
			try {

				if(pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return res;
	}

	public void viewList() {
		List<MemberVo> list = getList();

		for (MemberVo vo : list)
			System.out.println(vo);
	}
	public List<MemberVo> getList(){
		List<MemberVo> result = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select idx,phone_num,email,pwd from member \r\n" + 
					"order by idx asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				Long idx = rs.getLong(1);
				String phoneNum = rs.getString(2);
				String email = rs.getString(3);
				String pwd = rs.getString(4);
				MemberVo vo = new MemberVo();
				vo.setIdx(idx);
				vo.setPhoneNumber(phoneNum);
				vo.setEmail(email);
				vo.setPwd(pwd);

				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
	
			try {
				if ( rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
