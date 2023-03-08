package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	private static Dao dao = new Dao();
	public Dao getInstance () {return dao;}
	
	public Connection con ; 
	public PreparedStatement ps;
	public ResultSet rs;
		
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("[연동성공]");
		}
		catch (Exception e) {System.out.println("연동실패"+e);}
	}
}
