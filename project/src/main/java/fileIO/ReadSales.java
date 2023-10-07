package fileIO;

import domain.Country;
import domain.Sale;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadSales implements Files {
    private String[][] matriz;


    // SALE : country , year, type Vehicle
    private Map<Sale,Integer> map;


    public ReadSales() {
        matriz = ReadFile.readFile(SalesFile);
        map = new HashMap<>();
        objectAllocation();
    }

    /**
     * @param firstYear
     * @param secondYear
     * @return map that gets the evolution of number of vehicles
     */
    public Map<Country,Double> getEvolutionNumberVehicles(int firstYear, int secondYear){
        Map<Country,Double> res = new HashMap<>();
        double diferenca ;
        int valor1 = -1;
        int valor2 = -1;
        int[] arrDifferenceYears = new int[2];
        ArrayList<Country> countries = new ArrayList<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()) {
            if (!countries.contains(entry.getKey().getCountry())) {
                if (searchIfBothYearsAreInMap(firstYear,secondYear,entry.getKey().getCountry())) {
                    Map<Sale, Integer> map2 = getMapByYearsAndCountry(firstYear, secondYear, getMapOfCountries(entry.getKey().getCountry()));
                    for (Map.Entry<Sale, Integer> map3 : map2.entrySet()) {
                        if (valor1 == -1) {
                            arrDifferenceYears[0] = map3.getKey().getYear();
                            valor1 = map3.getValue();
                        } else {
                            if (valor2 == -1) {
                                arrDifferenceYears[1] = map3.getKey().getYear();
                                valor2 = map3.getValue();
                            }
                        }

                    }

                    if (arrDifferenceYears[1] > arrDifferenceYears[0]) {
                        diferenca = (double) (valor2 - valor1) / valor1;
                    } else {
                        diferenca = (double) (valor1 - valor2) / valor2;
                    }
                    System.out.printf("%s | %.2f\n", entry.getKey().getCountry(), diferenca);
                    res.put(entry.getKey().getCountry(),diferenca);
                    valor1 = -1;
                    valor2 = -1;
                    countries.add(entry.getKey().getCountry());
                }
            }
        }
        return res;
    }


    /**
     * @param country
     * @return map thai tis filtred by a counry passed by argument
     */
    public Map<Sale,Integer> getMapOfCountries(Country country){
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
    public boolean searchIfBothYearsAreInMap(int firstYear, int secondYear, Country country){
        Map<Sale,Integer> mapThis = getMapOfCountries(country);
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
    public void objectAllocation(){
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