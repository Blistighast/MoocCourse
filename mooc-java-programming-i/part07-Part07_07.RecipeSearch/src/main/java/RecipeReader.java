
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeReader {

    private String file;
    private ArrayList<Recipe> recipes;

    public RecipeReader(String file) {
        this.file = file;
        this.recipes = new ArrayList<>();
    }

    public void readFile(String file) {
        String lines = "";
        try (Scanner fileRead = new Scanner(Paths.get(file))) {
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                lines += line + ",";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }   
        createRecipes(lines);
    }
    
    public void createRecipes(String lines) {
        String[] recipesSplit = lines.split(",,");
        for (int i = 0; i < recipesSplit.length; i++) {
            String[] recipeParts = recipesSplit[i].split(",");
            String name = recipeParts[0];
            int time = Integer.valueOf(recipeParts[1]);
            ArrayList<String> ingredients = new ArrayList<>();
            
            for (int j = 2; j < recipeParts.length; j++) {
                ingredients.add(recipeParts[j]);
            }
            
            recipes.add(new Recipe(name, time, ingredients));
        }
    }

    public void listRecipes() {
        if (recipes.size() == 0) {
            readFile(file);
        }

        for (Recipe recipe: recipes) {
            System.out.println(recipe.toString());
        }
    }
    
    public void searchName(String search) {
        for (Recipe recipe: recipes) {
            if (recipe.getName().contains(search)) {
                System.out.println(recipe.toString());
            }
        }
    }
    
    public void searchCookTime(int maxCookTime) {
        for (Recipe recipe: recipes) {
            if (recipe.getCookTime() <= maxCookTime) {
                System.out.println(recipe.toString());
            }
        }
    }
    
    public void searchIngredients(String search) {
        for (Recipe recipe: recipes) {
            for (int i = 0; i < recipe.getIngredients().size(); i++) {
                if (recipe.getIngredients().get(i).equals(search)) {
                    
                    System.out.println(recipe.toString());
                    break;
                }
            }
        }
    }

}
