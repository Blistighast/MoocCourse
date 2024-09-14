package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean on;

    public TemperatureSensor() {
        this.on = false;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn() {
        on = true;
    }

    public void setOff() {
        on = false;
    }

    public int read() {
        if (!on) {
            throw new IllegalStateException();
        }
        int random = new Random().nextInt(61);
        return random - 30;
    }
}
