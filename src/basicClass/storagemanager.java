package basicClass;

import java.sql.ResultSet;

import operaDB.operaDB;

public class storagemanager extends baseclass {

	private static String db = "storagemanager";
	public static storagemanager newstoragemanager(String username, String password) {
		String sql = "select * from " + storagemanager.getDb() + " where username = '" + username + "' and password = '"
				+ password + "'";
		try {
			ResultSet rs = operaDB.query(sql);
			storagemanager m = new storagemanager();
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
		storagemanager m = storagemanager.newstoragemanager("hus", "hus");
		System.out.println(m.getId() + " " + m.getUsername() + " " + m.getPassword()+" "+m.getName());
	}

	public static String getDb() {
		return db;
	}

	public static void setDb(String db) {
		storagemanager.db = db;
	}

}
