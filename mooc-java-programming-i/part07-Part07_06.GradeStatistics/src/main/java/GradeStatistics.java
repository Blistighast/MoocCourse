
import java.util.ArrayList;


public class GradeStatistics {
    private ArrayList<Integer> list;

    public GradeStatistics() {
        this.list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num <= 100 && num >= 0) {
            list.add(num);
        }
    }
    
    public double average() {
        int sum = 0;
        
        for (int num: list) {
            sum += num;
        }
        
        return (1.0 * sum) / list.size();
    }
    
    public String passAverage() {
        int sum = 0;
        int passCount = 0;
        
        for (int num: list) {
            if (num >= 50){
                sum += num;
                passCount++;
            }
        }
        
        if (sum == 0) {
            return "-";
        }
        
        return Double.toString((1.0 * sum) / passCount);
    }
    
    public double passingPercentage() {
        int passCount = 0;
        
        for (int num: list) {
            if (num >= 50){
                passCount++;
            }
        }
        
        return (100.0 * passCount) / list.size();
    }
    
    public void gradeDistribution() {
        int zero = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        
        for (int num: list) {
            if (num >= 90) {
                five++;
            } else if (num >= 80) {
                four++;
            } else if (num >= 70) {
                three++;
            } else if (num >= 60) {
                two++;
            } else if (num >= 50) {
                one++;
            } else {
                zero++;
            }
        }
        
        System.out.println("Grade distribution:");
        System.out.println("5: " +("*".repeat(five)));
        System.out.println("4: " +("*".repeat(four)));
        System.out.println("3: " +("*".repeat(three)));
        System.out.println("2: " +("*".repeat(two)));
        System.out.println("1: " +("*".repeat(one)));
        System.out.println("0: " +("*".repeat(zero)));
    }
    
    
}
