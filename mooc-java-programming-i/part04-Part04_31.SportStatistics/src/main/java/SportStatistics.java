
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("File: ");
        String file = scanner.nextLine();
        System.out.print("Team: ");
        String team = scanner.nextLine();

        
        try (Scanner fileSearch = new Scanner(Paths.get(file))) {
            int teamGames = 0;
            int teamWins = 0;
            int teamLosses = 0;

            while (fileSearch.hasNextLine()) {
                String line = fileSearch.nextLine();
                
                String[] game = line.split(",");
                
                if (game[0].contains(team) || game[1].contains(team)) {
                    teamGames++;
                    
                    if ((game[0].contains(team) && Integer.valueOf(game[2]) > Integer.valueOf(game[3]))
                         ||  (game[1].contains(team) && Integer.valueOf(game[2]) < Integer.valueOf(game[3]))  
                            ) {
                        teamWins++;
                    }
                    
                    if ((game[0].contains(team) && Integer.valueOf(game[2]) < Integer.valueOf(game[3]))
                         ||  (game[1].contains(team) && Integer.valueOf(game[2]) > Integer.valueOf(game[3]))  
                            ) {
                        teamLosses++;
                    }
                }
                
            }
            
            System.out.println("Games: " +teamGames);
            System.out.println("Wins: " +teamWins);
            System.out.println("Losses: " +teamLosses);
            
            
        } catch (Exception e) {
//            System.out.println(e);
            System.out.println("Reading the file " + file + " failed.");
        }

    }

}
