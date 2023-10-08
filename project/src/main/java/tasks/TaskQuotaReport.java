package tasks;

import domain.Country;
import domain.Sale;
import domain.Supercharger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskQuotaReport {

    public TaskQuotaReport(){}

    public void getQuotaData(int year, Map<Country, Double> quotaData,Map<Country, Integer> stallsData,Map<Country, Integer> vehiclesData,int ratio,List<Sale> saleList,List<Supercharger> superchargerList){
        sortDataByCountry(year,stallsData,vehiclesData,saleList,superchargerList);
        quotaData = new HashMap<>();
        for (Country country :
                stallsData.keySet()) {
            quotaData.put(country, calculateQuota(vehiclesData.get(country), stallsData.get(country),ratio));
        }
    }

    private double calculateQuota(int electricVehiclesSold, int stalls,int ratio){
        return (double) (stalls*ratio)/electricVehiclesSold;
    }
    private void sortDataByCountry(int year, Map<Country, Integer> stallsData, Map<Country, Integer> vehiclesData, List<Sale> saleList,List<Supercharger> superchargerList){
        stallsData = new HashMap<>();
        vehiclesData = new HashMap<>();
        int totalSales = 0;
        int totalStalls = 0;
        Country currentCountry = null;
        for (Sale sale :
                saleList) {
            if(sale.getYear()==year) {
                Country saleCountry = sale.getCountry();
                if (vehiclesData.containsKey(saleCountry)) {
                    vehiclesData.put(saleCountry, vehiclesData.get(saleCountry) + sale.getVehiclesSold());
                } else {
                    vehiclesData.put(saleCountry, sale.getVehiclesSold());
                }
            }
        }
        for (Supercharger supercharger :
                superchargerList) {
            Country superchargerCountry = supercharger.getAddress().getCountry();
            if (stallsData.containsKey(superchargerCountry)) {
                stallsData.put(superchargerCountry, stallsData.get(superchargerCountry) + supercharger.getStalls().getNumberOfStalls());
            } else {
                stallsData.put(superchargerCountry, supercharger.getStalls().getNumberOfStalls());
            }
        }
    }
    public List<Sale> getDataFromFile(String[][] data){
        List<Sale> sales = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            sales.add(new Sale(row[1].trim(), row[0].trim(), row[2].trim(), row[3].trim()));
        }
        return sales;
    }


}
