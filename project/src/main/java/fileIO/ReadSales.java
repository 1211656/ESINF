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

    // Método que faz print da lista de países e
    // (último ano - primeiro ano) / primeiro ano (numero de veículos)

    public Map<Country,Double> getEvolutionNumberVehicles(int firstYear, int secondYear){
        Map<Country,Double> res = new HashMap<>();
        double diferenca ;
        int valor1 = -1;
        int valor2 = -1;
        int[] arrDifferenceYears = new int[2];
        System.out.println("Country | Evolution\n");
        ArrayList<Country> countries = new ArrayList<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()) {
            if (!searchForCountry(entry.getKey().getCountry(), countries)) {
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

    private boolean searchForCountry(Country country, ArrayList<Country> countries){
        for (Country value : countries) {
            if (value.equals(country)) {
                return true;
            }
        }
        return false;
    }


    private Map<Sale,Integer> getMapOfCountries(Country country){
        Map<Sale,Integer> res = new HashMap<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()){
            if(entry.getKey().getCountry().equals(country)){
                res.put(entry.getKey(),entry.getValue());
            }
        }
        return res;
    }

    private boolean searchIfBothYearsAreInMap(int firstYear, int secondYear, Country country){
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

    private Map<Sale,Integer> getMapByYearsAndCountry( int firstYear,int secondYear, Map<Sale,Integer> map1){
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

    private void objectAllocation(){
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