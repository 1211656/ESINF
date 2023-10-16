package structures;

import domain.*;
import fileIO.Files;
import tasks.TaskChargerClusterByPOI;
import utils.Bootstrap;
import utils.UtilsFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StructureChargerClusterByPOI implements Files {
    private List<Supercharger> superchargerList;
    private Map<Gps, List<Supercharger>> superchargerClusterByPOI;
    private String[][] data;
    private TaskChargerClusterByPOI task;
    private Bootstrap bootstrap;

    public StructureChargerClusterByPOI(Bootstrap bootstrap) throws IOException {
        task = new TaskChargerClusterByPOI();
        bootstrap = bootstrap;
        data = bootstrap.getMatrizChargersClusterByPOI();
        superchargerList = task.getDataFromFile(data);

    }

    /**
     * metodo que retorna o mapa do exercicio 6
     * @param POIList
     * @return map ex6
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
        return task.sortData(superchargerClusterByPOI);
    }



}
