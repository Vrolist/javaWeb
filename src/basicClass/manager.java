package basicClass;

import java.sql.ResultSet;

import operaDB.operaDB;

public class manager extends baseclass {

	private static String db = "manager";

	/*
	 * public static boolean login(String string, String string2) throws
	 * Exception{ String sql = "select name from "+db+" where username = '"
	 * +string+"' and password = '"+string2+"'"; if(operaDB.login(sql)){ return
	 * true; } else return false; }
	 */
	public manager() {

	}

	public static manager newmanager(String username, String password) {
		String sql = "select * from " + manager.getDb() + " where username = '" + username + "' and password = '"
				+ password + "'";
		try {
			ResultSet rs = operaDB.query(sql);
			manager m = new manager();
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
		/*
		 * manager m = new manager(); boolean b = false; try { b =
		 * m.login("hus", "hus"); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		manager m = manager.newmanager("hus", "hus");
		System.out.println(m.getId() + " " + m.getUsername() + " " + m.getPassword());
	}

	public static String getDb() {
		return db;
	}

	public static void setDb(String db) {
		manager.db = db;
	}

}
