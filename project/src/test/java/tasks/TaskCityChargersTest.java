package tasks;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;
import org.junit.jupiter.api.Test;
import structures.StructureCityChargers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        // Verifica se a cidade existe no map
        assertFalse(structure.getTask().searchForCityInMap(new Country("Portugal"), new City("Porto"), structure.getChargersCidade()));
        assertTrue(structure.getTask().searchForCityInMap(new Country("Portugal"), new City("Lisbon"), structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCityInMap(new Country("Portugal"), new City("Porto"), null));
        assertFalse(structure.getTask().searchForCityInMap(null, new City("Porto"), structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCityInMap(new Country("Portugal"), null, structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCityInMap(null, null, null));

    }

    @Test
    void searchForCountryInMap() {
        // Verifica se o país existe no map
        assertTrue(structure.getTask().searchForCountryInMap(new Country("Portugal"),structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCountryInMap(new Country("Switzerland"),structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCountryInMap(null,structure.getChargersCidade()));
        assertFalse(structure.getTask().searchForCountryInMap(null,null));
    }

    @Test
    void addStallsToCity() {
        // Adiciona carregadores a uma cidade
        Country portugal = new Country("Portugal");
        City lisbon = new City("Lisbon");
        Stalls StallsIniciais = new Stalls(5, new PowerKw(150));

        Map<Country, Map<City, Stalls>> chargersCidade = new HashMap<>();
        chargersCidade.put(portugal, new HashMap<>());
        chargersCidade.get(portugal).put(lisbon, StallsIniciais);

        structure.getTask().addStallsToCity(portugal, lisbon, new Stalls(3, new PowerKw(150)), chargersCidade);

        // Verifica se o número de carregadores foi alterado para 8
        Stalls StallsTotal = chargersCidade.get(portugal).get(lisbon);
        assertEquals(8, StallsTotal.getNumberOfStalls());

        // Adiciona carregadores a uma cidade que não existe, deve retornar false
        assertFalse(structure.getTask().addStallsToCity(portugal, new City("Porto"), new Stalls(2, new PowerKw(150)), chargersCidade));
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

}