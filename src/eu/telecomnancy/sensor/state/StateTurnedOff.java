package eu.telecomnancy.sensor.state;

import eu.telecomnancy.sensor.SensorNotActivatedException;

/**
 * User: videl
 * Date: 11/22/13
 * Time: 9:32 AM
 */
public class StateTurnedOff implements IState {
    private ISensorState sensor;

    public StateTurnedOff(ISensorState mother)
    {
        this.sensor = mother;
    }

    @Override
    public void on() {
        sensor.setState(new StateTurnedOn(sensor));
    }

    @Override
    public void off() {
        // nothing to do
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    public double update() throws SensorNotActivatedException {
        throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    public double getValue() throws SensorNotActivatedException {
        throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }
}
