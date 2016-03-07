import game.Memento;
import game.Gamer;
import java.io.*;

public class Main {
    public static final String SAVEFILENAME = "game.dat";       
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // 처음의 돈은 100
        Memento memento = loadMemento();            // 파일로부터 로드
        if (memento != null) {
            System.out.println("지난번에 보존한 결과로부터 출발합니다.");
            gamer.restoreMemento(memento);
        } else {
            System.out.println("새로 출발합니다.");
            memento = gamer.createMemento();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);        // 횟수표시
            System.out.println("현 상태:" + gamer);    // 현재의 주인공의 상태 표시

            gamer.bet();    // 게임을 진행한다.

            System.out.println("돈은" + gamer.getMoney() + "원이 되었습니다.");

            // Memento 취급의 결정
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("   (많이 늘었으니까 현재의 상태를 보존해 두자)");
                memento = gamer.createMemento();
                saveMemento(memento);   // 파일에 보존
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (많이 줄었기 때문에 이전의 상태로 복귀하자)");
                gamer.restoreMemento(memento);
            }

            // 시간을 기다림
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
