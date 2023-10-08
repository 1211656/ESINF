package fileIO;

import domain.Gps;
import domain.Supercharger;

import java.util.*;

public class ChargerClustersByPOI {
    private String file;
    private List<Supercharger> superchargerList;
    private Map<Gps, List<Supercharger>> superchargerClusterByPOI;

    /**
     * Define the file to read the data from, and get the data from the file
     * @param file
     */
    public void defineFile(String file) {
        this.file = file;
        superchargerList = ReadChargersFile.getDataFromFile(file);
    }

    /**
     * Cluster data by POI
     * @param POIList
     * @return Map<Gps, List<Supercharger>>
     */
    public Map<Gps, List<Supercharger>> getDataByPOI(List<Gps> POIList){
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
        return sortData(superchargerClusterByPOI);
    }


    /**
     * Sort the data by the number of superchargers in each POI
     * @param unsortedMap
     * @return Map<Gps, List<Supercharger>>
     */
    private Map<Gps, List<Supercharger>> sortData(Map<Gps, List<Supercharger>> unsortedMap) {
        Map<Gps, List<Supercharger>> sortedMap = new TreeMap<>(new Comparator<Gps>() {
            @Override
            public int compare(Gps o1, Gps o2) {
                int size1 = superchargerClusterByPOI.get(o1).size();
                int size2 = superchargerClusterByPOI.get(o2).size();
                return Integer.compare(size2, size1);
            }
        });

        for (Map.Entry<Gps, List<Supercharger>> entry
                : unsortedMap.entrySet()) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public void printMap() {
        for (Map.Entry<Gps, List<Supercharger>> entry : superchargerClusterByPOI.entrySet()) {
            System.out.println(entry.getKey());
            List<Supercharger> superchargerList = entry.getValue();
            for (Supercharger supercharger :
                    superchargerList) {
                System.out.println(supercharger.getAddress().getCity());
            }
        }
    }
}
