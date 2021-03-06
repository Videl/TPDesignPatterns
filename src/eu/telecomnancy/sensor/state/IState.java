package eu.telecomnancy.sensor.state;

import eu.telecomnancy.sensor.SensorNotActivatedException;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 11/22/13
 * Time: 9:27 AM
 */
public interface IState {

    public void on();
    public void off();
    public boolean getStatus();
    public double update() throws SensorNotActivatedException;
    public double getValue() throws SensorNotActivatedException;
}
