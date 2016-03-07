import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCTest {
	public static void main(String[] args){
		// Oracle Connection을 위한 설정
		String oId = "hr"; // Oracle 계정
        String oPwd = "hr"; // Oracle 비밀번호
        String oSql = "select salary from EMPLOYEES where employee_id = ?"; // Oracle에 던질 SQL
        String oUrl = "jdbc:oracle:thin:@192.168.239.128:1521:orcl"; // Oracle 접속 URL
        String oClassName = "oracle.jdbc.driver.OracleDriver"; // Oracle Classname       
        int oResult = 0; // Oracle 에서 받아 온 값
        int gResult = 0; // Greenplum에서 받아온 값
        // Greenplum Connection을 위한 설정
        String gId = "udba"; // Greenplum 접속 계정
        String gPwd = "1111"; // Greenplum 비밀번호
        String gSql = "select count(*) from orders where o_totalprice > ?"; // Greenplum에 던질 SQL
        String gUrl = "jdbc:postgresql://192.168.200.250:5432/edu"; // Greenplum 접속 URL
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

            oConn = DriverManager.getConnection(oUrl,oId,oPwd); // 오라클 Driver 연결
            oPstmt = oConn.prepareStatement(oSql); // 오라클 
            oPstmt.setInt(1, 198);
            rs = oPstmt.executeQuery();
            if(rs.next()){
            	//System.out.println(rs.getString(1));
            	oResult = rs.getInt(1);
            }
            if(oResult != 0){ // Oracle에서 값을 받아왔을 경우
            	rs.close();
            	Class.forName(gClassName);
            	gConn = DriverManager.getConnection(gUrl,gId,gPwd);
            	gPstmt = gConn.prepareStatement(gSql);
            	gPstmt.setInt(1, oResult); // Oracle에서 받아 온 값을 인자 값으로
            	rs = gPstmt.executeQuery();
            	if(rs.next()){
            		gResult = rs.getInt(1);
            	}            	
            }
            System.out.println("198번 사원의 급여 : " +  oResult);
            System.out.println("198번 사원의 급여 보다 비싼 주문금액의 count : " +  gResult);
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
