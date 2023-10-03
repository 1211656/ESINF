package fileIO;

import domain.Country;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DecreaseInSales {
    private Map<Country, Map<Integer[], Map<String, Integer>>> ex3;

    public DecreaseInSales(){
        this.ex3 = new TreeMap<>();
    }

    public void getData(String file){
        String[][] data = ReadFile.readFile(new File(file));
        int firstYear = 0;
        int firstYearSales = 0;
        for (String[] line :
                data) {
            if(line[0] == null){
                break;
            } else {
                if (firstYear < Integer.parseInt(line[2]) && firstYearSales > Integer.parseInt(line[3])){
                    addLine(line, firstYear, firstYearSales- Integer.parseInt(line[3]));
                }

                firstYear = Integer.parseInt(line[2]);
                firstYearSales = Integer.parseInt(line[3]);
            }
        }
    }

    private void addLine(String[] line, int firstYear, int salesVariation){
        if (ex3.containsKey(new Country(line[0]))){
            Map<Integer[], Map<String, Integer>> aux = ex3.get(new Country(line[0]));
            if (aux.containsKey(new Integer[]{firstYear, Integer.parseInt(line[2])})){
                Map<String, Integer> salesByPowertrain = aux.get(new Integer[]{firstYear, Integer.parseInt(line[2])});
                salesByPowertrain.put(line[1], -salesVariation);
            }else{
                Map<String, Integer> salesByPowertrain = new TreeMap<>();
                salesByPowertrain.put(line[1], -salesVariation);
                aux.put(new Integer[]{firstYear, Integer.parseInt(line[2])}, salesByPowertrain);
            }
        } else {
            Map<Integer[], Map<String, Integer>> aux = new HashMap<>();
            Map<String, Integer> salesByPowertrain = new TreeMap<>();
            salesByPowertrain.put(line[1], -salesVariation);
            aux.put(new Integer[]{firstYear, Integer.parseInt(line[2])}, salesByPowertrain);
            ex3.put(new Country(line[0]), aux);
        }
    }

    public void print(){
        for (Map.Entry<Country, Map<Integer[], Map<String, Integer>>> entry :
                ex3.entrySet()) {
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
