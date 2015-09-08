package basicClass;

import java.sql.ResultSet;

import operaDB.operaDB;

public class buyer extends baseclass {

	private static String db = "buyer";
	
	public static buyer newbuyer(String username, String password) {
		String sql = "select * from " + buyer.getDb() + " where username = '" + username + "' and password = '"
				+ password + "'";
		try {
			ResultSet rs = operaDB.query(sql);
			buyer m = new buyer();
			while (rs.next()) {
				m.setId(rs.getInt(1));
				m.setUsername(rs.getString(2));
				m.setPassword(rs.getString(3));
				m.setName(rs.getString(4));
			}
			return m;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buyer m = buyer.newbuyer("hus", "hus");
		System.out.println(m.getId() + " " + m.getUsername() + " " + m.getPassword()+" "+m.getName());
	}

	public static String getDb() {
		return db;
	}

	public static void setDb(String db) {
		buyer.db = db;
	}
}
