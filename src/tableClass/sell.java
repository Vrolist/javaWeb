package tableClass;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import operaDB.operaDB;

public class sell {
	private static String db = "sell";
	private int idgoods;
	private int idcashier;
	private int quantity;
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIdgoods() {
		return idgoods;
	}

	public void setIdgoods(int idgoods) {
		this.idgoods = idgoods;
	}

	public int getIdcashier() {
		return idcashier;
	}

	public void setIdcashier(int idcashier) {
		this.idcashier = idcashier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	public static boolean increaseSell(int idgoods, int idcashier, int quantity){
		String sql = "INSERT INTO sell(idgoods, idcashier, quantity) value (" + idgoods +","+idcashier+","+quantity+")";
		try {
			if(storage.reduceQuantity(idgoods, quantity) ){
				if( operaDB.execu(sql) == 1) {
					return true;
				}
			}
			else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static List<sell> allSell() {
		String sql = "select * from " + sell.db;
		try {
			ResultSet rs = operaDB.query(sql);
			List<sell> sells = new ArrayList<sell>();
			sell sf = null;
			while (rs.next()) {
				sf = new sell();
				sf.setNumber(rs.getInt(1));
				sf.setIdgoods(rs.getInt(2));
				sf.setIdcashier(rs.getInt(3));
				sf.setQuantity(rs.getInt(4));
				sells.add(sf);
			}
			return sells;
		} catch (Exception e) {
			return null;
		}
	}

	
	public static void main(String[] args) {
		//sell.increaseSell(102, 1401, 1);
		List<sell> sells = sell.allSell();
		Iterator<sell> sell = sells.iterator();
		while (sell.hasNext()) {
			sell se = sell.next();
			System.out.println(se.getNumber()+" "+se.getIdgoods() + " " + se.getIdcashier() + " " + se.getQuantity());
		}
	}

}
