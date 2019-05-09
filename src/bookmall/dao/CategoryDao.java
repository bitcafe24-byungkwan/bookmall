package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.BookmallSetting;
import bookmall.vo.CategoryVo;

public class CategoryDao {
	public Boolean insert(CategoryVo vo)
	{
		Boolean res = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "insert into category values(null,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategory());
						
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return res;
	}

	public void viewList() {
		List<CategoryVo> list = getList();

		for (CategoryVo vo : list)
			System.out.println(vo);
	}
	public List<CategoryVo> getList(){
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = BookmallSetting.getConnection();

			String sql = "select idx, name from category;";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long idx = rs.getLong(1);
				String name = rs.getString(2);

				CategoryVo vo = new CategoryVo();
				vo.setIdx(idx);
				vo.setCategory(name);				
				
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
