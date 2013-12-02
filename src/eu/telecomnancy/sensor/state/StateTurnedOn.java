package eu.telecomnancy.sensor.state;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 11/22/13
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class StateTurnedOn implements IState {
    private ISensor sensor;

    public StateTurnedOn(ISensor mother)
    {
        writeName();
        this.sensor = mother;
    }

    public void writeName() {
        System.out.println("Etat allumé");
    }

    public boolean getState() {
        return true;
    }

    public double update() throws SensorNotActivatedException {
        return ((new Random()).nextDouble() * 100);
    }
}
