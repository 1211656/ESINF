package tasks;

import domain.City;
import domain.Country;
import org.junit.jupiter.api.Test;
import structures.StructureCityChargers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskCityChargersTest {

    StructureCityChargers structure ;


    TaskCityChargersTest() throws IOException {
        structure = new StructureCityChargers();
    }

    @Test
    void mostraCarregadorCidade() {
    }

    @Test
    void searchForCityInMap() {

        assertFalse(structure.getTask().searchForCityInMap(new Country("Portugal"), new City("Porto"), structure.getChargersCidade()));
        assertTrue(structure.getTask().searchForCityInMap(new Country("Portugal"), new City("Lisbon"), structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCityInMap(new Country("Portugal"), new City("Porto"), null));
        assertFalse(structure.getTask().searchForCityInMap(null, new City("Porto"), structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCityInMap(new Country("Portugal"), null, structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCityInMap(null, null, null));

    }

    @Test
    void searchForCountryInMap() {
        assertTrue(structure.getTask().searchForCountryInMap(new Country("Portugal"),structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCountryInMap(new Country("Switzerland"),structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCountryInMap(null,structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCountryInMap(null,null));
    }

    @Test
    void addStallsToCity() {
    }

    @Test
    void getCountryInMap() {
        String country = "Portugal";
        assertEquals(new Country(country),structure.getTask().getCountryInMap(country,structure.getChargersCidade()));
        assertNull(structure.getTask().getCountryInMap(null, structure.getChargersCidade()));
    }

    @Test
    void getCityInMap() {
        String city = "Lisbon";
        Country country = new Country("Portugal");
        assertEquals(new City("Lisbon"),structure.getTask().getCityInMap(city,country,structure.getChargersCidade()));
        assertEquals(new City("Porto"),structure.getTask().getCityInMap("Porto",country,structure.getChargersCidade()));
        assertNull(structure.getTask().getCityInMap(null,country,structure.getChargersCidade()));
    }

    @Test
    void contaCarregadorPais() {
    }

    @Test
    void mostraResultadoPorPais() {
    }
}