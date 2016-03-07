<%@ page contentType="text/html; charset=KSC5601" %>
<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.http.* "%>
<%!
Connection DB_Connection() throws ClassNotFoundException, SQLException,Exception
{
  String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn=DriverManager.getConnection(url,"scott","tiger");
  return conn;
}
%> 
<%
Connection      conn = DB_Connection();
Statement       stmt = null;
ResultSet rs;
String sql_date=" select to_char(sysdate,'yyyymmdd'),"+
  	" to_char(sysdate,'yyyy'),to_char(sysdate, 'mm'),to_char(sysdate, 'dd') from dual ";
String system_date="";
String this_year="";
String sys_month="";
String sys_day="";
String start_year=request.getParameter("start_year");
String start_month=request.getParameter("start_month");
String start_date = start_year+start_month+"01";
String opt = request.getParameter("opt");
Vector v_no = new Vector();
Vector v_title = new Vector();
Vector v_start_date = new Vector();
Vector v_content = new Vector();
int REPEAT1=0;
String opt1="1";
String opt2="2";
String sql1 = " select count(*) from schedule "+
	  " where    rpad(start_date,6) = decode('"+opt+"','1',"+
             " rpad(to_char(add_months(to_date('"+start_date+"','yyyymmdd'),1),'yyyymmdd'),6),'2',"+
              " rpad(to_char(add_months(to_date('"+start_date+"','yyyymmdd'),-1),'yyyymmdd'),6),"+
              " rpad('"+start_date+"',6))";
String sql2 = " select no, title, start_date, content from schedule "+
  	   " where    rpad(start_date,6) = decode('"+opt+"','1',"+
              " rpad(to_char(add_months(to_date('"+start_date+"','yyyymmdd'),1),'yyyymmdd'),6),'2',"+
              " rpad(to_char(add_months(to_date('"+start_date+"','yyyymmdd'),-1),'yyyymmdd'),6),"+
              " rpad('"+start_date+"',6))";
	try{
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql_date);
		rs.next();
		system_date = rs.getString(1);
		this_year = rs.getString(2);
		sys_month = rs.getString(3);
		sys_day = rs.getString(4);
		rs = stmt.executeQuery(sql1);
		rs.next();
		REPEAT1 = rs.getInt(1);
		rs = stmt.executeQuery(sql2);
		while(rs.next()){
			v_no.addElement(Integer.toString(rs.getInt(1)));
			v_title.addElement(rs.getString(2));
			v_start_date.addElement(rs.getString(3));
			v_content.addElement(rs.getString(4));
		}
		if (opt.equals(opt1)) {
 				String sql4 ="select to_char(add_months(to_date('"+start_date+"',"+
 	  				 " 'yyyymmdd'),1),'yyyymmdd') "+
 	  				 " from dual ";
 					rs = stmt.executeQuery(sql4);
                    if(rs.next()) start_date= rs.getString(1);
        }
        else if(opt.equals(opt2))
        {
                    String sql4 ="select to_char(add_months(to_date('"+start_date+"',"+
                                 "'yyyymmdd'),-1),'yyyymmdd') "+
                                 "from dual ";
                    rs = stmt.executeQuery(sql4);
                    if(rs.next()) start_date= rs.getString(1);
        }
		
		start_year = start_date.substring(0,4);
		start_month = start_date.substring(4,6);
		rs.close();
		stmt.close();
	}catch(SQLException e){ 
    }
   
%>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html;charset=euc-kr">
<STYLE TYPE="text/css">
 td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color
