package basicClass;

public class storagemanager extends baseclass {

	private static String db = "storagemanager";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			b = manager.login(storagemanager.db, "hus", "hus");
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
		storagemanager.db = db;
	}

}
