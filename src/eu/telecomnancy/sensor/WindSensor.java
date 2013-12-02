package eu.telecomnancy.sensor;

import eu.telecomnancy.sensor.state.IState;
import eu.telecomnancy.sensor.state.StateTurnedOff;
import eu.telecomnancy.sensor.state.StateTurnedOn;

import java.util.Observable;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 11/22/13
 * Time: 9:24 AM
 */
public class WindSensor extends Observable implements ISensor {
    private double value = 0;
    private IState currentState;

    public WindSensor()
    {
        off();
    }

    @Override
    public void on() {
        currentState = new StateTurnedOn(this);
    }

    @Override
    public void off() {
        currentState = new StateTurnedOff(this);
    }

    @Override
    public boolean getStatus() {
        return currentState.getState();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        value = currentState.update();
        setChanged();
        notifyObservers();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        return value;
    }
}
