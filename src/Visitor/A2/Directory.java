import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
    private String name;                    // 디렉토리의 이름
    private Vector dir = new Vector();      // 디렉토리 엔트리의 집합
    public Directory(String name) {         // 생성자
        this.name = name;
    }
    public String getName() {               // 이름을 얻는다.
        return name;
    }
    public int getSize() {                  // 사이즈를 얻는다.
        SizeVisitor v = new SizeVisitor();  
        accept(v);                          
        return v.getSize();                 
    }
    public Entry add(Entry entry) {         // 엔트리의 추가
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {
        return dir.iterator();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
