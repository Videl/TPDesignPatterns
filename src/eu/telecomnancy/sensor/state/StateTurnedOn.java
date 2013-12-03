package eu.telecomnancy.sensor.state;

import eu.telecomnancy.sensor.SensorNotActivatedException;

import java.util.Random;

/**
 * User: videl
 * Date: 11/22/13
 * Time: 9:31 AM
 */
public class StateTurnedOn implements IState {
    private ISensorState sensor;

    public StateTurnedOn(ISensorState mother)
    {
        this.sensor = mother;
    }

    @Override
    public void on() {
        // nothing to do
    }

    @Override
    public void off() {
        sensor.setState(new StateTurnedOff(sensor));
    }

    @Override
    public boolean getStatus() {
        return true;
    }

    public double update() throws SensorNotActivatedException {
        return ((new Random()).nextDouble() * 100);
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        return 0;
    }
}
