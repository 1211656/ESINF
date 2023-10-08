package tasks;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;
import org.junit.jupiter.api.Test;
import structures.StructureChargersByCountry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskChargerByCountryTest {
    StructureChargersByCountry structure ;

    TaskChargerByCountryTest() throws IOException {
        structure = new StructureChargersByCountry();
    }
    @Test
    void contaCarregadorPais() {
        Country portugal = new Country("Portugal");
        City lisbon = new City("Lisbon");
        City porto = new City("Porto");
        City madeira = new City("Madeira");
        City zurich = new City("Zurich");

        Map<Country, Map<City, Stalls>> chargersCidade = new HashMap<>();

        // Portugal 7 carregadores menor ou igual a 150kw, 4 carregadores maior que 150kw
        chargersCidade.put(portugal, new HashMap<>());

        chargersCidade.get(portugal).put(lisbon, new Stalls(5, new PowerKw(100)));
        chargersCidade.get(portugal).put(porto, new Stalls(4, new PowerKw(200)));
        chargersCidade.get(portugal).put(madeira, new Stalls(2, new PowerKw(150)));

        // Suiça 3 carregadores maior que 150kw
        chargersCidade.put(new Country("Switzerland"), new HashMap<>());

        chargersCidade.get(new Country("Switzerland")).put(zurich, new Stalls(3, new PowerKw(180)));

        // Verifica se o número de carregadores por país está correto
        Map<Country, Map<String, Integer>> resultado = structure.getTask().contaCarregadorPais(chargersCidade,150);
        assertEquals(7, resultado.get(portugal).get("<=150"));
        assertEquals(4, resultado.get(portugal).get(">150"));
        assertEquals(0, resultado.get(new Country("Switzerland")).get("<=150"));
        assertEquals(3, resultado.get(new Country("Switzerland")).get(">150"));
    }
}
