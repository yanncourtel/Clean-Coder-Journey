package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AlarmTest {

    @Test
    public void foo() { //TODO Renomer le test pour respecter la convention GIVEN WHEN THEN
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }
}
