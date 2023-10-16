package tasks;

import domain.*;
import org.apache.poi.poifs.filesystem.Entry;

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
    public Map<Gps, List<Supercharger>> sortData(Map<Gps, List<Supercharger>> unsortedMap) {
        // Convert the map to a list of entries
        List<Map.Entry<Gps, List<Supercharger>>> entryList = new ArrayList<>(unsortedMap.entrySet());

        // Create a custom comparator based on the size of the lists in descending order
        Comparator<Map.Entry<Gps, List<Supercharger>>> byListSizeDesc = (entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size());

        // Sort the list of entries based on the comparator
        entryList.sort(byListSizeDesc);

        // Create a new map (LinkedHashMap) to store the sorted entries
        Map<Gps, List<Supercharger>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Gps, List<Supercharger>> entry : entryList) {
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
