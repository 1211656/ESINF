package tasks;

import domain.Country;
import domain.Gps;

import java.util.*;

public class TaskMinAutonomy {

    public TaskMinAutonomy(){

    }

    public Map<Gps, Country> getMapByCountry(Country country,Map<Gps,Country> mapGeneral){
        Map<Gps,Country> mapCountry = new HashMap<>();

        for(Map.Entry<Gps,Country> entry : mapGeneral.entrySet()){
            if(entry.getValue().toString().equals(country.toString())){

                mapCountry.put(entry.getKey(),entry.getValue());
            }
        }
        return mapCountry;
    }

    public double getHighestDistanceBetweenChargersInCountry(List<Gps> gpsList){
        Gps gps1 = null;
        Gps gps2 = null;
        double distancia=0;
        int index = 0;
        List<Gps> ret = new ArrayList<>();
        while(index != gpsList.size()-1) {
            for (int i = index; i < gpsList.size() - 1; i++) {
                if (gpsList.get(i).getDistanceBetweenTwoChargers(gpsList.get(i + 1)) > distancia) {
                    distancia = gpsList.get(index).getDistanceBetweenTwoChargers(gpsList.get(i + 1));
                    gps1 = gpsList.get(index);
                    gps2 = gpsList.get(i + 1);
                }
            }
            index ++;
        }
        ret.add(gps1);
        ret.add(gps2);
        return distancia;
    }

    public boolean findKeyInMapByString(String key, LinkedHashMap<Country,Double> finalMap){
        for(Map.Entry<Country,Double> entry : finalMap.entrySet()){
            if(entry.getKey().toString().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }

    public LinkedHashMap<Country,Double> ordenateMap(LinkedHashMap<Country,Double> sortedMap){
        List<Double> values = new ArrayList<>(sortedMap.values());
        Collections.sort(values,Collections.reverseOrder());
        LinkedHashMap<Country,Double> res = new LinkedHashMap<>();
        int i = 0;
        for(Map.Entry<Country,Double> entry : sortedMap.entrySet()){

            res.put(getCountryByDouble(sortedMap,values.get(i)),values.get(i));
            i ++;
        }
        return res;
    }

    public LinkedHashMap<Country,Double> ordenateMap2(LinkedHashMap<Country,Double> sortedMap){
        List<Map.Entry<Country,Double>> listaEntradas = new ArrayList<>(sortedMap.entrySet());
        Collections.sort(listaEntradas,(entry1, entry2) -> {
            int comparacaoPorValor = Double.compare(entry2.getValue(),entry1.getValue());
            if(comparacaoPorValor==0){
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return comparacaoPorValor;
        });
        LinkedHashMap<Country, Double> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<Country, Double> entry : listaEntradas) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }
        return mapaOrdenado;
    }
    public Country getCountryByDouble(Map<Country,Double> sortedMap, Double value){
        for(Map.Entry<Country,Double> entry : sortedMap.entrySet()){
            if(entry.getValue()==value){
                return entry.getKey();
            }
        }
        return null;
    }

    public LinkedHashMap<Country,Double> getListOFSameDistanceValues(LinkedHashMap<Country,Double> linked, double distance){
        LinkedHashMap<Country,Double> ret = new LinkedHashMap<>();
        List<Country> countries = new ArrayList<>();
        for(Map.Entry<Country,Double> entry : linked.entrySet()){
            if(entry.getValue()==distance){
                ret.put(entry.getKey(),entry.getValue());
                countries.add(entry.getKey());
            }
        }
        return ret;
    }

    public List<Gps> getListOfGpsByMapCountry(Map<Gps,Country> map){
        List<Gps> gpsList = new ArrayList<>();
        for(Map.Entry<Gps,Country> entry : map.entrySet()){
            gpsList.add(entry.getKey());
        }
        return gpsList;
    }
}
