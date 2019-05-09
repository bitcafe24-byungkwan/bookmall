package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.BookmallSetting;
public class OrderBookDao {
	
	public Boolean insert(OrderBookVo vo)
	{
		Boolean res = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "insert into order_book values\r\n" + 
					"(convert(now(),date),\r\n" + 
					"(select count(*)-1 from orders where date = convert(now(),date)),\r\n" + 
					"(select idx from book where title = ?),\r\n" + 
					"?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBookName());
			pstmt.setInt(2, vo.getCnt());
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
	
	
	public void viewOrderBookList() {
		List<String> orderList = getOrderList();
		
		
		
		
		if(orderList.size()==0)return;
		
		
		for(String orderNum : orderList) {
			System.out.println("주문번호 : " + orderNum);
			getOrderBook(orderNum);
		}
		
		
	}
	private void getOrderBook(String orderNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = BookmallSetting.getConnection();

			String sql = "select b.title,b.price,a.cnt\r\n" + 
					"from order_book a\r\n" + 
					"join book b on a.book_idx = b.idx\r\n" + 
					"where \r\n" + 
					"concat(DATE_FORMAT(a.order_date,'%Y%m%d'),'-',lpad(a.order_idx,5,'0'))\r\n" + 
					" = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNum);
			
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
	private List<String> getOrderList() {
		List<String> result = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select concat(DATE_FORMAT(order_date,'%Y%m%d'),'-',lpad(order_idx,5,'0')) as order_number\r\n" + 
					"from order_book\r\n" + 
					"group by order_number";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {	
				String orderNumber = rs.getString(1);
							
				result.add(orderNumber);
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
