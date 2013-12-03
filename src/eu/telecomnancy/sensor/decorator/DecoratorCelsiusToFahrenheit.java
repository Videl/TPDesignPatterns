package eu.telecomnancy.sensor.decorator;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 12/2/13
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class DecoratorCelsiusToFahrenheit extends IDecorator {

    public DecoratorCelsiusToFahrenheit(ISensor mother) {
        super(mother);
    }

    @Override
    protected double operation(double value) {
        return value*(9/5) + 32;
    }

}
