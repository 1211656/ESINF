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
        System.out.println("Country | Difference\n");
        ArrayList<Country> countries = new ArrayList<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()) {
            if(!searchForCountry(entry.getKey().getCountry(), countries)){
                Map<Sale,Integer> map2 = getMapOfCountriesHighestAndLowestYear(entry.getKey().getCountry());
                for(Map.Entry<Sale,Integer> map3 : map2.entrySet()){
                    diferenca = Math.abs(map3.getValue() - diferenca);
                }
                System.out.printf("%s | %d\n",entry.getKey().getCountry(),diferenca);
                diferenca = 0;
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

    private Map<Sale,Integer> getMapOfCountriesHighestAndLowestYear(Country country){
        Map<Sale,Integer> mapL = getMapOfCountries(country);
        int maxValue = 0, minValue = 100000;
        Sale saleMin = null ,saleMax = null;

        for (Map.Entry<Sale,Integer> entry : mapL.entrySet()) {
            if(entry.getKey().getYear()>maxValue){
                saleMax = entry.getKey();
                maxValue = entry.getKey().getYear();
            }
            if(entry.getKey().getYear()<minValue){
                saleMin = entry.getKey();
                minValue = entry.getKey().getYear();
            }
        }
        Map<Sale,Integer> res = new HashMap<>();
        res.put(saleMin,mapL.get(saleMin));
        res.put(saleMax,mapL.get(saleMax));

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