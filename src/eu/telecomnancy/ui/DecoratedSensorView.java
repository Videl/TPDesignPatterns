package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.decorator.DecoratorCelsiusToFahrenheit;
import eu.telecomnancy.sensor.decorator.DecoratorRounder;
import eu.telecomnancy.sensor.decorator.IDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Date: 12/3/13
 * Time: 8:50 AM
 * Copyleft: enjoy!
 */
public class DecoratedSensorView extends JPanel implements Observer {

    private ISensor sensor;
    private IDecorator currentDecorator;
    private JCheckBox celsius, rounded;
    private JLabel value = new JLabel("N/A °C");

    public DecoratedSensorView(final ISensor sensor)
    {
        this.sensor = sensor;
        ((Observable) sensor).addObserver(this);

        celsius = new JCheckBox("Celcius");
        celsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(celsius.isSelected())
                {
                    System.out.println("Activation > Fahrenheit");

                    if(currentDecorator == null)
                    {
                        currentDecorator = new DecoratorCelsiusToFahrenheit(sensor);
                    }
                    else
                    {
                        currentDecorator = new DecoratorCelsiusToFahrenheit(currentDecorator);
                    }
                }
                else
                {
                    System.out.println("Désactivation > Celcius");
                }
            }
        });
        rounded = new JCheckBox("Rounded");
        rounded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rounded.isSelected())
                {
                    System.out.println("Activation > Round");

                    if(currentDecorator == null)
                    {
                        currentDecorator = new DecoratorRounder(sensor);
                    }
                    else
                    {
                        currentDecorator = new DecoratorRounder(currentDecorator);
                    }
                }
                else
                {
                    System.out.println("Désactivation > Round");
                }
            }
        });


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(celsius);
        buttonsPanel.add(rounded);
        buttonsPanel.add(value);

        this.add(buttonsPanel);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ISensor)
        {
            ISensor model = (ISensor) o;

            if(model.getStatus())
            {

                if(currentDecorator != null)
                {
                    System.out.println("Je demande à un DECORATOR!!");
                    try {
                        this.value.setText(""+currentDecorator.getValue());
                    } catch (SensorNotActivatedException e) {

                    }
                }
                else
                {
                    try {
                        this.value.setText(""+(model.getValue()));
                    } catch (SensorNotActivatedException e) {
                    }
                }
            }
            else
            {
                this.value.setText("Sensor turned off.");
            }
        }
    }

    public DecoratedSensorView getInstance()
    {
        return this;
    }
}
