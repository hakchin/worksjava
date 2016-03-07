package game;
import java.util.Vector;
import java.util.Iterator;
import java.util.Random;

public class Gamer {
    private int money;                          // ¼ÒÀ¯µ·
    private Vector fruits = new Vector();       // °úÀÏ
    private Random random = new Random();       // ³­¼ö ¹ß»ı±â
    private static String[] fruitsname = {      // °úÀÏ ÀÌ¸§ÀÇ Ç¥É½
        "»ç°ú", "Æ÷µµ", "¹Ù³ª³ª", "±Ö",
    };
    public Gamer(int money) {                   // »ı¼ºÀÚ
        this.money = money;
    }
    public int getMoney() {                     // ÇöÀçÀÇ µ·À» ¾ò´Â´Ù.
        return money;
    }
    public void bet() {                         // Á³´Ù...°ÔÀÓÀÇ ÁøÇà
        int dice = random.nextInt(6) + 1;           // ÁÖ»çÀ§¸¦ ´øÁø´Ù.
        if (dice == 1) {                            // 1ÀÌ ³ª¿Â´Ù...µ·ÀÌ Áõ°¡ÇÑ´Ù.
            money += 100;
            System.out.println("µ·ÀÌ Áõ°¡Çß½À´Ï´Ù.");
        } else if (dice == 2) {                     // 2°¡ ³ª¿Â´Ù...µ·ÀÌ ¹İÀ¸·Î ÁØ´Ù.
            money /= 2;
            System.out.println("µ·ÀÌ ¹İÀ¸·Î ÁÙ¾ú½À´Ï´Ù.");
        } else if (dice == 6) {                     // 6ÀÌ ³ª¿Â´Ù...°úÀÏÀ» ¹Ş´Â´Ù.
            String f = getFruit();
            System.out.println("°úÀÏ" + f + "À» ¹Ş¾Ò½À´Ï´Ù.");
            fruits.add(f);
        } else {                                    // ±×¹Û¿¡ ...¾Æ¹«ÀÏµµ ÀÏ¾î³ªÁö ¾Ê´Â´Ù.
            System.out.println("¾Æ¹«ÀÏµµ ÀÏ¾î³ªÁö ¾Ê¾Ò½À´Ï´Ù.");
        }
    }
    public Memento createMemento() {                // ½º³À¼¦À» Âï´Â´Ù.
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String)it.next();
            if (f.startsWith("¸ÀÀÖ´Ù.")) {         // °úÀÏÀº ¸ÀÀÖ´Â °Í¸¸ º¸Á¸
                m.addFruit(f);
            }
        }
        return m;
    }
    public void restoreMemento(Memento memento) {       // undo¸¦ ½ÇÇàÇÑ´Ù.
        this.money = memento.money;
        this.fruits = memento.fruits;
    }
    public String toString() {                      // ¹®ÀÚ¿­
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
    private String getFruit() {                     // °úÀÏÀ» 1°³ ¾ò´Â´Ù.
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "¸ÀÀÖ´Ù.";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
