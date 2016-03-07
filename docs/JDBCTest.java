import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCTest {
	public static void main(String[] args){
		// Oracle Connection�� ���� ����
		String oId = "hr"; // Oracle ����
        String oPwd = "hr"; // Oracle ��й�ȣ
        String oSql = "select salary from EMPLOYEES where employee_id = ?"; // Oracle�� ���� SQL
        String oUrl = "jdbc:oracle:thin:@192.168.239.128:1521:orcl"; // Oracle ���� URL
        String oClassName = "oracle.jdbc.driver.OracleDriver"; // Oracle Classname       
        int oResult = 0; // Oracle ���� �޾� �� ��
        int gResult = 0; // Greenplum���� �޾ƿ� ��
        // Greenplum Connection�� ���� ����
        String gId = "udba"; // Greenplum ���� ����
        String gPwd = "1111"; // Greenplum ��й�ȣ
        String gSql = "select count(*) from orders where o_totalprice > ?"; // Greenplum�� ���� SQL
        String gUrl = "jdbc:postgresql://192.168.200.250:5432/edu"; // Greenplum ���� URL
        String gClassName = "org.postgresql.Driver"; // Greenplum Classname

        // Oracle Connection
        Connection oConn = null;
        PreparedStatement oPstmt = null;
        // Greenplum Connection 
        Connection gConn = null;
        PreparedStatement gPstmt = null;
        
        ResultSet rs = null;
        
        
        
        try {
        	Class.forName(oClassName);

            oConn = DriverManager.getConnection(oUrl,oId,oPwd); // ����Ŭ Driver ����
            oPstmt = oConn.prepareStatement(oSql); // ����Ŭ 
            oPstmt.setInt(1, 198);
            rs = oPstmt.executeQuery();
            if(rs.next()){
            	//System.out.println(rs.getString(1));
            	oResult = rs.getInt(1);
            }
            if(oResult != 0){ // Oracle���� ���� �޾ƿ��� ���
            	rs.close();
            	Class.forName(gClassName);
            	gConn = DriverManager.getConnection(gUrl,gId,gPwd);
            	gPstmt = gConn.prepareStatement(gSql);
            	gPstmt.setInt(1, oResult); // Oracle���� �޾� �� ���� ���� ������
            	rs = gPstmt.executeQuery();
            	if(rs.next()){
            		gResult = rs.getInt(1);
            	}            	
            }
            System.out.println("198�� ����� �޿� : " +  oResult);
            System.out.println("198�� ����� �޿� ���� ��� �ֹ��ݾ��� count : " +  gResult);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
    } finally{
            if(rs!=null)try{rs.close();}catch(Exception e){}
            if(oPstmt!=null)try{oPstmt.close();}catch(Exception e){}
            if(oConn!=null)try{oConn.close();}catch(Exception e){}
            if(gPstmt!=null)try{gPstmt.close();}catch(Exception e){}
            if(gConn!=null)try{gConn.close();}catch(Exception e){}
    }
	}
}
