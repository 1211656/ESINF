package structures;

import domain.*;
import fileIO.Files;
import tasks.TaskChargerClusterByPOI;
import utils.UtilsFile;

import java.io.IOException;
import java.util.*;

public class StructureChargerClusterByPOI implements Files {
    private List<Supercharger> superchargerList;
    private Map<Gps, List<Supercharger>> superchargerClusterByPOI;
    private String[][] data;
    private TaskChargerClusterByPOI task;

    public StructureChargerClusterByPOI() throws IOException {
        task = new TaskChargerClusterByPOI();
        data = UtilsFile.readFileToArray(CarregadoresFile);
        superchargerList = task.getDataFromFile(data);

    }

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
        return task.sortData(superchargerClusterByPOI,superchargerClusterByPOI);
    }



}
