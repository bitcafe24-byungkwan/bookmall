package bookmall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookmallSetting {
	private static final String mariaClassName = "org.mariadb.jdbc.Driver"; 
	private static final String url = "jdbc:mariadb://lx01:3307/bookmall";
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			
			Class.forName(mariaClassName);
			
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		return conn;
	}
	public static void reset(String table) {


		Connection conn = null;
		PreparedStatement pstmt = null;
		String tempCol = "idx";
		if("cart".equals(table))
			tempCol = "cnt";
		else if ("order_book".equals(table))
			tempCol = "cnt";
		try {
			//Class.forName("org.mariadb.jdbc.Driver");
			//String url = "jdbc:mariadb://lx01:3307/bookmall";

			//conn = DriverManager.getConnection(url, "webdb", "webdb");
			conn = BookmallSetting.getConnection();

			String sql = "delete from "+table+" where "+tempCol+" != 9999999";
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, table);
			
			pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			System.out.println("error[["+table+"]]" + e);
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

	}
}
