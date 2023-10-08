package tasks;

import domain.Country;
import domain.YearPair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TaskDecreaseInSales {


    public TaskDecreaseInSales(){

    }

    public void addLine(String[] line, int firstYear, int salesVariation,Map<Country, Map<YearPair, Map<String, Integer>>> map){
        if (map.containsKey(new Country(line[0]))){
            Map<YearPair, Map<String, Integer>> aux = map.get(new Country(line[0]));
            if (aux.containsKey(new YearPair(firstYear, Integer.parseInt(line[2])))){
                Map<String, Integer> salesByPowertrain = aux.get(new YearPair(firstYear, Integer.parseInt(line[2])));
                salesByPowertrain.put(line[1], -salesVariation);
            }else{
                Map<String, Integer> salesByPowertrain = new TreeMap<>();
                salesByPowertrain.put(line[1], -salesVariation);
                aux.put(new YearPair(firstYear, Integer.parseInt(line[2])), salesByPowertrain);
            }
        } else {
            Map<YearPair, Map<String, Integer>> aux = new HashMap<>();
            Map<String, Integer> salesByPowertrain = new TreeMap<>();
            salesByPowertrain.put(line[1], -salesVariation);
            aux.put(new YearPair(firstYear, Integer.parseInt(line[2])), salesByPowertrain);
            map.put(new Country(line[0]), aux);
        }
    }

    public void print(Map<Country, Map<Integer[], Map<String, Integer>>> map){
        for (Map.Entry<Country, Map<Integer[], Map<String, Integer>>> entry :
                map.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Integer[], Map<String, Integer>> entry1 :
                    entry.getValue().entrySet()) {
                System.out.println(Arrays.toString(entry1.getKey()));
                for (Map.Entry<String, Integer> entry2 :
                        entry1.getValue().entrySet()) {
                    System.out.println(entry2.getKey() + " " + entry2.getValue());
                    System.out.println();
                }
            }
        }
    }
}
