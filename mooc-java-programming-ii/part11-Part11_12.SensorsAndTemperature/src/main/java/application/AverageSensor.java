package application;


import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private ArrayList<Sensor> list;
    private ArrayList<Integer> readHistory;

    public AverageSensor() {
        list = new ArrayList<>();
        readHistory = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        list.add(toAdd);
    }
    
    public boolean isOn() {
        boolean allOn = true;
        for (Sensor sensor: list) {
            if (!sensor.isOn()) allOn = false;
            break;
        }
        
        return allOn;
    }
    
    public void setOn() {
        for (Sensor sensor: list) {
            sensor.setOn();
        }
    }
    
    public void setOff() {
        for (Sensor sensor: list) {
            sensor.setOff();
        }
    }
    
    public int read() {
//        if (list.isEmpty() || !isOn()) {
//            throw new IllegalStateException();
//        }
        int sum = 0;
        for (Sensor sensor: list) {
            sum += sensor.read();
        }
        int average = sum / list.size();
        this.readHistory.add((int)average);
        return average;
    }
    
    public List<Integer> readings() {
        return readHistory;
    }
}
