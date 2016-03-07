package javaBean;
import java.sql.*;
import java.util.*;

public class JDBCcon {
	private String dbUrl="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private String userName="scott";	
	private String userPW= "tiger";	
	private Connection con;
	private Statement stmt;	
		
	public Connection getConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException CNFE){
			CNFE.printStackTrace();	
			return null;
		}

		try{
			Connection con=DriverManager.getConnection(dbUrl,userName,userPW);
			Statement stmt=con.createStatement();
			return con;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}					
	}
}
