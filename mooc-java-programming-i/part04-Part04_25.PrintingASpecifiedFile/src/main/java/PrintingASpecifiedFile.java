
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which file should have its contents printed?");
        String search = scanner.nextLine();
        
        try (Scanner fileSearch = new Scanner(Paths.get(search))) {
            
            while (fileSearch.hasNextLine()) {
                String row = fileSearch.nextLine();
                
                System.out.println(row);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
