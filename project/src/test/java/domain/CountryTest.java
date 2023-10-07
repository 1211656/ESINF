package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {


    @Test
    void testEqualsDifferentAttributes() {
        Country country1 = new Country("Porto");
        Country country2 = new Country("Lisboa");

        boolean expected = false;
        assertEquals(expected,country1.equals(country2));
    }

    @Test
    void testEquals() {
        Country country = new Country("");
        Country country1 = new Country("");
        boolean expected = true;
        assertEquals(expected,country1.equals(country));

    }
}