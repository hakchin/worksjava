package javaBean;

public class writeBean extends Element{
	private String insertQuery;

	public String TO_DB(String str)
	{
	  try{
   			if(str==null)
   			{
   				return null;
   			}
   			return new String(str.getBytes("8859_1"),"KSC5601");
   	  }catch(Exception e){
   	  		return "error";
   	  }
	}
		

	public String getInsert(){
		if(getHomepage().equals("http://")){		
			insertQuery="INSERT INTO visit_board(no,visitor,email,homepage,regist_date,contents)"+
						" values( seq_visit_board.nextval ,'"+TO_DB(getVisitor())+"','"+getEmail()+"','"+" "+"',sysdate,'"+TO_DB(getContents())+"')";
		return insertQuery;
		}else{
			insertQuery="INSERT INTO visit_board(no,visitor,email,homepage,regist_date,contents) "+
						" values( seq_visit_board.nextval ,'"+TO_DB(getVisitor())+"','"+getEmail()+"','"+getHomepage()+"',sysdate,'"+TO_DB(getContents())+"')";
		return insertQuery;
		}
	}	
}