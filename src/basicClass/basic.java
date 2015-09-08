package basicClass;

import java.sql.ResultSet;

import operaDB.operaDB;

public class basic {
	private static String db = "manager";
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String DepartmentNo;
	public basic(){
		
	}
	public basic(String id,String pwd,String name,String phone,String DepartmentNo){//���캯��
		this.id = id;
		this.pwd = pwd;
		this.name =name;
		this.phone = phone;
		this.DepartmentNo = DepartmentNo;
	}
	public static boolean insert(String staffid,String name,String departmentid) {//�����³�Ա�����
		String sql = "insert into "+db+"(staffid,name,departmentid) values('"+staffid+"','"+name+"','"+departmentid+"')";
		try {
			if(operaDB.execu(sql)>=1){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}
	public static boolean delete(String id) {//ɾ��ĳ��Ա�����
		String sql = "delete from "+db+" where staffid="+id+"";
		try {
			if(operaDB.execu(sql)==1){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public static basic query(String id) {//��ѯ
		
		
		return null;
	}
	public static boolean modification(String id, String name, String phone) {//�޸Ļ���Ϣ�����
		String sql = "update "+db+" set name='"+name+"', phone='"+phone+"' where staffid='"+id+"'";
		try {
			if(operaDB.execu(sql)==1){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}
	public static boolean alterPwd(String id,String oldpwd,String newpwd){//�޸����룬���
		String sql = "update "+db+" set pwd = '"+newpwd+"' where staffid = '"+id+"' and pwd = '"+oldpwd+"'";
		try {
			if(operaDB.execu(sql)==1){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean login(String name, String pwd) {//��½�����
		String sql = "select name from "+db+" where staffid = "+name+" and pwd = "+pwd;
		try {
			if(operaDB.login(sql)){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartmentNo() {
		return DepartmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		DepartmentNo = departmentNo;
	}
	
	public static void main(String[] args){
		basic b = new basic();
		if(b.login("1", "1")){
			System.out.println("Test Success!");
		}
		else{
			System.out.println("Test False!");
		}
		
		
	}
}


