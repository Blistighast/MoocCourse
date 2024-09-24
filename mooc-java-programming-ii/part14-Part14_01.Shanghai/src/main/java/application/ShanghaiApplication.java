package application;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage window) {
        //format data
        String list = "2007 73\n"
                + "2008 68\n"
                + "2009 72\n"
                + "2010 72\n"
                + "2011 74\n"
                + "2012 73\n"
                + "2013 76\n"
                + "2014 73\n"
                + "2015 67\n"
                + "2016 56\n"
                + "2017 56";
        
        HashMap<Integer, Integer> data = new HashMap<>();
        
        String[] listParts = list.split("\n");
        for (String part: listParts) {
            String[] dataParts = part.split(" ");
            data.put(Integer.parseInt(dataParts[0]),Integer.parseInt(dataParts[1]));
        }
        
        //create chart
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        XYChart.Series chartData = new XYChart.Series();
        
        //add data to chart
        data.entrySet().stream().forEach(pair -> {
            chartData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
        });
        lineChart.getData().add(chartData);
        
        //display chart
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
