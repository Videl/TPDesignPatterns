package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.WindSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
        ISensor sensor = new WindSensor();
        new MainWindow(sensor);
    }

}
