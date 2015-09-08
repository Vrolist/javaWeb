package basicClass;

import operaDB.operaDB;

public class manager extends baseclass {
	
	private static String db = "manager";
	/*
	public static boolean login(String string, String string2) throws Exception{
		String sql = "select name from "+db+" where username = '"+string+"' and password = '"+string2+"'";
		if(operaDB.login(sql)){
			return true;
		}
		else
			return false;
	}*/
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*manager m = new manager();
		boolean b = false;
		try {
			b = m.login("hus", "hus");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		boolean b = false;
		try {
			b = manager.login(manager.db, "hus", "hus");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==true){
			System.out.println("Success Login");
		}
		else{
			System.out.println("Fail Login");
		}
	}
	public static String getDb() {
		return db;
	}
	public static void setDb(String db) {
		manager.db = db;
	}

}
