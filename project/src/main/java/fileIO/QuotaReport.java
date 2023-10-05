package fileIO;

import domain.Country;
import domain.Sale;
import domain.Supercharger;

import java.util.*;

public class QuotaReport {
    private int ratio;
    private String fileSales;
    private String fileSuperchargers;
    private List<Sale> saleList;
    private List<Supercharger> superchargerList;
    private Map<Country, Integer> stallsData;
    private Map<Country, Integer> vehiclesData;
    private Map<Country, Map<List<Integer>, Double>> quotaDataByCountry;
    private Map<Country, Double> quotaData;

    public void defineFiles(String fileSales, String fileSuperchargers) {
        this.fileSales = fileSales;
        this.fileSuperchargers = fileSuperchargers;
        saleList = ReadSalesFile.getDataFromFile(fileSales);
        superchargerList = ReadChargersFile.getDataFromFile(fileSuperchargers);
    }

    public Map<Country, Map<List<Integer>, Double>> getYearlyQuotaByCountry(int year){
        getQuotaData(year);
        quotaDataByCountry = new HashMap<>();
        for (Country country :
                quotaData.keySet()) {
            Map<List<Integer>, Double> aux = new HashMap<>();
            aux.put(Arrays.asList(stallsData.get(country), vehiclesData.get(country)), quotaData.get(country));
            quotaDataByCountry.put(country, aux);
        }
        return quotaDataByCountry;
    }

    private void getQuotaData(int year){
        sortDataByCountry(year);
        quotaData = new HashMap<>();
        for (Country country :
                stallsData.keySet()) {
            quotaData.put(country, calculateQuota(vehiclesData.get(country), stallsData.get(country)));
        }
    }

    private double calculateQuota(int electricVehiclesSold, int stalls){
        return (double) (stalls*ratio)/electricVehiclesSold;
    }
    private void sortDataByCountry(int year){
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

    public void defineRatio(int ratio) {
        this.ratio = ratio;
    }
}
