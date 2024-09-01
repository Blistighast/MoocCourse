
import java.util.Scanner;


public class TextUI {
    private Scanner scan;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scan, SimpleDictionary dictionary) {
        this.scan = scan;
        this.dictionary = dictionary;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command: ");
            String command = scan.nextLine();
            
            if (command.equals("end")) {
                break;
            }
            
            if (command.equals("add")) {
                add();
            }
            
            if (command.equals("search")) {
                System.out.println(search());
            }
            
            System.out.println("Unknown command");
            
        }
        System.out.println("Bye bye!");
    }
    
    private void add() {
        System.out.println("Word: ");
        String word = scan.nextLine();
        System.out.println("Translation: ");
        String translation = scan.nextLine();
        
        dictionary.add(word, translation);
    }
    
    private String search() {
        System.out.println("To be translated: ");
        String word = scan.nextLine();
        String searchResult = dictionary.translate(word) == null ? 
                "Word " +word+ " was not found" :
                "Translation: " +dictionary.translate(word);

        return searchResult;
    }
}
