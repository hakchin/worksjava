import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));

            Directory Kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory Kang = new Directory("Kang");
            usrdir.add(Kim);
            usrdir.add(Lee);
            usrdir.add(Kang);
            Kim.add(new File("diary.html", 100));
            Kim.add(new File("Composite.java", 200));
            Lee.add(new File("memo.tex", 300));
            Lee.add(new File("index.html", 350));
            Kang.add(new File("game.doc", 400));
            Kang.add(new File("junk.mail", 500));

            FileFindVisitor ffv = new FileFindVisitor(".html");    
            rootdir.accept(ffv);                                   

            System.out.println("HTML files are:");
            Iterator it = ffv.getFoundFiles();                     
            while (it.hasNext()) {                                 
                File file = (File)it.next();                       
                System.out.println("" + file);                     
            }                                                      
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
