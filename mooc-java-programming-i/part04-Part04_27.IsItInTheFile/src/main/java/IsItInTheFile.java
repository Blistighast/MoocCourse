
import java.nio.file.Paths;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();
        
        try (Scanner fileSearch = new Scanner(Paths.get(file))) {
            boolean found = false;
            
            while (fileSearch.hasNextLine()) {
                String name = fileSearch.nextLine();
                
                if (name.contains(searchedFor)) {
                    System.out.println("Found!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                
                System.out.println("Not found.");
            }
            
        } catch (Exception e) {
//            System.out.println(e);
            System.out.println("Reading the file " + file + " failed.");
        }

    }
}
