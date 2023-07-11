package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17; //TODO Respecter les conventions de nomage
    private final double HighPressureThreshold = 21;

    protected Sensor sensor = new Sensor();

    protected boolean alarmOn = false;

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue(); //TODO Java 16 permet d'utiliser le mot clé var

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true; //TODO Voir pour factoriser ce bloc
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
