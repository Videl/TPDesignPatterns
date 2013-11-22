package eu.telecomnancy.sensor;

import java.util.Observable;
import java.util.Random;

public class TemperatureSensor extends Observable implements ISensor {
    private boolean state;
    private double value = 0;


    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public boolean getStatus() {
        return state;
    }

    @Override
    public void update() throws SensorNotActivatedException {
        if (state)
            value = (new Random()).nextDouble() * 100;
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");

        setChanged();
        notifyObservers();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }


}
