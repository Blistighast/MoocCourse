
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Name of the file:");
        String file = scanner.nextLine();
        
        try (Scanner fileSearch = new Scanner(Paths.get(file))) {
            
            while (fileSearch.hasNextLine()) {
                String line = fileSearch.nextLine();
                
                String[] person = line.split(",");
                String name = person[0];
                int age = Integer.valueOf(person[1]);
                
                System.out.println(name+ ", age: " +age+ " years");
                
            }

            
        } catch (Exception e) {
//            System.out.println(e);
            System.out.println("Reading the file " + file + " failed.");
        }

    }
}
