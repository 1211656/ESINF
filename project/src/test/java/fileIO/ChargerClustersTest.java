package fileIO;

import domain.Gps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChargerClustersTest {

    @Test
    public void testClusters(){
        //ChargerClustersByPOI chargerClustersByPOI = new ChargerClustersByPOI();
        List<Gps> POIList = new ArrayList<>();
        POIList.add(new Gps(41.14961, 30));
        POIList.add(new Gps(35, 8));
        POIList.add(new Gps(20, -2));
        //chargerClustersByPOI.sortDataByPOI(POIList);
        //chargerClustersByPOI.printMap();
    }
}
