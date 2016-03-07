package javaBean;

import java.sql.*;
import java.util.Vector;

public class listBean {
	private static Connection con=null;
	private Statement stmt=null;
	private ResultSet rset=null;
	private Vector v_no;
	private Vector v_visitor;
	private Vector v_email;
	private Vector v_homepage;
	private Vector v_regist_date;
	private Vector v_contents;
	private String listQuery;
	private int istart;
	private int iend;
	private int current;
	private String current_pg;
	private int itotal;	//			<==��ü �Խ� �ۼ�
	private int iremain; //		<==viewing�� ������ ���� �Խñۼ�
	private int iviewing=10; //	<==�ѹ��� �����ְ� ���� ���� ����
	private int ivalue; //			<==��ü ��������-1

	public listBean() {
		v_no = new Vector();
		v_visitor = new Vector();
		v_email= new Vector();
		v_homepage = new Vector();
		v_regist_date = new Vector();
		v_contents= new Vector();
	}

/*================����Ʈ����===================*/

	public String listQuery(){
		listQuery=" select no,visitor, email,nvl(homepage,'&nbsp;'),"+
				  " regist_date,contents "+
				  " from visit_board order by no desc";
		return listQuery;
	}

/*===============Vector�� Ŀ�ؼ��� ������ ���� �Ҵ��Ѵ�.================*/
	public void setConnection(Connection c) {
   			 this.con = c;
	}

	public String list(String Query) {
		if (con==null){
				return "<li>DB�� ������ ���� �ʾҽ��ϴ�.";
		}
		if (!v_no.isEmpty()){	
			v_no.clear();
			v_visitor.clear();
			v_email.clear();
			v_homepage.clear();
			v_regist_date.clear();
			v_contents.clear();
		}
		try {	
			stmt = con.createStatement();
			rset = stmt.executeQuery(Query);
			while(rset.next()){
				v_no.addElement(rset.getString(1));
				v_visitor.addElement(rset.getString(2));
				v_email.addElement(rset.getString(3));
				
				v_homepage.addElement(rset.getString(4));
				
				v_regist_date.addElement(rset.getString(5));
				v_contents.addElement(rset.getString(6));
			}
				rset.close();
				stmt.close();
				con.close();
			return "<li>Query_List success!!  ^.^";
		} catch(SQLException e) {
			return "<li>SQLException : "+e.getMessage();
		}
	}
/*=============== ������ ����Ʈ�� ����===========*/
	public void scopeList(){
		if(current_pg!=null){
			current=Integer.parseInt(current_pg);
		}else{
			current=0;
		}	
		itotal=v_no.size(); //				<==�˻��� ���� ũ�⸦ �����ͼ� �� �ۼ��� �������ش�.
		ivalue=itotal/iviewing ;
		iremain=itotal%iviewing;
		if(itotal==0){
		istart		=0;
		iend		=0;
	        }else if(iremain==0){
			istart		=		(current)*iviewing;
			iend		=		istart+iviewing;
		}else if(itotal<iviewing){
			istart		=		0;
			iend		=		iremain;
		}else if(itotal>=iviewing && current<ivalue){
			istart		=		current*iviewing;
			iend		=		istart+iviewing;
		}else if(current==ivalue){
			istart		=		ivalue*iviewing;
			iend		=		istart+iremain;
		}
	}

	public void setCurrent(int current){		this.current=current;		}
	public void setIstart(int istart){		this.istart=istart;		}
	public void setIend(int iend){		this.iend=iend;		}
	public void setIremail(int iremain){		this.iremain=iremain;		}
	public void setIvalue(int ivalue){		this.ivalue=ivalue;		}
	public void setCurrent_pg(String current_pg){		this.current_pg=current_pg;		}
	public void setItotal(int itotal){		this.itotal=itotal;		}
	public void setNo(Vector v){		v_no=v;	}
	public void setVisitor(Vector v){		v_visitor = v;	}
	public void setEmail(Vector v){		v_email = v;	}
	public void setHomepage(Vector v){		v_homepage = v;	}
	public void setRegist_date(Vector v){		v_regist_date = v;	}
	public void setContents(Vector v){		v_contents = v;	}

	public int getCurrent(){		return current;		}
	public int getIstart(){		return istart;		}
	public int getIend(){		return iend;		}		
	public int getIremain(){		return iremain;		}
	public int getIvalue(){		return ivalue;		}
	public String getCurrent_pg(){		return current_pg;		}
	public int getItotal(){		return itotal;		}
	
	public Vector getNo(){		return v_no;	}
	public Vector getVisitor(){		return v_visitor;   	}
	public Vector getEmail(){		return v_email;	}
	public Vector getHomepage(){		return v_homepage;	}
	public Vector getRegist_date(){		return v_regist_date;	}
	public Vector getContents(){		return v_contents;	}
	
	
}