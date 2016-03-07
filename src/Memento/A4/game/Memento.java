package game;
import java.io.*;
import java.util.Vector;

public class Memento implements Serializable {  
    int money;                              // 소유한 돈
    Vector fruits;                          // 과일
    public int getMoney() {                 // 소유한 돈을 얻는다.(narrow interface)
        return money;
    }
    Memento(int money) {                    // 생성자(wide interface)
        this.money = money;
        this.fruits = new Vector();
    }
    void addFruit(String fruit) {           // 과일을 추가한다.(wide interface)
        fruits.add(fruit);
    }
}
