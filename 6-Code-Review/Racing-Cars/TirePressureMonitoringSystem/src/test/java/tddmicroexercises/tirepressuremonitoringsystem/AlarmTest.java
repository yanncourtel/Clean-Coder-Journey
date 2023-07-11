package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AlarmTest {

    // TODO : a tester
    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
        // TODO : pas de message sur le assertFalse
    }
}
