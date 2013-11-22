package eu.telecomnancy.sensor.state;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 11/22/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class StateTurnedOff implements IState {

    public StateTurnedOff()
    {
        writeName();
    }

    @Override
    public void writeName() {
        System.out.println("Etat éteint");
    }

    @Override
    public boolean getState() {
        return false;
    }

    public void update() throws SensorNotActivatedException {
        throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    public double getValue() throws SensorNotActivatedException {
        throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }
}
