package tasks;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que guarda as tarefas necessárias para obter a estrutura final
 */
public class TaskCityChargers {

    /**
     * Construtor
     */
    public TaskCityChargers(){}
    /**
     * função que faz print da estrutura
     */
    public void mostraCarregadorCidade(Map<Country,Map<City,Stalls>> chargersCidade) {
        // Percorre o Map chargersCidade
        for (Map.Entry<Country, Map<City, Stalls>> entry : chargersCidade.entrySet()) {
            // Percorre o Map interno chargersCidade
            for (Map.Entry<City, Stalls> entry2 : entry.getValue().entrySet()) {
                System.out.println( entry.getKey() + " | " +entry2.getKey().getName() + " | " + entry2.getValue().getNumberOfStalls());
            }
        }
    }

    /**
     * @param country
     * @param city
     * @param chargersCidade
     * @return true if city in map, false if isn't
     */
    public boolean searchForCityInMap(Country country,City city,Map<Country,Map<City,Stalls>> chargersCidade){
        if(country == null || city == null || chargersCidade == null){
            return false;
        }
        for (Map.Entry<Country, Map<City, Stalls>> entry : chargersCidade.entrySet()) {
            if(entry.getValue().containsKey(city)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param country
     * @param chargersCidade
     * @return true if country in map, false if not
     */
    public boolean searchForCountryInMap(Country country,Map<Country,Map<City,Stalls>> chargersCidade){
        if(chargersCidade==null){
            return false;
        }
        return chargersCidade.containsKey(country);
    }

    /**
     * @param country
     * @param city
     * @param stalls
     * @param chargersCidade
     * @return boolean value after adding stalls to the same city
     */
    public boolean addStallsToCity(Country country, City city, Stalls stalls,Map<Country,Map<City,Stalls>> chargersCidade){
        try{
            Map<City,Stalls> map = chargersCidade.get(country);
            map.get(city).setNumberOfStalls(map.get(city).getNumberOfStalls()+stalls.getNumberOfStalls());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * @param country
     * @param chargersCidade
     * @return Country referente à string passada como parâmetro
     */
    public Country getCountryInMap(String country,Map<Country,Map<City,Stalls>> chargersCidade){
        if(country == null || chargersCidade == null){
            return null;
        }
        for(Map.Entry<Country,Map<City,Stalls>> entry : chargersCidade.entrySet()){
            if(entry.getKey().getName().equalsIgnoreCase(country)){
                return entry.getKey();
            }
        }
        return new Country(country);
    }

    /**
     * @param city
     * @param country
     * @param chargersCidade
     * @return City referente à string lida
     */
    public City getCityInMap(String city, Country country,Map<Country,Map<City,Stalls>> chargersCidade){
        if(city==null || country == null || chargersCidade == null){
            return null;
        }
        if(searchForCountryInMap(country,chargersCidade)){
            Map<City,Stalls> map = chargersCidade.get(country);
            for(Map.Entry<City,Stalls> entry : map.entrySet()){
                if(entry.getKey().getName().equalsIgnoreCase(city)){
                    return entry.getKey();
                }
            }
        }
        return new City(city);
    }
}