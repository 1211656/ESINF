package tasks;

import domain.*;

import java.util.*;

public class TaskChargerClusterByPOI {

    public TaskChargerClusterByPOI(){}

    public List<Supercharger> getDataFromFile(String[][] data){
        List<Supercharger> superchargerList = new ArrayList<>();


        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            try {
                boolean value;
                if(row[11].trim().equalsIgnoreCase("open")){
                    value = true;
                }
                else {
                    value = false;
                }
                superchargerList.add(new Supercharger(
                        row[6].trim(), // country
                        row[4].trim(), // state
                        row[3].trim(), // city
                        row[2].trim(), // Street address
                        row[5].trim(), // zip code
                        new Stalls(Integer.parseInt(row[7].trim())), // stalls
                        new PowerKw(Integer.parseInt(row[8].trim())), // power kw
                        new Elevm(Integer.parseInt(row[10].trim())), // elevm
                        new Status(value), // status
                        row[9].trim())); // gps
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return superchargerList;
    }
    public Map<Gps, List<Supercharger>> sortData(Map<Gps, List<Supercharger>> unsortedMap,Map<Gps, List<Supercharger>> superchargerClusterByPOI) {
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
    public void printMap(Map<Gps, List<Supercharger>> superchargerClusterByPOI) {
        for (Map.Entry<Gps, List<Supercharger>> entry : superchargerClusterByPOI.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
