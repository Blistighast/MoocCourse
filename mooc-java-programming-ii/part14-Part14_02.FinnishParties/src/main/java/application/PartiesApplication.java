package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage window) {
        //get data
        Map<String, Map<Integer, Double>> values = readFile();

        //create chart
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        //add data
        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });

        //display chart
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    public Map<String, Map<Integer, Double>> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        Map<String, Map<Integer, Double>> values = new HashMap<>();

        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        String[] years = lines.get(0).split("\t");
        lines.remove(0);

        for (String line : lines) {
            Map<Integer, Double> partyData = new HashMap<>();
            String[] parts = line.split("\t");
            for (int i = 1; i < years.length; i++) {
                if (parts[i].equals("-")) {
                    continue;
                }

                partyData.put(Integer.valueOf(years[i]), Double.valueOf(parts[i]));
            }

            values.put(parts[0], partyData);
        }

        return values;
    }

}
