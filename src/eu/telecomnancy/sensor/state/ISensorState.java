package eu.telecomnancy.sensor.state;

import eu.telecomnancy.sensor.ISensor;

/**
 * Date: 12/3/13
 * Time: 8:43 AM
 * Copyleft: enjoy!
 */
public interface ISensorState  extends ISensor {

    /**
     * Set the state of the current sensor.
     * @param state
     */
    public void setState(IState state);
}
