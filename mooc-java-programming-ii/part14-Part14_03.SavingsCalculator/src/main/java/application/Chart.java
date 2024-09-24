package application;

import java.util.ArrayList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Chart {

    private LineChart<Number, Number> chart;

    public Chart(ArrayList<Double> savedPerYear,
            ArrayList<Double> savedPerYearInterest) {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        this.chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Savings Calculator");
        
        //add data to chart
        XYChart.Series yearlySavingsNoInterest = new XYChart.Series();

        for (int i = 0; i < savedPerYear.size(); i++) {
            yearlySavingsNoInterest.getData().add(new XYChart.Data(i, savedPerYear.get(i)));
        }
        chart.getData().add(yearlySavingsNoInterest);
        
        XYChart.Series yearlySavingsInterest = new XYChart.Series();

        for (int i = 0; i < savedPerYearInterest.size(); i++) {
            yearlySavingsInterest.getData().add(new XYChart.Data(i, savedPerYearInterest.get(i)));
        }
        chart.getData().add(yearlySavingsInterest);
        
        
    }

    public LineChart<Number, Number> getChart() {
        return chart;
    }

}
