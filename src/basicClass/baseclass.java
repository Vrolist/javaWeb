package basicClass;
import java.sql.ResultSet;

import operaDB.operaDB;
public class baseclass {
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
