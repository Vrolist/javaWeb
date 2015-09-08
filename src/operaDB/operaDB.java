package operaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




import connectDB.DatabaseConnection;

public class operaDB {

	public static ResultSet query(String sql) throws Exception {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		return rs;
		
	}
	
	public static boolean login(String sql) throws Exception {
		System.out.println(sql);
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
		
	}

	public static int execu(String sql) throws Exception {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int p = pstmt.executeUpdate();
		if(p!=-1){
			return p;
		}else{
		return -1;
		}
	}
	
}
