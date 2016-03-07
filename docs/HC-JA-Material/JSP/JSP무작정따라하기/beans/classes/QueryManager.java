package javaBean;
import java.sql.*;
import java.util.Vector;

public class QueryManager{	
	private  Connection con=null;	
	public void setConnection(Connection c) {
   			 this.con = c;
		}

	public String update(String Query) {
		if ( con == null) return "You must set Connection in advance";
		try {
			Statement stmt = con.createStatement();
			 int stmeInt =stmt.executeUpdate(Query);			
				stmt.close(); 
				con.close();
			return "<li>Update Success!";
		} catch (SQLException E) {
			return "<li>SQLException: " + E.getMessage();
		}
	}
}
