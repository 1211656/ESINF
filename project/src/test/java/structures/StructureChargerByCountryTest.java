package structures;

import domain.City;
import domain.Country;
import domain.Stalls;
import org.junit.jupiter.api.Test;
import utils.Bootstrap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StructureChargerByCountryTest {
    StructureChargersByCountry structure ;
    Bootstrap bootstrap = new Bootstrap();
    Map<Country, Map<City, Stalls>> chargersCidade;


    StructureChargerByCountryTest() throws IOException {
        structure = new StructureChargersByCountry(bootstrap);
        chargersCidade = structure.getChargersCidade();
    }

    @Test
    void generate(){
        for(Map.Entry<Country,Map<City, Stalls>> entry : chargersCidade.entrySet()){
            System.out.printf("Country: %s\n\n",entry.getKey());
            for(Map.Entry<City,Stalls> entry1 : entry.getValue().entrySet()){
                System.out.printf("City : %s -> %d Stalls\n",entry1.getKey(),entry1.getValue().getNumberOfStalls());
            }
            System.out.println();
            System.out.println();
        }
    }

    @Test
    void contaCarregadorPais() {

        Map<City,Stalls> mapCityStallsPortugal = new HashMap<>();
        mapCityStallsPortugal.put(new City("Lisbon"),new Stalls(12));
        Map<City,Stalls> mapCityStallsZimbabue = new HashMap<>();
        mapCityStallsZimbabue.put(new City("City1"),new Stalls(12));
        mapCityStallsZimbabue.put(new City("City2"),new Stalls(12));
        Map<City,Stalls> mapCityStallsBrazil = new HashMap<>();
        mapCityStallsBrazil.put(new City("Brazilia"),new Stalls(12));



        Map<Country, Map<City, Stalls>> chargersCidade2 = new HashMap<>();
        chargersCidade2.put(new Country("Portugal"),mapCityStallsPortugal);
        chargersCidade2.put(new Country("Brazil"),mapCityStallsBrazil);
        chargersCidade2.put(new Country("Zimbabue"),mapCityStallsZimbabue);


        // ver se o tamanho é igual
        assertEquals(chargersCidade.size(),chargersCidade2.size());

        // ver se o conteudo é igual
        for(Map.Entry<Country,Map<City, Stalls>> entry : chargersCidade.entrySet()){
            assertTrue(chargersCidade2.containsKey(entry.getKey()));
            for(Map.Entry<City,Stalls> entry1 : entry.getValue().entrySet()){
                assertEquals(entry1.getValue().getNumberOfStalls(),chargersCidade2.get(entry.getKey()).get(entry1.getKey()).getNumberOfStalls());
            }
        }

    }

}
