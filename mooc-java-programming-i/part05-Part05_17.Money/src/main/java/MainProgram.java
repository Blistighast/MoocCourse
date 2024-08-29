
public class MainProgram {

    public static void main(String[] args) {
        // test your class here
Money a = new Money(10, 0);
Money b = new Money(3, 75);

Money c = a.minus(b);
        Money d = c.minus(a); 
        System.out.println(c);
        System.out.println(d);
    }
}
