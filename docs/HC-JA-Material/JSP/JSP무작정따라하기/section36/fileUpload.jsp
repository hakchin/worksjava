<%!
public class fileUpload{

	final static int INIT_VECTOR_CAPACITY = 3; // Vector �ʱ� �뷮

	String desDirectory 	= "./";		// ������ ����� ���丮(����Ʈ�� ./)
	String deliminator 	= null;
	Hashtable paramList	= new Hashtable(INIT_VECTOR_CAPACITY);

	public void readForm(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	// Request ��ü�� upload�� ������ form������ �̸��� �о�´�.

		DataInputStream in 	= new DataInputStream(req.getInputStream());
		String str=null,str_pre=null;
		String paramName = null;
		String paramValue = null;
		String br="\n";
		int nS=0,nE=0;
		String filename = "aa.txt";

		// 1. �� Parameter�� ������ deliminator�� �о���δ�.
		deliminator = in.readLine();
		// 2. ��� Parameter�� �о paramList vector�� �����Ѵ�.
		while( (str=in.readLine())!=null){
			// �� Parameter�� ã�� ���ؼ� Deliminator�� ã�´�.
			if(str.indexOf("Content-Disposition")==0){
				// form�� �̸��� �о�´�.
				nS = str.indexOf("name=");
				nE = str.indexOf("\"",nS+6);
				paramName = str.substring(nS+6,nE);
				// Deliminator �κп� filename= �̶�� �κ��� ������, �� form ��ü��
				// file�� �ν��ؼ�, ���� ���丮�� filename�̶� �̸��� ���Ϸ� �����Ѵ�.
				if(str.indexOf("filename=")!=-1){
					nS = str.indexOf("filename=");
					nE = str.indexOf("\"",nS+10);
					paramValue = str.substring(nS+10,nE);
					nS = paramValue.lastIndexOf("\\");
					if(nS == -1) nS = paramValue.lastIndexOf("/");
					nS++;
					paramValue = paramValue.substring(nS,paramValue.length());
					filename=paramValue;
					paramList.put(paramName,paramValue);
					str=in.readLine();		// Content-Type Header Skip
					if(str.indexOf("Content-Type")==0){
						str=in.readLine(); // Skip Empty Line
					}
					if(filename!=""){
						filename=new String(filename.getBytes("8859_1"),"KSC5601");
						filename="../webapps/examples/jsp/section36/down/"+filename;
						writeToFile(in,filename);	// writeToFile
					}
				}else if(str.indexOf("contents")!=-1){
				
					str=in.readLine();			// Skip Line
					paramValue="";

					while( (str=in.readLine()) !=null ){
						// Deliminator�� ���� ������ �д´�.
						if(str.indexOf(deliminator)==0 ) break;
						paramValue=paramValue+br+str;
					}// while
					paramList.put(paramName,paramValue);

				
				}else{
					// file�� �ƴ� �Ϲ� form�� ���
					str=in.readLine();			// Skip Line
					paramValue="";

					while( (str=in.readLine()) !=null ){
						// Deliminator�� ���� ������ �д´�.
						if(str.indexOf(deliminator)==0 ) break;
						paramValue=paramValue+str;
					}// while

					// paramList�� paramName�� paramValue�� �����Ѵ�.
					paramList.put(paramName,paramValue);
				}// if
			}// if
		}// while
	}// class readForm

	public String getParameter(String name){
	
		// request ��ü�� ���õǾ� ���� ������ null�� �����Ѵ�.
		String str = (String)paramList.get(name);
		if(str == null) return "";	// paramList�� ���� ���̸� �ƹ� �͵� �������� �ʴ´�.
		return str;
	}// class getParameter



	protected void writeToFile(DataInputStream in,String filename){
		byte ch=0;
		byte[] buffer = new byte[1024];
		byte[] pre_buffer = new byte[1024];
		int x=0,delpos=0;
		int pre_x=0;
		boolean flag=true;

		if(deliminator == null) return; // deliminator�� ��� �ִ��� ���θ� üũ

		try{
			FileOutputStream outFile = new FileOutputStream(filename);
			System.out.println("filename2:"+filename);
			while(flag){
				ch=in.readByte();
				buffer[x++] = ch;
				if(ch =='\n' || x==1023){
					String strTmp = new String(buffer,0,x);
					if( (delpos=strTmp.indexOf(deliminator))!=-1){
						outFile.write(pre_buffer,0,pre_x-2); // CR/LF�� �����ϱ� ���� -2�Ѵ�.
						flag=false;
					}else{
						outFile.write(pre_buffer,0,pre_x);
					}
					System.arraycopy(buffer,0,pre_buffer,0,x);
					pre_x = x;

					x=0;
				}
			}// while
		}catch(EOFException eof){
		}catch(IOException e){
			System.out.println("ERROR : FILE UPLOAD FAILED (class fileUpload :: writeToFile");
			System.out.println(e);
		}// try

	}// writeToFile
}
%>
