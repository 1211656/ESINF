package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {



    // testa se dois objetos com atributos diferentes são iguais
    @Test
    void testEqualsDifferentAttributes() {
        
        City city1 = new City("Porto");
        City city2 = new City("Lisboa");

        boolean expected = false;
        assertEquals(expected,city1.equals(city2));
    }

    // vê se dois objetos com atributos iguais são iguais
    @Test
    void testEqualsSameAttributes(){
        City city = new City("");
        City city1 = new City("");
        boolean expected = true;
        assertEquals(expected,city1.equals(city));
    }



}