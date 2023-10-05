package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GpsTest {

    @Test
    void getDistanceBetweenTwoChargers() {
        Gps gps1 = new Gps(1515,1515);
        Gps gps2 = new Gps(1212,1313);
        Gps gps3 = new Gps(1414,1414);

        double expected = 6242;
        assertEquals(expected,gps1.getDistanceBetweenTwoChargers(gps2));

    }
}