package fileIO;

import domain.Country;
import domain.Sale;
import org.apache.poi.ss.formula.functions.Count;
import repositories.Repositories;

import java.io.File;
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
        getEvolutionNumberVehicles();


    }

    // (último ano - primeiro ano) / primeiro ano (numero de veículos)
    private void getEvolutionNumberVehicles(){
        int diferenca = 0;
        int valor1 = -1;
        int valor2 = -1;
        int[] arrDifferenceYears = new int[2];
        System.out.println("Country | Difference\n");
        ArrayList<Country> countries = new ArrayList<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()) {
            if(!searchForCountry(entry.getKey().getCountry(), countries)){
                Map<Sale,Integer> map2 = getMapByYearsAndCountry(entry.getKey().getCountry(), getMapOfCountriesHighestAndLowestYear(entry.getKey().getCountry()),getMapOfCountries(entry.getKey().getCountry()));
                for(Map.Entry<Sale,Integer> map3 : map2.entrySet()){
                    if(valor1 ==-1){
                        arrDifferenceYears[0] = map3.getKey().getYear();
                        valor1 = map3.getValue();
                    }
                    else{
                        if(valor2 == -1){
                            arrDifferenceYears[1] = map3.getKey().getYear();
                            valor2 = map3.getValue();
                        }
                    }

                }

                if(arrDifferenceYears[1]>arrDifferenceYears[0]){
                    diferenca = valor2 - valor1;
                }
                else{
                    diferenca = valor1 - valor2;
                }
                System.out.printf("%s | %d\n",entry.getKey().getCountry(),diferenca);
                valor1 = -1;
                valor2 = -1;
                countries.add(entry.getKey().getCountry());
            }
        }

    }

    private boolean searchForCountry(Country country, ArrayList<Country> countries){
        for (int i = 0; i < countries.size(); i++) {
            if(countries.get(i).equals(country)){
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

    private int[] getMapOfCountriesHighestAndLowestYear(Country country){
        Map<Sale,Integer> mapL = getMapOfCountries(country);
        int maxValue = 0, minValue = 100000;

        for (Map.Entry<Sale,Integer> entry : mapL.entrySet()) {
            if(entry.getKey().getYear()>maxValue){
                maxValue = entry.getKey().getYear();
            }
            if(entry.getKey().getYear()<minValue){
                minValue = entry.getKey().getYear();
            }
        }
        int[] res = new int[2];
        res[0] = minValue;
        res[1] = maxValue;

        return res;
    }

    private Map<Sale,Integer> getMapByYearsAndCountry(Country country, int[] years, Map<Sale,Integer> map1){
        int numberVehiclesMax = 0,numberVehiclesMin = 0;
        Sale saleMax=null,saleMin=null;
        Map<Sale,Integer> res = new HashMap<>();
        for (Map.Entry<Sale,Integer> entry : map1.entrySet()){
            if(years[0] == entry.getKey().getYear()){
                numberVehiclesMin += entry.getValue();
                saleMin=entry.getKey();
            }
            if(years[1] == entry.getKey().getYear()){
                numberVehiclesMax += entry.getValue();
                saleMax = entry.getKey();
            }
        }
        res.put(saleMin,numberVehiclesMin);
        res.put(saleMax,numberVehiclesMax);
        return res;
    }






    private void objectAllocation(){
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i][0]==null){
                break;
            }
            try{
                map.put(new Sale(matriz[i][1],matriz[i][0],Integer.parseInt(matriz[i][2])),Integer.parseInt(matriz[i][3]));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }



}