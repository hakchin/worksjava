import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
    private String name;                    // ���丮�� �̸�
    private Vector directory = new Vector();      // ���丮 ��Ʈ���� ����
    public Directory(String name) {         // ������
        this.name = name;
    }
    public String getName() {               // �̸��� ��´�.
        return name;
    }
    public int getSize() {                  // ����� ��´�.
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {         // ��Ʈ���� �߰�
        directory.add(entry);
        return this;
    }
    protected void printList(String prefix) {       // ��Ʈ���� �϶�
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
