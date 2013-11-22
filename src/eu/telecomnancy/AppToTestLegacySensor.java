package eu.telecomnancy;

import eu.telecomnancy.sensor.AdapterForLegacySensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;
import eu.telecomnancy.sensor.ISensor;


/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 11/22/13
 * Time: 8:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppToTestLegacySensor {
    public static void main(String[] args) {
        ISensor sensor = new AdapterForLegacySensor(new LegacyTemperatureSensor());
        new ConsoleUI(sensor);
    }
}
