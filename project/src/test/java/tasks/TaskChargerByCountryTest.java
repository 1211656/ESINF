package tasks;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import structures.StructureChargersByCountry;
import utils.Bootstrap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskChargerByCountryTest {
    StructureChargersByCountry structure ;
    Bootstrap bootstrap = new Bootstrap();
    Map<Country, Map<City, Stalls>> chargersCidade;

    TaskChargerByCountryTest() throws IOException {
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

}
