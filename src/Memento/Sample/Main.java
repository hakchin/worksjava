import game.Memento;
import game.Gamer;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // ó���� ���� 100
        Memento memento = gamer.createMemento();    // ó���� ���¸� ������ �д�.
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);        // Ƚ�� ǥ��
            System.out.println("�� ����:" + gamer);    // ������ ���ΰ��� ���� ǥ��

            gamer.bet();    // ������ �����Ų��.

            System.out.println("����" + gamer.getMoney() + "���� �Ǿ����ϴ�.");

            // Memento�� ��� ����
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    (���� ���������� ������ ���¸� �����ص���)");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (���� �پ����� ������ ���·� ��������)");
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
}
