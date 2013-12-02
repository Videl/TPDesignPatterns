package eu.telecomnancy.sensor.proxy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * User: videl
 * Date: 12/2/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProxySensor extends Observable implements ISensor, Observer {
    private ISensor sensor;
    public ProxySensor(ISensor sensor) {
        this.sensor = sensor;
        ((Observable)sensor).addObserver(this);
    }

    public void on() {
        System.out.println("Proxy >>> " + getDateTime() + " >>> on()");
        this.sensor.on();
    }

    public void off() {
        System.out.println("Proxy >>> " + getDateTime() + " >>> off()");
        this.sensor.off();
    }

    public boolean getStatus() {
        System.out.println("Proxy >>> " + getDateTime() + " >>> getStatus()");
        return this.sensor.getStatus();
    }

    public void update() throws SensorNotActivatedException {
        System.out.println("Proxy >>> " + getDateTime() + " >>> update()");
        sensor.update();
    }

    public double getValue() throws SensorNotActivatedException {
        System.out.println("Proxy >>> " + getDateTime() + " >>> getValue() >>> " + sensor.getValue());
        return sensor.getValue();
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
