package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private ISensor sensor;
    private SensorView sensorView;
    private DecoratedSensorView decoratedSensorView;

    public MainWindow(ISensor sensor) {
        this.sensor = sensor;
        this.sensorView = new SensorView(this.sensor);
        this.decoratedSensorView = new DecoratedSensorView(this.sensor);

        this.setLayout(new BorderLayout());
        this.add(this.sensorView, BorderLayout.CENTER);
        this.add(this.decoratedSensorView, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
