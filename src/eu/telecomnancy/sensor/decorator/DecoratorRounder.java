package eu.telecomnancy.sensor.decorator;

import eu.telecomnancy.sensor.ISensor;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 12/2/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class DecoratorRounder extends IDecorator {

    public DecoratorRounder(ISensor mother) {
        super(mother);
    }

    @Override
    protected double operation(double value) {
        return Math.round(value);
    }
}
