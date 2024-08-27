
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        String string = scanner.nextLine();
        
        if (string.isEmpty()) {
            break;
        }

        String[] split = string.split(" ");
        for (String word: split) {
            System.out.println(word);
        }
            
        }

            
        
        
    }
}