: #000000;BACKGROUND-POSITION: left top;}
BODY {font-family: "돋움", "Verdana"; font-size: 9pt}
a    { font-family: 돋움, Verdana; color: #000000; text-decoration: none}
a:hover { font-family:돋움; text-decoration:underline }
</STYLE>
<title>Calendar</title>
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
    var cdate = "<%=system_date%>"
    var cy = cdate.substring(0,4) ;
    var cm =    cdate.substring(4,6)-1;
    var cd =    cdate.substring(6,8);
    var dDate = new Date(cy,cm,cd);
    var dCurMonth = dDate.getMonth()+1;
    var dCurDayOfMonth = dDate.getDate();
    var dCurYear = dDate.getFullYear();
    var objPrevElement = new Object();
    var fw;
    var ii;
    function fToggleColorOver(myElement) {
            myElement.bgColor = "#FFFEE5";
    }
    function fToggleColorOut(myElement) {
        if(myElement.id == "calCell") myElement.bgColor = "#FDF5EA";
            else if(myElement.id == "calCelltoday") myElement.bgColor = "#FDF5EA";
            else myElement.bgColor = "#FFFFFF";
    }
    function FontOver(myElement) {
            myElement.bgColor = "#F7E0C3";
    }
    function FontOut(myElement) {
            if(myElement.id == "calCell") myElement.bgColor = "#EDF4F0";
            else myElement.bgColor = "#FFFFFF";
    }
    function fToggleColor(myElement) {
        var aa = myElement.bgcolor;
        if (myElement.id == "calCell") {
            if(!isNaN(parseInt(myElement.children["calDateText"].innerText))) {
               myElement.bgColor = "#F7E0C3";
                objPrevElement.bgColor = aa;
                objPrevElement = myElement;
            }
        }
        var toggleColor ="#965F20";
        if (myElement.id == "calDateText") {
                myElement.color = toggleColor;
                objPrevElement.color = "#FFFFFF";
                objPrevElement = myElement;
        }
        else if (myElement.id == "calCell") {
            for (var i in myElement.children) {
                if (myElement.children[i].id == "calDateText") {
                    if (myElement.children[i].color == toggleColor) {
                        myElement.children[i].color = "";
                    }
                    else {
                        myElement.children[i].color = "#000000";
                    }
                }
            }
        }
    }
    function fSetSelectedDay(myElement){
        var dPrevDate = new Date(iYear, iMonth, 0);
        return dPrevDate.getDate();
    }
    function fGetDaysInMonth(iMonth, iYear) {
        var dPrevDate = new Date(iYear, iMonth, 0);
        return dPrevDate.getDate();
    }
    function fBuildCal(iYear, iMonth, iDayStyle) {
        var aMonth = new Array();
        aMonth[0] = new Array(7);
        aMonth[1] = new Array(7);
        aMonth[2] = new Array(7);
        aMonth[3] = new Array(7);
        aMonth[4] = new Array(7);
        aMonth[5] = new Array(7);
        aMonth[6] = new Array(7);
        var dCalDate = new Date(iYear, iMonth-1, 1);
        var iDayOfFirst = dCalDate.getDay();
        var iDaysInMonth = fGetDaysInMonth(iMonth, iYear);
        var iVarDate = 1;
        var i, d, w;
        if (iDayStyle == 2) {
            aMonth[0][0] = "Sunday";
            aMonth[0][1] = "Monday";
            aMonth[0][2] = "Tuesday";
            aMonth[0][3] = "Wednesday";
            aMonth[0][4] = "Thursday";
            aMonth[0][5] = "Friday";
            aMonth[0][6] = "Saturday";
        }
        else if (iDayStyle == 1) {
            aMonth[0][0] = "Sun";
            aMonth[0][1] = "Mon";
            aMonth[0][2] = "Tue";
            aMonth[0][3] = "Wed";
            aMonth[0][4] = "Thu";
            aMonth[0][5] = "Fri";
            aMonth[0][6] = "Sat";
        }
        else {
            aMonth[0][0] = "Su";
            aMonth[0][1] = "Mo";
            aMonth[0][2] = "Tu";
            aMonth[0][3] = "We";
            aMonth[0][4] = "Th";
            aMonth[0][5] = "Fr";
            aMonth[0][6] = "Sa";
        }
        for (d = iDayOfFirst; d < 7; d++) {
            aMonth[1][d] = iVarDate;
            iVarDate++;
        }
        for (w = 2; w < 7; w++) {
            for (d = 0; d < 7; d++) {
                if (iVarDate <= iDaysInMonth) {
                    aMonth[w][d] = iVarDate;
                    iVarDate++;
                }
            }
        }
        return aMonth;
   }
    function prev() {
   document.month_form.opt.value = 2;
   document.month_form.submit();
    }
    function next() {
        document.month_form.opt.value = 1;
        document.month_form.submit();
    }
    function today() {
        document.month_form.opt.value = 0;
        document.month_form.submit();
    }
    function fDrawCal(iYear, iMonth, iCellWidth, iCellHeight, sDateTextSize, sDateTextWeight, iDayStyle) {
        var myMonth;
        myMonth = fBuildCal(iYear, iMonth, iDayStyle);
        document.write("<table border='0' bordercolor=red width=680 cellpadding='0' cellspacing='0' align=center>");

        document.write("<tr bgcolor='#f5d9b7'>");
        document.write("<td colspan=7 border=0 background='cb_pt01.gif' >");
        document.write("<img src='cb_left01.gif' align='left' border='0' vspace='0' hspace='0'>");
        document.write("<img src='cb_right01.gif' align='right' border='0' vspace='0' hspace='0'>");
        document.write("<table border='0' bordercolor=red cellpadding='0' cellspacing='0' align=right>");
        document.write("<td colspan=7 border=0 align='right'><a href='javascript:prev()'><font color=#568076>지난달보기</a> &nbsp;</font><img src='cb_bl03.gif' border=0 vspace='1'></a>");
        document.write("&nbsp;&nbsp;<%= start_year%>년&nbsp;<%=start_month%>월&nbsp;&nbsp;");
        document.write("<a href='javascript:next();'><img src='cb_bl04.gif' border=0 VSPACE='1'><font color=#568076>&nbsp; 다음달보기</font></a></td>");
        document.write("<tr>");
        document.write("</table>");
        document.write("</td></tr>");
   document.write("<table width=680 border='0' bordercolor=red CELLSPACING='1' BGCOLOR='#BE9A60'>");
     document.write("<td border=0 width=100 align='center' bgcolor='#f5d9b7'>" + myMonth[0][0] + "</td>");
    document.write("<td border=0 width=100 align='center' bgcolor='#fdf5ea'>" + myMonth[0][1] + "</td>");
    document.write("<td border=0 width=100 align='center' bgcolor='#fdf5ea'>" + myMonth[0][2] + "</td>");
    document.write("<td border=0 width=100 align='center' bgcolor='#fdf5ea'>" + myMonth[0][3] + "</td>");
    document.write("<td border=0 width=100 align='center' bgcolor='#fdf5ea'>" + myMonth[0][4] + "</td>");
    document.write("<td border=0 width=100 align='center' bgcolor='#fdf5ea'>" + myMonth[0][5] + "</td>");
    document.write("<td border=0 width=100 align='center' bgcolor='#fdf5ea'>" + myMonth[0][6] + "</td>");
        var count=1;
        var view=0;
        for(w = 1; w < 2; w++)
        {
            document.write("<tr>")
            for(d = 0; d < 7; d++)
            {
                //클릭 부분만 제외
                if( d == 0 ){
                    if( count == <%=sys_day%> && <%=sys_month%> == <%=start_month%>) {
                        document.write("<td id=calCell bgcolor='#f7e0c3' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "' onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                    else {
                        
                        document.write("<td id=calCell bgcolor='#fdf5ea' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "' onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                    }
                else{
                    if( count == <%=sys_day%> && <%=sys_month%> == <%=start_month%>) {
                        document.write("<td id=calCelltoday bgcolor='#fdf5ea' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "'onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                    else {
                        
                        document.write("<td id=calCell2 bgcolor='#ffffff' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "' onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                    }
                if (!isNaN(myMonth[w][d]))
                {
                    count++;
                    document.write(myMonth[w][d]);
                    if(0<myMonth[w][d] && myMonth[w][d]<10)
                    {
                        myMonth[w][d] = "0" + myMonth[w][d];
                    }
                  var j=0;
              var aa=<%=REPEAT1%>;
              var a=new Array(aa);
              <%
              	for(int RE=0;RE<v_no.size();RE++){
              %>
                    a[j]="<%=v_start_date.elementAt(RE).toString().substring(6,8)%>";
                    j++;
                  
            <%
               }
            %>
                  var k=0;
           <%
              	for(int k=0;k<v_no.size();k++){
            %>
               
                    if(a[k]==myMonth[w][d]){
                    document.write("<a href=read_content.jsp?no=<%=v_no.elementAt(k)%>><br><img src='cb_bl01.gif' border=0 VSPACE='2'>&nbsp;<%=v_title.elementAt(k)%></a><br>");
                }
                      k++;
           <%
             }
            %>
                
                }
                else
                {
                    document.write("<font id=calDateText onMouseOver='fToggleColor(this)' style='CURSOR:Hand;FONT-FAMILY:Arial;FONT-SIZE:" + sDateTextSize + ";FONT-WEIGHT:" + sDateTextWeight + "' onMouseOut='fToggleColor(this)' onclick=fSetSelectedDay(this)> </font>");
                }
                document.write("</td>")
            }
            document.write("</tr>");
        }
        for(w = 2; w < 7; w++)
        {
            if(myMonth[w][0])
            {
                document.write("<tr>")
                for(d = 0; d < 7; d++)
                {
                    //클릭 부분만 제외
                    if( d == 0 )
                    {
                        if( count == <%=sys_day%> && <%=sys_month%> == <%=start_month%>)
                        {
                            document.write("<td id=calCell bgcolor='#F7E0C3' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "' onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                        else
                        {
                            
                            document.write("<td id=calCell bgcolor='#FDF5EA' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "' onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                    }
                    else
                    {
                        if( count == <%=sys_day%> && <%=sys_month%> == <%=start_month%>)
                        {
                            document.write("<td id=calCelltoday bgcolor='#FDF5EA' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight +"' onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                        else
                        {
                            
                           document.write("<td id=calCell2 bgcolor='#FFFFFF' align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "'onMouseOver='fToggleColorOver(this)' onMouseOut='fToggleColorOut(this)'>");
                        }
                    }
                    if (!isNaN(myMonth[w][d]))
                    {
                        count++;
                        document.write(myMonth[w][d]);
                        if(0<myMonth[w][d] && myMonth[w][d]<10)
                        {
                            myMonth[w][d] = "0" + myMonth[w][d];
                        }
                    var j=0;
                	var aa=<%=REPEAT1%>;
                	var a=new Array(aa);
               <%
               	
              		for(int RE=0;RE<v_no.size();RE++){
              
               %>
                        a[j]="<%=v_start_date.elementAt(RE).toString().substring(6,8)%>";
                        j++;
               <%
               		}
               %>
                      
                      var k=0;
                 <%
               	
              		for(int RE=0;RE<v_no.size();RE++){
              
               %>
               	
                    if(a[k]==myMonth[w][d])
                    {
                    	
                        document.write("<a href=read_content.jsp?no=<%=v_no.elementAt(RE)%>><br><img src='cb_bl01.gif' border=0 VSPACE='2'>&nbsp;<%=v_title.elementAt(RE)%></a><br>");
                        }
                        k++;
                <%
                	}
                %>
                    }
                    else
                    {
                        document.write("<font id=calDateText onMouseOver='fToggleColor(this)' style='CURSOR:Hand;FONT-FAMILY:Arial;FONT-SIZE:" + sDateTextSize +";FONT-WEIGHT:" + sDateTextWeight + "' onMouseOut='fToggleColor(this)' onclick=fSetSelectedDay(this)> </font>");
                    }
                    document.write("</td>")
                }
                document.write("</tr>");
            }
        }
        document.write("</table>");
        }
    function fUpdateCal(iYear, iMonth) {
        myMonth = fBuildCal(iYear, iMonth);
        objPrevElement.bgColor = "";
        document.all.calSelectedDate.value = "";
        for (w = 1; w < 7; w++) {
            for (d = 0; d < 7; d++) {
                if (!isNaN(myMonth[w][d])) {
                    calDateText[((7*w)+d)-7].innerText = myMonth[w][d];
                }
                else {
                    calDateText[((7*w)+d)-7].innerText = " ";
                }
            }
        }
    }
  function nodata(){
        alert("데이터가 없습니다.");
        return false;
  }
// End -->
</script>
</head>
<body leftmargin="0" topmargin="0">
<table border="0" bordercolor=red cellspacing="0" cellpadding="0" width="710">
	<tr>
		<form name="month_form" method="post" action="month.jsp"> 
		<td background="c_top01.gif" border="0" WIDTH=650 height=50 align=RIGHT VALIGN=BOTTOM VSPACE="0" HSPACE="3" style="BACKGROUND-REPEAT: no-repeat;">
    		<input name="opt" type="hidden" value="">
  			<input name="start_year" type="hidden" value="<%=start_year%>">
  			<input name="start_month" type="hidden" value="<%=start_month%>">
    </td>
    </form>
    <td vspace="0" hspace="3" valign=bottom>	
    </td>
  </tr>
</table>
<!-- 메인 테이블 -->
<table border="0" bordercolor=red cellpadding="0" cellspacing="0" width="710">
    <tr>
    <td colspan=3>
      <br>
        <table border="0" cellpadding="0" cellspacing="0" width="660" align=right>
      <tr>
        <td><img src="cb_mu03.gif" border="0" usemap="#imagemap1"></td>
        </tr>
        </table>
    </tr>
</table>
<table border="0" bordercolor=red cellpadding="0" cellspacing="0" width="740">
    <tr>
    <td>
        <table width="680" border="0" bordercolor=red cellspacing="0" cellpadding="0" align=center>
                <td align=center border=0>
                    <script language="JavaScript">
                        var dCurDate = new Date();
                        fDrawCal(<%=start_year%>, <%=start_month%>, 94, 92, "15px", "bold", 1);
                    </script>
                </td>
            </talbe>
        </td>
    </tr>
    </form>
</table>
<map name="ImageMap1">
<area shape="rect" coords="612, 0, 678, 20" href="write_form.jsp">
<!-- 주별보기 -->
<SCRIPT LANGUAGE="javascript">
<!--
    var now = new Date ();
    monthNow = now.getMonth () + 1;
  yearNow = now.getYear ();
  dateNow = now.getDate();
  yearNow = ( yearNow < 100 ) ? yearNow + 1900 : yearNow;
  fBuildCal(yearNow, monthNow);
  var dCurMonth = now.getMonth()+1;
    var dCurDayOfMonth = now.getDate();
    if(monthNow <10 ) monthNow = "0" + monthNow;
    if(dateNow <10 ) dateNow = "0" + dateNow ;
    var dCurYear = now.getFullYear();
    var objPrevElement = new Object();
    var fw;
    var ii;
    function fGetDaysInMonth(iMonth, iYear)
    {
        var dPrevDate = new Date(iYear, iMonth, 0);
        return dPrevDate.getDate();
    }
    function fBuildCal(iYear, iMonth)
    {
        var aMonth = new Array();
        aMonth[0] = new Array(7);
        aMonth[1] = new Array(7);
        aMonth[2] = new Array(7);
        aMonth[3] = new Array(7);
        aMonth[4] = new Array(7);
        aMonth[5] = new Array(7);
        aMonth[6] = new Array(7);
        var dCalDate = new Date(iYear, iMonth-1, 1);
        var iDayOfFirst = dCalDate.getDay();
        var iDaysInMonth = fGetDaysInMonth(iMonth, iYear);
        var iVarDate = 1;
        var i, d, w;
        //첫날 공백 후부터
        for (d = iDayOfFirst; d < 7; d++)
        {
            aMonth[1][d] = iVarDate;
            iVarDate++;
        }
        //첫째 주부터 일요일부터
        ii=1;
        for (w = 2; w < 7; w++) {
            for (d = 0; d < 7; d++) {
                if (iVarDate <= iDaysInMonth) {
                    if(d==0) {
                        if(iVarDate < now.getDate()) {
                            fw = iVarDate;
                            //fw = ii;
                            ii++;
                            }
                    }
                    aMonth[w][d] = iVarDate;
                    iVarDate++;
                }
            }
        }
        if(fw == null)
        {
                monthNow--;
                if(monthNow < 1)
                {
                    monthNow = 12;
                    yearNow--;
                }
                m = monthNow;
                if(m==12 || m==10 || m==8 || m==7 || m==5 || m==3 || m==1) fw=31;
                else if(m==11 || m==9 || m==6 || m==4) fw=30;
                else fw=28;
       }
    }
    document.write("<area shape='rect' coords='72, 3, 146, 22' href='trans?data=events/event_week&start_year="+yearNow+"&start_month="+monthNow+"&start_day="+fw+"'>");
//-->
</SCRIPT>
</map>
</FORM>
</body>
</html>
