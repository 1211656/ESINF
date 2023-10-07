package tasks;

import domain.Country;
import domain.Sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskEvolutionNumberVehicles {



    public TaskEvolutionNumberVehicles(){}

    /**
     * @param country
     * @return map thai tis filtred by a counry passed by argument
     */
    public Map<Sale,Integer> getMapOfCountries(Country country,Map<Sale,Integer> map){
        Map<Sale,Integer> res = new HashMap<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()){
            if(entry.getKey().getCountry().equals(country)){
                res.put(entry.getKey(),entry.getValue());
            }
        }
        return res;
    }

    /**
     * @param firstYear
     * @param secondYear
     * @param country
     * @return retur true if both years are in map
     */
    public boolean searchIfBothYearsAreInMap(int firstYear, int secondYear, Country country,Map<Sale,Integer> map){
        Map<Sale,Integer> mapThis = getMapOfCountries(country,map);
        int years = 0;
        for(Map.Entry<Sale,Integer> entry : mapThis.entrySet()){
            if(entry.getKey().getYear()==firstYear || entry.getKey().getYear()==secondYear){
                years ++;
            }
            if(years == 2){
                return true;
            }
        }
        return false;
    }


    /**
     * @param firstYear
     * @param secondYear
     * @param map1
     * @return map filtred by years and country passed by argument
     */
    public Map<Sale,Integer> getMapByYearsAndCountry( int firstYear,int secondYear, Map<Sale,Integer> map1){
        int numberVehiclesMax = 0,numberVehiclesMin = 0;
        Sale saleMax=null,saleMin=null;
        Map<Sale,Integer> res = new HashMap<>();
        for (Map.Entry<Sale,Integer> entry : map1.entrySet()){
            if(firstYear == entry.getKey().getYear()){
                numberVehiclesMin += entry.getValue();
                saleMin=entry.getKey();
            }
            if(secondYear == entry.getKey().getYear()){
                numberVehiclesMax += entry.getValue();
                saleMax = entry.getKey();
            }
        }
        res.put(saleMin,numberVehiclesMin);
        res.put(saleMax,numberVehiclesMax);
        return res;
    }

    /**
     * allocation of the objects
     */
    public void objectAllocation(String[][] matriz){
        for (String[] strings : matriz) {
            if (strings[0] == null) {
                break;
            }
            try {
                //map.put(new Sale(strings[1], strings[0], Integer.parseInt(strings[2])), Integer.parseInt(strings[3]));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
