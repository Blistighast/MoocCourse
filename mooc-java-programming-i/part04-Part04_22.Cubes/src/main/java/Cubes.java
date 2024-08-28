
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        while (true) {
            String string = scanner.nextLine();
            
            if (string.contains("end")) {
                break;
            }
            
            int num = Integer.valueOf(string);
            int cubed = num * num * num;
            System.out.println(cubed);
        }
    }
}
