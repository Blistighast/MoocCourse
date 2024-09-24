
package application;

import javafx.event.EventType;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TopMenu {
    private VBox topMenu;
    private double monthSavings;
    private double interestRate;

    public TopMenu(double savings, double interestRate) {
        this.topMenu = new VBox();
        this.monthSavings = savings;
        this.interestRate = interestRate;
        BorderPane monthlySavingsPane = new BorderPane();
        BorderPane interestRatePane = new BorderPane();
        
        Slider savingsSlider = new Slider(25, 250, 1);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.snapToTicksProperty();
        Slider interestSlider = new Slider(0, 10, .01);
        
        Label monthSavingsValue = new Label(Double.toString(monthSavings));
        Label interestRateValue = new Label(Double.toString(interestRate));
        
        monthlySavingsPane.setLeft(new Label("Monthly savings"));
        monthlySavingsPane.setCenter(savingsSlider);
        monthlySavingsPane.setRight(monthSavingsValue);
        
        interestRatePane.setLeft(new Label("Yearly interest rate"));
        interestRatePane.setCenter(interestSlider);
        interestRatePane.setRight(interestRateValue);
        
        topMenu.getChildren().addAll(monthlySavingsPane, interestRatePane);
        
        savingsSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double val = newVal.doubleValue();
            setMonthSavings(val);
            monthSavingsValue.setText(Double.toString(monthSavings));
        });
        
        interestSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double val = newVal.doubleValue();
            setInterestRate(val);
            interestRateValue.setText(Double.toString(interestRate));
        });
        
    }

    public VBox getTopMenu() {
        return topMenu;
    }

    public double getMonthSavings() {
        return monthSavings;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setMonthSavings(double monthSavings) {
        this.monthSavings = monthSavings;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    


    
    
}
