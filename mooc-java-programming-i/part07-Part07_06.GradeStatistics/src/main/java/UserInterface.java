
import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    private Scanner scan;
    private GradeStatistics statistics;

    public UserInterface(Scanner scan, GradeStatistics statistics) {
        this.scan = scan;
        this.statistics = statistics;
    }
    
    public void start() {
        while (true) {
            System.out.println("Enter point totals, -1 stops: ");
            int line = Integer.valueOf(scan.nextLine());
            
            if (line == -1) {
                break;
            }
            
            statistics.add(line);
            
        }
        System.out.println("Point average (all): " +statistics.average());
        System.out.println("Point average (passing): " +statistics.passAverage());
        System.out.println("Pass percentage: " +statistics.passingPercentage());
        statistics.gradeDistribution();
    }
}
