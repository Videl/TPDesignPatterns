package eu.telecomnancy.sensor.decorator;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import java.util.Observable;
import java.util.Observer;

/**
 * Date: 12/3/13
 * Time: 9:09 AM
 * Copyleft: enjoy!
 */
public abstract class IDecorator extends Observable implements ISensor, Observer {
    protected ISensor decorated;

    public IDecorator(ISensor sensor)
    {
        this.decorated = sensor;
        ((Observable) decorated).addObserver(this);
    }

    protected abstract double operation(double value);


    @Override
    public void on() {
        decorated.on();
    }

    @Override
    public void off() {
        decorated.off();
    }

    @Override
    public boolean getStatus() {
        return decorated.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        decorated.update();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        return operation(decorated.getValue());
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
