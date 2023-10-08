package fileIO;

import domain.Gps;
import domain.Supercharger;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ChargerClustersTest {

    @Test
    public void testClusters(){
        ChargerClustersByPOI chargerClustersByPOI = new ChargerClustersByPOI();
        chargerClustersByPOI.defineFile("C://Users//Diogo//Documents//ESINF//testChargers.csv");
        List<Gps> POIList = new ArrayList<>();
        POIList.add(new Gps(41.14961, 30));
        POIList.add(new Gps(35, 8));
        POIList.add(new Gps(20, -2));
        Map<Gps, List<Supercharger>> sortedMap = chargerClustersByPOI.getDataByPOI(POIList);
        chargerClustersByPOI.printMap();
    }

    private Map<Gps, List<Supercharger>> populateMap(){
        Map<Gps, List<Supercharger>> sortedMap = new TreeMap<>(new Comparator<Gps>() {
            @Override
            public int compare(Gps o1, Gps o2) {
                int size1 = sortedMap.get(o1).size();
                int size2 = sortedMap.get(o2).size();
                return Integer.compare(size2, size1);
            }
        });



    }


}
