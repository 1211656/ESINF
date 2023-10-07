package fileIO;

import domain.Country;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadSalesTest implements Files{


    Map<Country, Double> map ;
    ReadSales readSales = new ReadSales();




    @Test
    void getEvolutionNumberVehicles() {
        map = readSales.getEvolutionNumberVehicles(2019,2020);
        for (Map.Entry<Country,Double> entry : map.entrySet()){
            assertEquals(entry.getKey().toString(),"Australia");
            assertEquals(entry.getValue(),-0.25);
        }

    }

    @Test
    void getEvolutionNumberVehiclesNoYearsFound(){
        map = readSales.getEvolutionNumberVehicles(0,0);
        boolean expected = true;
        assertEquals(expected,map.isEmpty());


    }


    @Test
    void getMapOfCountries() {
    }

    @Test
    void searchIfBothYearsAreInMap() {
    }

    @Test
    void getMapByYearsAndCountry() {
    }

    @Test
    void objectAllocation() {
    }
}