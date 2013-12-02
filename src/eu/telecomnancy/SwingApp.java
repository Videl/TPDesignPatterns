package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.WindSensor;
import eu.telecomnancy.sensor.proxy.ProxySensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
        ISensor sensor = new WindSensor();
        ISensor proxiedSensor = new ProxySensor(sensor);
        new MainWindow(proxiedSensor);
    }

}
