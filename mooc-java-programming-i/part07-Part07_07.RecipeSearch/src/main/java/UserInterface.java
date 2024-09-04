
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {
        System.out.println("File to read: ");
        String file = scan.nextLine();
        RecipeReader reader = new RecipeReader(file);
        
        reader.readFile(file);
        while (true) {

            System.out.println("Commands:");
            System.out.println("list - lists the recipes");
            System.out.println("stop - stops the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipes by cooking time");
            System.out.println("find ingredient - searches recipes by ingredient");
            System.out.println("\n");
            System.out.println("Enter command: ");
            String command = scan.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                reader.listRecipes();
            }
            
            if (command.equals("find name")) {
                System.out.println("Searched word: ");
                String search = scan.nextLine();
                System.out.println("Recipes: ");
                reader.searchName(search);
            }
            
            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                int search = Integer.valueOf(scan.nextLine());
                System.out.println("Recipes: ");
                reader.searchCookTime(search);
            }
            
            if (command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String search = scan.nextLine();
                System.out.println("Recipes: ");
                reader.searchIngredients(search);
            }
        }
    }
}
