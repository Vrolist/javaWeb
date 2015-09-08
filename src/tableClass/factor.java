package tableClass;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import operaDB.operaDB;

public class factor {
	private static String db = "factor";
	
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	private int idfactor;
	private int idgoods;
	private String name;
	private String address;
	private String principal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdfactor() {
		return idfactor;
	}
	public void setIdfactor(int idfactor) {
		this.idfactor = idfactor;
	}
	public int getIdgoods() {
		return idgoods;
	}
	public void setIdgoods(int idgoods) {
		this.idgoods = idgoods;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public static boolean deleteFactor(int idfactor){
		return false;
	}
	public static boolean insertFactor(int idfactor, int idgoods, String name, String address, String principal){
		String sql = "INSERT INTO factor(idfactor, idgoods, name, address, principal) value (" + idfactor +","+ idgoods +",'"+ name +"','"+ address +"','"+ principal +"')";
		//System.out.println(sql);
		try {
			if (operaDB.execu(sql) == 1) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static List<factor> allfactor(){
		String sql = "select * from " + factor.db;
		try {
			ResultSet rs = operaDB.query(sql);
			List<factor> factors = new ArrayList<factor>();
			factor sf = null;
			while (rs.next()) {
				sf = new factor();
				sf.setNumber(rs.getInt(1));
				sf.setIdfactor(rs.getInt(2));
				sf.setIdgoods(rs.getInt(3));
				sf.setName(rs.getString(4));
				sf.setAddress(rs.getString(5));
				sf.setPrincipal(rs.getString(6));
				factors.add(sf);
			}
			return factors;
		} catch (Exception e) {
			return null;
		}
	}
	public static void main(String[] args){
		//factor.insertFactor(111, 23, "guess", "England", "you know");
		
		
		List<factor> factors = factor.allfactor();
		Iterator<factor> factor = factors.iterator();
		while (factor.hasNext()) {
			factor fac = factor.next();
			System.out.println(fac.getNumber()+" "+fac.getIdfactor()+" "+fac.getIdgoods()+" "+fac.getName()+" "+fac.getAddress()+" "+fac.getPrincipal());
		}
	}
}
