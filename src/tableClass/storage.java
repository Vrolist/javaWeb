package tableClass;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import operaDB.operaDB;

public class storage {
	private static String db = "storage";
	private int idgoods;
	private int quantity;
	private float sell;

	public int getIdgoods() {
		return idgoods;
	}

	public void setIdgoods(int idgoods) {
		this.idgoods = idgoods;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSell() {
		return sell;
	}

	public void setSell(float sell) {
		this.sell = sell;
	}

	public static List<storage> allstorage() {
		String sql = "select * from " + storage.db;
		try {
			ResultSet rs = operaDB.query(sql);
			List<storage> storages = new ArrayList<storage>();
			storage sf = null;
			while (rs.next()) {
				sf = new storage();
				sf.setIdgoods(rs.getInt(1));
				sf.setQuantity(rs.getInt(2));
				sf.setSell(3);
				storages.add(sf);
			}
			return storages;
		} catch (Exception e) {
			return null;
		}
	}

	// success market commodity and reduce the quantity
	public static boolean reduceQuantity(int idgoods, int quantity) {
		String sql = "update storage set quantity = quantity - " + quantity + " where idgoods = " + idgoods;
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

	public static boolean deleteCargo(int idgoods){
		String sql = "delete from storage where idgoods = " + idgoods;
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
	
	public static boolean insertNewCargo(int idgoods, int quantity,float sell){
		String sql = "INSERT INTO storage(idgoods, quantity, sell) value (" + idgoods +","+quantity+","+sell+")";
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

	// success market commodity and reduce the quantity
	public static boolean increaseQuantity(int idgoods, int quantity) {
		String sql = "update storage set quantity = quantity + " + quantity + " where idgoods = " + idgoods;
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

	public static void main(String[] args) {
		storage.reduceQuantity(102, 100);
		List<storage> storages = storage.allstorage();
		Iterator<storage> storage = storages.iterator();
		while (storage.hasNext()) {
			storage sto = storage.next();
			System.out.println(sto.getIdgoods() + " " + sto.getQuantity() + " " + sto.getSell());
		}
	}

}
