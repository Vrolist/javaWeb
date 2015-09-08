package basicClass;
import operaDB.operaDB;
public class baseclass {
	private int id;
	private String username;
	private String password;
	private String name;
	public baseclass(){
		
	}
	public baseclass(int id,String username,String password,String name,String phone){
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	public static boolean login(String db, String username, String password) throws Exception{
		String sql = "select name from "+db+" where username = '"+username+"' and password = '"+password+"'";
		if(operaDB.login(sql)){
			return true;
		}
		else
			return false;
	}
	/*
	public static void main(String[] args){
		baseclass m = new baseclass();
		boolean b = false;
		try {
			b = m.login("hus", "hus");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b == true){
			System.out.println("Success Login");
		}
		else{
			System.out.println("Fail Login");
		}
	}*/
	
}
