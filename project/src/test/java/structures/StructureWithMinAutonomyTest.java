package structures;

import domain.Country;
import domain.Gps;
import fileIO.Files;
import fileIO.ReadCarregadores;
import fileIO.ReadFile;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StructureWithMinAutonomyTest implements Files {


    private StructureWithMinAutonomy structureWithMinAutonomy = new StructureWithMinAutonomy(ReadCarregadores.readFile(Teste));
    private SortedMap<Country,String> map ;

    StructureWithMinAutonomyTest() throws IOException {
    }

    @Test
    void generate() throws IOException {
        // guarda a matriz dos dados
        Map<Gps,Country> res  = ReadCarregadores.readFile(Teste);
        System.out.println("Keys    ->     Values");
        for(SortedMap.Entry<Gps,Country> entry : res.entrySet()){
            System.out.printf("%.5f , %.5f -> %s\n", entry.getKey().getLatitude(),entry.getKey().getLongitude(), entry.getValue());
        }




    }

    @Test
    void testGetHighestDistanceBetweenChargersInCountry() {
        Gps gps1 = new Gps(1,1);
        Gps gps2 = new Gps(2,3);
        Gps gps3 = new Gps(10,11);
        Gps gps4 = new Gps(9,9);
        List<Gps> gpsList = new ArrayList<>();
        gpsList.add(gps1);
        gpsList.add(gps2);
        gpsList.add(gps3);
        gpsList.add(gps4);
        List<Gps> gpsExpected = new ArrayList<>();
        gpsExpected.add(gps1);
        gpsExpected.add(gps3);

        assertEquals(1491,structureWithMinAutonomy.getHighestDistanceBetweenChargersInCountry(gpsList));


    }

    @Test
    void getMapByCountry() {
        Map<Gps,Country> map = structureWithMinAutonomy.getMapByCountry(new Country("Portugal"));
        for (Map.Entry<Gps,Country> entry : map.entrySet()) {
            System.out.printf("%s\n",entry.getValue());
        }
    }

    @Test
    void getFinalMap() {
        LinkedHashMap<Country,Double> mapFinal = structureWithMinAutonomy.ordenateMap2(structureWithMinAutonomy.getFinalMap());

        for(Map.Entry<Country,Double> entry : mapFinal.entrySet()){
            System.out.printf("%s -> %.2f\n", entry.getKey(),entry.getValue());
        }
    }

    @Test
    void getListOfGpsByMapCountry() {
        List<Gps> gpsList = structureWithMinAutonomy.getListOfGpsByMapCountry(structureWithMinAutonomy.getMapByCountry(new Country("Portugal")));
        for (int i = 0; i < gpsList.size(); i++) {
            System.out.println(gpsList.get(i));
        }
    }


}