package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GpsTest {

    @Test
    void getDistanceBetweenTwoChargers() {
        Gps gps1 = new Gps(68.40711,18.67638);
        Gps gps2 = new Gps(59.42631,15.82768);

        double expected = 1008;
        assertEquals(expected,gps1.getDistanceBetweenTwoChargers(gps2));

    }
}