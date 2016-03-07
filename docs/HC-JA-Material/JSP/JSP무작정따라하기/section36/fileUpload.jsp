<%!
public class fileUpload{

	final static int INIT_VECTOR_CAPACITY = 3; // Vector 초기 용량

	String desDirectory 	= "./";		// 파일이 저장될 디렉토리(디폴트는 ./)
	String deliminator 	= null;
	Hashtable paramList	= new Hashtable(INIT_VECTOR_CAPACITY);

	public void readForm(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	// Request 객체와 upload된 파일을 form에서의 이름을 읽어온다.

		DataInputStream in 	= new DataInputStream(req.getInputStream());
		String str=null,str_pre=null;
		String paramName = null;
		String paramValue = null;
		String br="\n";
		int nS=0,nE=0;
		String filename = "aa.txt";

		// 1. 각 Parameter를 구분할 deliminator를 읽어들인다.
		deliminator = in.readLine();
		// 2. 모든 Parameter를 읽어서 paramList vector에 저장한다.
		while( (str=in.readLine())!=null){
			// 각 Parameter를 찾기 위해서 Deliminator를 찾는다.
			if(str.indexOf("Content-Disposition")==0){
				// form의 이름을 읽어온다.
				nS = str.indexOf("name=");
				nE = str.indexOf("\"",nS+6);
				paramName = str.substring(nS+6,nE);
				// Deliminator 부분에 filename= 이라는 부분이 있으면, 이 form 객체를
				// file로 인식해서, 지정 디렉토리에 filename이란 이름의 파일로 저장한다.
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
						// Deliminator가 나올 때까지 읽는다.
						if(str.indexOf(deliminator)==0 ) break;
						paramValue=paramValue+br+str;
					}// while
					paramList.put(paramName,paramValue);

				
				}else{
					// file이 아닌 일반 form인 경우
					str=in.readLine();			// Skip Line
					paramValue="";

					while( (str=in.readLine()) !=null ){
						// Deliminator가 나올 때까지 읽는다.
						if(str.indexOf(deliminator)==0 ) break;
						paramValue=paramValue+str;
					}// while

					// paramList에 paramName과 paramValue를 저장한다.
					paramList.put(paramName,paramValue);
				}// if
			}// if
		}// while
	}// class readForm

	public String getParameter(String name){
	
		// request 객체가 세팅되어 있지 않으면 null을 리턴한다.
		String str = (String)paramList.get(name);
		if(str == null) return "";	// paramList에 없는 값이면 아무 것도 리턴하지 않는다.
		return str;
	}// class getParameter



	protected void writeToFile(DataInputStream in,String filename){
		byte ch=0;
		byte[] buffer = new byte[1024];
		byte[] pre_buffer = new byte[1024];
		int x=0,delpos=0;
		int pre_x=0;
		boolean flag=true;

		if(deliminator == null) return; // deliminator가 비어 있는지 여부를 체크

		try{
			FileOutputStream outFile = new FileOutputStream(filename);
			System.out.println("filename2:"+filename);
			while(flag){
				ch=in.readByte();
				buffer[x++] = ch;
				if(ch =='\n' || x==1023){
					String strTmp = new String(buffer,0,x);
					if( (delpos=strTmp.indexOf(deliminator))!=-1){
						outFile.write(pre_buffer,0,pre_x-2); // CR/LF를 제거하기 위해 -2한다.
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
