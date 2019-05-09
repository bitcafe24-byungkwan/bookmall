package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.BookmallSetting;
import bookmall.vo.BookVo;

public class BookDao {
	
	public Boolean update(Long no, String status) {
		Boolean res = false;
		
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
		return res;
	}
	public Boolean insert(BookVo vo)
	{
		Boolean res = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "insert into book \r\n" + 
					"values \r\n" + 
					"(null,?,?,(select idx from category where name = ?))";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getCategoryName());
			
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
		List<BookVo> list = getList();

		for (BookVo vo : list)
			System.out.println(vo);
	}
	public List<BookVo> getList(){
		List<BookVo> result = new ArrayList<BookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select a.idx, a.title, a.price, b.idx,b.name from book a \r\n" + 
					"join category b on a.category_idx = b.idx \r\n" + 
					"					order by a.idx asc;";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long idx = rs.getLong(1);
				String title = rs.getString(2);
				Integer price = rs.getInt(3);
				Long categoryIdx = rs.getLong(4);
				String categoryName = rs.getString(5);
				BookVo vo = new BookVo();
				vo.setIdx(idx);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setIdxCategory(categoryIdx);
				vo.setCategoryName(categoryName);
				
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
