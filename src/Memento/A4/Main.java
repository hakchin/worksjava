import game.Memento;
import game.Gamer;
import java.io.*;

public class Main {
    public static final String SAVEFILENAME = "game.dat";       
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // ó���� ���� 100
        Memento memento = loadMemento();            // ���Ϸκ��� �ε�
        if (memento != null) {
            System.out.println("�������� ������ ����κ��� ����մϴ�.");
            gamer.restoreMemento(memento);
        } else {
            System.out.println("���� ����մϴ�.");
            memento = gamer.createMemento();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);        // Ƚ��ǥ��
            System.out.println("�� ����:" + gamer);    // ������ ���ΰ��� ���� ǥ��

            gamer.bet();    // ������ �����Ѵ�.

            System.out.println("����" + gamer.getMoney() + "���� �Ǿ����ϴ�.");

            // Memento ����� ����
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("   (���� �þ����ϱ� ������ ���¸� ������ ����)");
                memento = gamer.createMemento();
                saveMemento(memento);   // ���Ͽ� ����
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (���� �پ��� ������ ������ ���·� ��������)");
                gamer.restoreMemento(memento);
            }

            // �ð��� ��ٸ�
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }
    public static void saveMemento(Memento memento) {   
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SAVEFILENAME));
            out.writeObject(memento);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Memento loadMemento() {               
        Memento memento = null;
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME));
            memento = (Memento)in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("" + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return memento;
    }
}