package fileIO;

import domain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChargerClustersTest {

    @Test
    public void testClusters(){
        ChargerClustersByPOI chargerClustersByPOI = new ChargerClustersByPOI();
        chargerClustersByPOI.defineFile("C://Users//Diogo//Documents//ESINF//project//src//test//testFiles//chargerClustersTest.csv");
        List<Gps> POIList = new ArrayList<>();
        POIList.add(new Gps(0, 0));
        POIList.add(new Gps(5, 5));
        POIList.add(new Gps(7, 7));
        Map<Gps, List<Supercharger>> sortedMap = chargerClustersByPOI.getDataByPOI(POIList);
        assertEquals(sortedMap, populateMap());
    }

    private Map<Gps, List<Supercharger>> populateMap(){
        Gps gps1 = new Gps(0, 0);
        Gps gps2 = new Gps(5, 5);
        Gps gps3 = new Gps(7, 7);

        Supercharger supercharger1 = new Supercharger("Country 1", "State 1", "City 1", "Street 1", "1111", new Stalls(1), new PowerKw(150), new Elevm(1111), Status.createStatus("Open"), "1.11, 1.11");
        Supercharger supercharger2 = new Supercharger("Country 1", "State 2", "City 2", "Street 2", "2222", new Stalls(2), new PowerKw(150), new Elevm(2222), Status.createStatus("Open"), "2.22, 2.22");
        Supercharger supercharger3 = new Supercharger("Country 1", "State 3", "City 3", "Street 3", "3333", new Stalls(3), new PowerKw(150), new Elevm(3333), Status.createStatus("Open"), "3.33, 3.33");
        Supercharger supercharger4 = new Supercharger("Country 2", "State 4", "City 4", "Street 4", "4444", new Stalls(4), new PowerKw(150), new Elevm(4444), Status.createStatus("Open"), "4.44, 4.44");
        Supercharger supercharger5 = new Supercharger("Country 2", "State 5", "City 5", "Street 5", "5555", new Stalls(5), new PowerKw(150), new Elevm(5555), Status.createStatus("Open"), "5.55, 5.55");
        Supercharger supercharger6 = new Supercharger("Country 2", "State 6", "City 6", "Street 6", "6666", new Stalls(6), new PowerKw(150), new Elevm(6666), Status.createStatus("Open"), "6.66, 6.66");
        Supercharger supercharger7 = new Supercharger("Country 3", "State 7", "City 7", "Street 7", "7777", new Stalls(7), new PowerKw(150), new Elevm(7777), Status.createStatus("Open"), "7.77, 7.77");
        Supercharger supercharger8 = new Supercharger("Country 3", "State 8", "City 8", "Street 8", "8888", new Stalls(8), new PowerKw(150), new Elevm(8888), Status.createStatus("Open"), "8.88, 8.88");
        Supercharger supercharger9 = new Supercharger("Country 3", "State 9", "City 9", "Street 9", "9999", new Stalls(9), new PowerKw(150), new Elevm(9999), Status.createStatus("Open"), "9.99, 9.99");

        List<Supercharger> list1 = new ArrayList<>(), list2 = new ArrayList<>(), list3 = new ArrayList<>();
        list1.add(supercharger1);
        list1.add(supercharger2);
        list2.add(supercharger3);
        list2.add(supercharger4);
        list2.add(supercharger5);
        list3.add(supercharger6);
        list3.add(supercharger7);
        list3.add(supercharger8);
        list3.add(supercharger9);

        Map<Gps, List<Supercharger>> superchargerClusterByPOI = new HashMap<>();
        superchargerClusterByPOI.put(gps1, list1);
        superchargerClusterByPOI.put(gps2, list2);
        superchargerClusterByPOI.put(gps3, list3);


        Map<Gps, List<Supercharger>> sortedMap = new TreeMap<>(new Comparator<Gps>() {
            @Override
            public int compare(Gps o1, Gps o2) {
                int size1 = superchargerClusterByPOI.get(o1).size();
                int size2 = superchargerClusterByPOI.get(o2).size();
                return Integer.compare(size2, size1);
            }
        });

        for (Map.Entry<Gps, List<Supercharger>> entry
                : superchargerClusterByPOI.entrySet()) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


}
