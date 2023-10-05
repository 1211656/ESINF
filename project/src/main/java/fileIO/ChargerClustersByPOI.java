package fileIO;

import domain.Gps;
import domain.Supercharger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChargerClustersByPOI {
    private String file;
    private List<Supercharger> superchargerList;
    private Map<Gps, List<Supercharger>> superchargerClusterByPOI;

    public void defineFile(String file) {
        this.file = file;
        superchargerList = ReadChargersFile.getDataFromFile(file);
    }

    public void sortDataByPOI(List<Gps> POIList){
        superchargerClusterByPOI = new HashMap<>();
        for (Gps gps :
                POIList) {
            superchargerClusterByPOI.put(gps, new ArrayList<>());
        }

        for (Supercharger supercharger  :
                superchargerList) {
            double minimumDistance = Double.MAX_VALUE;
            Gps nearestPOI = null;

            for (Gps gps :
                    POIList) {

                double distance = supercharger.getAddress().getGpsCoordinates().getDistanceBetweenTwoChargers(gps);

                if (distance < minimumDistance){
                    minimumDistance = distance;
                    nearestPOI = gps;
                }
            }
            if (nearestPOI != null){
                superchargerClusterByPOI.get(nearestPOI).add(supercharger);
            }
        }
    }
    public void printMap() {
        for (Map.Entry<Gps, List<Supercharger>> entry : superchargerClusterByPOI.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
