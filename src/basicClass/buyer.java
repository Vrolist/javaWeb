package basicClass;

public class buyer extends baseclass {

	private static String db = "buyer";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			b = manager.login(buyer.db, "hus", "hus");
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
		buyer.db = db;
	}
}
