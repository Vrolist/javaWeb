package basicClass;

public class cashier extends baseclass {

	private static String db = "cashier";
	
	public static String getDb() {
		return db;
	}

	public static void setDb(String db) {
		cashier.db = db;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			b = manager.login(cashier.db, "hus", "hus");
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

}
