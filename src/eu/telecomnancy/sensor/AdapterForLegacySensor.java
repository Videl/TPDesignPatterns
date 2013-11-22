package eu.telecomnancy.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: videl
 * Date: 11/22/13
 * Time: 8:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class AdapterForLegacySensor implements ISensor {
    private LegacyTemperatureSensor sensor;

    public AdapterForLegacySensor(LegacyTemperatureSensor sensor)
    {
        this.sensor = sensor;
    }

    @Override
    public void on() {
        if(!getStatus())
        {
            sensor.onOff();
        }
    }

    @Override
    public void off() {
        if(getStatus())
        {
            sensor.onOff();
        }
    }

    @Override
    public boolean getStatus() {
        return sensor.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        this.off();
        this.on();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        return sensor.getTemperature();
    }
}
