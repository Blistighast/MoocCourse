package FlightControl;

import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.ui.TextUI;


public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        
        Scanner scan = new Scanner(System.in);
        FlightControl control = new FlightControl();
        
        TextUI ui = new TextUI(control, scan);
        
        ui.start();
    }
}
