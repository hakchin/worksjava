public class HelloWorld {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        processing(-10);
    }

    public static void processing(int value) {
        System.out.print(value + ":");
        assert(value > 0);
        if (value < 0)
            value = 10;
        else
            value = value + 10;
        System.out.println(value);
        return;
    }
}
