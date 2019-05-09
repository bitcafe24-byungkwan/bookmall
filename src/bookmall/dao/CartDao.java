package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.BookmallSetting;
public class CartDao {
	
	public Boolean insert(CartVo vo)
	{
		Boolean res = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "insert into cart \r\n" + 
					" values( (Select idx from member where phone_num = ?),\r\n" + 
					" (Select idx from book where title = ?),\r\n" + 
					" ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMemberPhoneNumber());
			pstmt.setString(2, vo.getBookTitle());
			pstmt.setInt(3, vo.getCnt());
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
	
	public void viewCartList() {
		List<Long> memList = getMemberList();
		
		if(memList.size()==0)return;
		
		
		for(Long memId : memList) {
			System.out.println("멤버 ID " + memId.toString());
			getCart(memId);
		}
		
	}
	private void getCart(Long memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select b.title, b.price, a.cnt from cart a \r\n" + 
					"join book b on a.book_idx = b.idx \r\n" + 
					"where a.member_idx= ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, memId);
			
			rs = pstmt.executeQuery();
			
			Integer fullPrice = 0;
			while(rs.next()) {	
				String bookName = rs.getString(1);
				Integer bookPrice = rs.getInt(2);
				Integer cnt = rs.getInt(3);
				
				System.out.println(String.format
						("\t책제목 : %-15s, 가격 : %6d, 수량 : %3d", bookName,bookPrice,cnt));
				fullPrice += (cnt*bookPrice);
			}
			System.out.println("\t총 가격 -> " + fullPrice.toString());
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
	}
	private List<Long> getMemberList() {
		List<Long> result = new ArrayList<Long>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select member_idx from cart \r\n" + 
					"group by member_idx;";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {	
				Long id = rs.getLong(1);
							
				result.add(id);
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
	
	public void viewList() {
		List<CartVo> list = getList();

		for (CartVo vo : list)
			System.out.println(vo);
	}
	
	public List<CartVo> getList(){
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select a.member_idx, b.phone_num, a.book_idx, c.title, a.cnt, c.price from cart a \r\n" + 
					"join member b on a.member_idx = b.idx  \r\n" + 
					"join book c on a.book_idx = c.idx";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long memIdx = rs.getLong(1);
				String memberPhoneNumber = rs.getString(2);
				Long bookIdx = rs.getLong(3);
				String bookTitle = rs.getString(4);
				Integer cnt = rs.getInt(5);
				Integer price = rs.getInt(6);
				CartVo vo = new CartVo();
				vo.setMemberIdx(memIdx);
				vo.setMemberPhoneNumber(memberPhoneNumber);
				vo.setBookIdx(bookIdx);
				vo.setBookTitle(bookTitle);
				vo.setCnt(cnt);
				vo.setPrice(price*cnt);
				
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
