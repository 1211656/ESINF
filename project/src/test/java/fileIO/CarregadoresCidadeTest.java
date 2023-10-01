package fileIO;

import domain.City;
import domain.Country;
import domain.Stalls;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CarregadoresCidadeTest implements Files{

    CarregadoresCidade carregadoresCidade;


    // verifica se é detetada a falta de presença da cidade porto
    @Test
    void searchForCityInMapNull() {
        carregadoresCidade = new CarregadoresCidade();
        boolean expected = false;
        assertEquals(expected,carregadoresCidade.searchForCityInMap(new Country("Portugal"),new City("Porto")));
    }


    // verifica se a cidade porto é detetada no mapa e verifica que lisboa não se encontra no mapa
    @Test
    void searchForCityInMap() {
        carregadoresCidade = new CarregadoresCidade();
        Country country = new Country("Portugal");
        City city = new City("Porto");
        City city1 = new City("Lisboa");
        carregadoresCidade.chargersCidade.putIfAbsent(country, new HashMap<>());
        carregadoresCidade.chargersCidade.get(country).put(city, new Stalls(1));

        boolean expected1 = true;
        boolean expected2 = false;
        assertEquals(expected1,carregadoresCidade.searchForCityInMap(country,city));
        assertEquals(expected2,carregadoresCidade.searchForCityInMap(country,city1));

    }



    @Test
    void getChargers() {
        CarregadoresCidade carregadoresCidade = new CarregadoresCidade();
        carregadoresCidade.GetChargers(Teste);
        carregadoresCidade.mostraCarregadorCidade();
    }

    // vê se ao adicionar 1 numero de stalls aparece no mapa
    @Test
    void addStallsToCity() {
        carregadoresCidade = new CarregadoresCidade();
        Country country = new Country("Portugal");
        City city = new City("Porto");
        Stalls stalls = new Stalls(1);
        carregadoresCidade.chargersCidade.putIfAbsent(country, new HashMap<>());
        carregadoresCidade.chargersCidade.get(country).put(city, stalls);
        carregadoresCidade.addStallsToCity(country,city,stalls);
        int expected = 2;
        assertEquals(expected,carregadoresCidade.chargersCidade.get(country).get(city).getNumberOfStalls());

    }

    @Test
    void searchForCountryInMap() {
        carregadoresCidade = new CarregadoresCidade();
        carregadoresCidade.chargersCidade.put(new Country("Portugal"),new HashMap<>());
        boolean expectedResult = true;
        assertEquals(expectedResult,carregadoresCidade.searchForCountryInMap(new Country("Portugal")));

    }

    @Test
    void searchForCountryInMapNull() {
        carregadoresCidade = new CarregadoresCidade();
        boolean expectedResult = false;
        assertEquals(expectedResult,carregadoresCidade.searchForCountryInMap(null));

    }
}