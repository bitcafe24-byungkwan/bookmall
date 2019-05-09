package bookmall.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.BookmallSetting;

import bookmall.vo.OrderVo;

public class OrderDao {
	
	
	public Boolean insert(OrderVo vo)
	{
		Boolean res = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "insert into orders values\r\n " + 
					"(now(), \r\n" + 
					"(select count(*) from orders b where date = convert(now(),date)),\r\n" + 
					"?, \r\n" + 
					"(select idx a from member where phone_num = ?), \r\n" + 
					"'정상')";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAddress());
			pstmt.setString(2, vo.getMemberPhoneNumber());

			
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
		List<OrderVo> list = getList();

		for (OrderVo vo : list)
			System.out.println(vo);
	}
	public List<OrderVo> getList(){
		List<OrderVo> result = new ArrayList<OrderVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select concat(DATE_FORMAT(date,'%Y%m%d'),'-',lpad(a.idx,5,'0')) as order_number\r\n" + 
					", a.date, a.idx, a.address, b.phone_num, a.status, b.idx from orders a \r\n" + 
					"join member b on a.member_no = b.idx";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String orderNumber = rs.getString(1);
				String date = rs.getString(2);
				Long idx = rs.getLong(3);
				String address = rs.getString(4);
				String phoneNum = rs.getString(5);
				String status = rs.getString(6);
				Long memberIdx = rs.getLong(7);
				OrderVo vo = new OrderVo();
				
				vo.setOrderNumber(orderNumber);
				vo.setDate(date);
				vo.setIdx(idx);
				vo.setAddress(address);
				vo.setMemberPhoneNumber(phoneNum);
				vo.setStatus(status);
				vo.setMemberIdx(memberIdx);

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
