package basicClass;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import operaDB.operaDB;

public class mana extends basic {
	private static String db = "manager";

	public mana(String managerid, String pwd, String name, String phone,
			String DepartmentNo) {
		super(managerid, pwd, name, phone, DepartmentNo);
		// TODO Auto-generated constructor stub
	}

	public mana() {

	}

	public static boolean insert(String managerid, String name,
			String departmentid) {// �����³�Ա�����
		String sql = "insert into " + db
				+ " (managerid,name,departmentid) values('" + managerid + "','"
				+ name + "','" + departmentid + "')";
		try {
			if (operaDB.execu(sql) >= 1) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public static boolean delete(String managerid) {// ɾ��ĳ��Ա�����
		String sql = "delete from " + db + " where managerid = '" + managerid + "'";
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
	public static List<mana> queryListManager() {// ��ѯ
		String sql = "select managerid, pwd, name, phone, departmentid from " + db
				+ " ";
		try {
			ResultSet rs = operaDB.query(sql);
			List<mana> managers =  new ArrayList<mana>();
			mana sf = null;
			while (rs.next()) {
				sf = new mana();
				sf.setId(rs.getString(1));
				sf.setPwd(rs.getString(2));
				sf.setName(rs.getString(3));
				sf.setPhone(rs.getString(4));
				sf.setDepartmentNo(rs.getString(5));
				managers.add(sf);
			}
			return managers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static mana queryAllInformation(String managerid) {// ��ѯ
		String sql = "select managerid, pwd, name, phone, departmentid from " + db
				+ " where managerid=" + managerid;
		try {
			ResultSet rs = operaDB.query(sql);
			mana sf = new mana();
			if (rs.next()) {
				sf.setId(rs.getString(1));
				sf.setPwd(rs.getString(2));
				sf.setName(rs.getString(3));
				sf.setPhone(rs.getString(4));
				sf.setDepartmentNo(rs.getString(5));
			}
			return sf;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static mana queryByDepartmentid(String departmentid) {// ��ѯ
		String sql = "select managerid, pwd, name, phone, departmentid from " + db
				+ " where departmentid =" + departmentid;
		try {
			ResultSet rs = operaDB.query(sql);
			mana sf = new mana();
			if (rs.next()) {
				sf.setId(rs.getString(1));
				sf.setPwd(rs.getString(2));
				sf.setName(rs.getString(3));
				sf.setPhone(rs.getString(4));
				sf.setDepartmentNo(rs.getString(5));
			}
			return sf;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static mana queryWithOutPwd(String managerid) {// ��ѯ
		String sql = "select managerid, name, phone, departmentid from " + db
				+ " where managerid=" + managerid;
		try {
			ResultSet rs = operaDB.query(sql);
			mana sf = new mana();
			if (rs.next()) {
				sf.setId(rs.getString(1));
				sf.setName(rs.getString(2));
				sf.setPhone(rs.getString(3));
				sf.setDepartmentNo(rs.getString(4));
			}
			return sf;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean modificationAllInformation(String managerid,
			String pwd, String name, String phone, String departmentid) {// �޸Ļ���Ϣ�����
		String sql = "update " + db + " set pwd='" + pwd + "', name='" + name
				+ "', phone='" + phone + "', departmentid='" + departmentid
				+ "' where managerid='" + managerid + "'";
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
	public static boolean modification(String managerid, String name,
			String phone) {// �޸Ļ���Ϣ�����
		String sql = "update " + db + " set name='" + name + "', phone='"
				+ phone + "' where managerid='" + managerid + "'";
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

	public static boolean alterPwd(String managerid, String oldpwd,
			String newpwd) {// �޸����룬���
		String sql = "update " + db + " set pwd = '" + newpwd
				+ "' where managerid = '" + managerid + "' and pwd = '"
				+ oldpwd + "'";
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

	public static boolean login(String name, String pwd) {// ��½�����
		String sql = "select name from " + db + " where managerid = " + name
				+ " and pwd = " + pwd;
		try {
			if (operaDB.login(sql)) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		if(mana.delete("115")){
			System.out.println("Success");
		}
		else{
			System.out.println("False");
		}
//		manager.alterPwd("1", "1", "2");
//		manager m = manager.queryWithOutPwd("1");
//		System.out.println(m.getId());
//		System.out.println(m.getName());
//		System.out.println(m.getPhone());
//		System.out.println(m.getDepartmentNo());
	}
}
