package structures;

import domain.Country;
import domain.Gps;
import fileIO.Files;
import org.junit.jupiter.api.Test;
import utils.Bootstrap;
import utils.UtilsFile;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StructureWithMinAutonomyTest implements Files {


    private SortedMap<Country,String> map ;
    StructureWithMinAutonomy structure;
    Bootstrap bootstrap;
    LinkedHashMap<Country,Double> finalMap;

    StructureWithMinAutonomyTest() throws IOException {
        bootstrap = new Bootstrap();
        structure = new StructureWithMinAutonomy(bootstrap);
        finalMap = structure.ordenateMap2(structure.getFinalMap());
    }

    @Test
    void generate() throws IOException {
        for(Map.Entry<Country,Double> entry : finalMap.entrySet()){
            System.out.printf("Country: %s -> Minima Autonomia: %.2f\n",entry.getKey(),entry.getValue());
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

        //assertEquals(1491,structureWithMinAutonomy.getHighestDistanceBetweenChargersInCountry(gpsList));


    }

    @Test
    void getMapByCountry() {

    }

    @Test
    void getFinalMap() {
        LinkedHashMap<Country,Double> mapFinal = structure.ordenateMap2(structure.getFinalMap());

        for(Map.Entry<Country,Double> entry : mapFinal.entrySet()){
            System.out.printf("%s -> %.2f\n", entry.getKey(),entry.getValue());
        }
    }

    @Test
    void getListOfGpsByMapCountry() {

    }


}