package application;

import java.util.ArrayList;

public class Logic {

    ArrayList<Double> savedPerYear;
    ArrayList<Double> savedPerYearInterest;
    private double savings;
    private double interestRate;

    public Logic(double savings, double interestRate) {
        this.savings = savings;
        this.interestRate = interestRate;
        this.savedPerYear = new ArrayList<>();
        this.savedPerYearInterest = new ArrayList<>();
        
        calcSavingsNoInterest();
        calcSavingsInterest();
    }

    public void calcSavingsNoInterest() {
        double sum = 0;
        savedPerYear.add(sum);
        for (int i = 1; i <= 30; i++) {
            savedPerYear.add(sum += (savings * 12));
        }
    }

    public void calcSavingsInterest() {
        double sum = 0;
        savedPerYearInterest.add(sum);
        for (int i = 1; i <= 30; i++) {
            savedPerYearInterest.add(sum += ((sum + (savings * 12)) * interestRate) / 100);
        }
    }
}
