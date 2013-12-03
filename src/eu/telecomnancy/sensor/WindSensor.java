package eu.telecomnancy.sensor;

import eu.telecomnancy.sensor.state.ISensorState;
import eu.telecomnancy.sensor.state.IState;
import eu.telecomnancy.sensor.state.StateTurnedOff;

import java.util.Observable;

/**
 * User: videl
 * Date: 11/22/13
 * Time: 9:24 AM
 */
public class WindSensor extends Observable implements ISensorState {
    private double value = 0;
    private IState currentState;

    public WindSensor()
    {
        currentState = new StateTurnedOff(this);
    }

    @Override
    public void on() {
        currentState.on();
    }

    @Override
    public void off() {
        currentState.off();
    }

    @Override
    public boolean getStatus() {
        return currentState.getStatus();
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

    public void setState(IState newState)
    {
        this.currentState = newState;

        setChanged();
        notifyObservers();
    }
}
