<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=euc-kr">
<STYLE TYPE="text/css">
  TD {font-family:"����", "Verdana";font-size:9pt}
  BODY {font-family: "����", "Verdana"; font-size: 9pt}
  a    { font-family: ����, Verdana; color: #000000; text-decoration: none}
  a:hover { font-family:����; text-decoration:underline }
</STYLE>
<SCRIPT LANGUAGE="javascript">
<!--
function Write()
{
	var check = 0;
	var area_gubun = " ";
	form = document.write_form; 
		/* �Է°��� �˻��Ѵ�. */
	if (write_form.title.value == "")
	{
		write_form.title.focus();
		alert("������ �Է��ϼ���.");
		return;
		check = 1;
	}
	if (write_form.contents.value == "")
	{
		write_form.contents.focus();
		alert("������ �Է��ϼ���.");
		return;
		check = 1;
	}
	document.write_form.submit();
}
function Today()
{
	var now = new Date ();
	monthNow = now.getMonth ()+1 ;
 	yearNow = now.getYear ();
	dateNow = now.getDate();
	
	var start_year="";
	start_year =yearNow - 2001;
	write_form.start_year.options[start_year].selected = true; 
	
	var start_month="";
	start_month = monthNow - 1;
	write_form.start_month.options[start_month].selected = true; 
	
	var start_day="";
	start_day = dateNow - 1;
	write_form.start_day.options[start_day].selected = true; 
	
}
//-->
</SCRIPT>
</head>
<body bgcolor="#ffffff" leftmargin="0" topmargin="0" onload="Today();">
<form name="write_form" method="post" action="write.jsp">
<table border=0 width="640" cellpadding="0" cellspacing="0">
	<tr>
    	<td width="620" background="c_top01.gif" height=50 border="0"
          style="BACKGROUND-REPEAT: no-repeat;">
        	<SCRIPT LANGUAGE="javascript">
<!--
  var now = new Date ();
  monthNow = now.getMonth ()+1 ;
  yearNow = now.getYear ();
  dateNow = now.getDate();
 if(monthNow <10 ) monthNow = "0" + monthNow;
   if(dateNow <10 ) dateNow = "0" + dateNow ;
	yearNow = ( yearNow < 100 ) ? yearNow + 1900 : yearNow;
   	document.write
("<a href='month.jsp?opt=0&start_year="+yearNow+"&start_month="+monthNow+"'>");
 document.write("<img src='cb_bt13.gif' name=img5 align=right vspace=3 hspace=3 border=0>");
    document.write("</a>");
  //-->
  	</SCRIPT>
     </td>
    </tr>
</table>
<table width="700" border="0" cellspacing="0" cellpadding="0">
 <tr>
  <td>
  <br>
  <table border="0" width="550" cellpadding="0" cellspacing="0" align=center>
    <tr bgcolor="#aad3c9"> 
     <td colspan=2 background="cb_pt02.gif" align="center">
     <img src="cb_left02.gif" vspace="0" hspace="0" align="left">
     <img src="cb_right02.gif" align="right" vspace="0" hspace="0">
     </td>
    </tr>
<table border="1" width="550" cellpadding="0" cellspacing="1" align="center" bgcolor="#000000">
    <td colspan=2 bgcolor="#faf4ee" align="left">
    <ul>	
    	<br>
   	<img src="cb_bl01.gif" border=0 vspace="2" hspace="0"> ��&nbsp;&nbsp;&nbsp;&nbsp; �� :
     	<input name="title" size=20 style="border:1 solid #f7d9ad">
     <br>
     	<img src="cb_bl01.gif" border=0  vspace="2" hspace="0"> ��&nbsp;&nbsp;&nbsp;&nbsp; ¥  : 
      	<select name="start_year">
		<option value=2001>2001��
		<option value=2002>2002��
		<option value=2003>2003��
		<option value=2004>2004��
		<option value=2005>2005��
		<option value=2006>2006��
		<option value=2007>2007��
		<option value=2008>2008��
		<option value=2009>2009��
		<option value=2010>2010��
		</select>&nbsp;&nbsp;
 		<select name="start_month">
 		<option value=01>1��
		<option value=02>2��
		<option value=03>3��
		<option value=04>4��
		<option value=05>5��
		<option value=06>6��
		<option value=07>7��
		<option value=08>8��
		<option value=09>9��
		<script language="javascript">
		<!--
			var i
			for(i=10;i<=12;i++){
				document.write("<option value="+i+">"+i+"��")
			}
		//-->
		</script>
		</select>&nbsp;&nbsp;
 		<select name="start_day">
 		<option value=01>1��
		<option value=02>2��
		<option value=03>3��
		<option value=04>4��
		<option value=05>5��
		<option value=06>6��
		<option value=07>7��
		<option value=08>8��
		<option value=09>9��
		<script language="javascript">
		<!--
			var i
			for(i=10;i<=31;i++){
				document.write("<option value="+i+">"+i+"��")
			}
		//-->
		</script>
		</select>
    <br>
    	
    	<img src="cb_bl01.gif" border=0  vspace="2" hspace="0"> 
    	���� : <br><textarea name="contents" rows="15" cols="45" style="border:1 solid #f7d9ad" style="width:90%"></textarea>
  	
  	</td>
   </tr>

</table>   
<table border="0" width="550" cellpadding="0" cellspacing="0" align=center>
  <tr>
   <td border=0 align=center width=5 valign=middle colspan=2 background="cb_pt03.gif" cellpadding="0" cellspacing="0">
    <img src="cb_left03.gif" align="left" vspace="0" hspace="0">
    </td>
    <td background="cb_pt03.gif" align=center valign=bottom>
  	<a href="javascript:Write();">
  	<img src="cb_bt06.gif" name=img2 vspace="0" hspace="0" border="0"></a>
      <a href="javascript:history.back()">
  	<img src="cb_bt07.gif" name=img1 vspace="0" hspace="0" border="0"></a>
    </td>
    <td width=5 ><img src="cb_right03.gif" align="right" vspace="0" hspace="0">
    </td>
	</tr>
</table>    
<input type=hidden name="start_date">
</form>
</body>
</html>
