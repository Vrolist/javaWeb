package connectDB;
import java.sql.*;
public class DatabaseConnection {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	public static final String DBURL = "jdbc:mysql://localhost:3306/supermarket" ;
	public static final String DBUSER = "root" ;
	public static final String DBPASS = "husxx" ;
	private Connection conn = null;
	public DatabaseConnection() throws Exception{
		try{
			Class.forName(DBDRIVER);
		    this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		}catch(Exception e){
			throw e;
		}
	}
	public Connection getConnection() {
		return this.conn;
	}
	public void close() throws Exception{
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch(Exception e){
				throw e;
			}
		}
			
	}
	/*
	public static void mian(String[] args) throws Exception{
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select name from beancloth.staff where staffid = 1201 and pwd = 1201");
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("Success Connection DB");
		}
		else
			System.out.println("Error");
	}*/
	
}


