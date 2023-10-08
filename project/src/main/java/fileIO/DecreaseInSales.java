package fileIO;

import domain.Country;
import domain.Sale;
import domain.YearPair;

import java.io.File;
import java.security.PublicKey;
import java.util.*;

public class DecreaseInSales {
    private Map<Country, Map<YearPair, Map<String, Integer>>> ex3;
    //Map<Country, Map<Years Analyzed, Map <Powertrain, Sales Variation>>>


    public DecreaseInSales(){
        this.ex3 = new TreeMap<>();
    }

    public Map<Country, Map<YearPair, Map<String, Integer>>> getData2(String file){
        List<Sale> sales = ReadSalesFile.getDataFromFile(file);
        for (Sale sale:
             sales) {
            for (Sale saleAux :
                    sales) {
                if(sale.getCountry().equals(saleAux.getCountry()) && sale.getYear() < saleAux.getYear() && sale.getTypeVehicle().equals(saleAux.getTypeVehicle()) && sale.getVehiclesSold()>saleAux.getVehiclesSold()){
                    addLine2(saleAux, sale.getYear(), sale.getVehiclesSold()- saleAux.getVehiclesSold());
                }
            }
        }
        return ex3;
    }

    public void addLine2(Sale sale, int firstYear, int salesVariation){
        if (ex3.containsKey(sale.getCountry())){
            Map<YearPair, Map<String, Integer>> aux = ex3.get(sale.getCountry());
            if (aux.containsKey(new YearPair(firstYear, sale.getYear()))){
                Map<String, Integer> salesByPowertrain = aux.get(new YearPair(firstYear, sale.getYear()));
                salesByPowertrain.put(sale.getTypeVehicle(), -salesVariation);
            }else{
                Map<String, Integer> salesByPowertrain = new TreeMap<>();
                salesByPowertrain.put(sale.getTypeVehicle(), -salesVariation);
                aux.put(new YearPair(firstYear, sale.getYear()), salesByPowertrain);
            }
        } else {
            Map<YearPair, Map<String, Integer>> aux = new HashMap<>();
            Map<String, Integer> salesByPowertrain = new TreeMap<>();
            salesByPowertrain.put(sale.getTypeVehicle(), -salesVariation);
            aux.put(new YearPair(firstYear, sale.getYear()), salesByPowertrain);
            ex3.put(sale.getCountry(), aux);
        }
    }


    public void print(){
        for (Map.Entry<Country, Map<YearPair, Map<String, Integer>>> entry :
                ex3.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<YearPair, Map<String, Integer>> entry1 :
                    entry.getValue().entrySet()) {
                System.out.println(entry1.getKey());
                for (Map.Entry<String, Integer> entry2 :
                        entry1.getValue().entrySet()) {
                    System.out.println(entry2.getKey() + " " + entry2.getValue());
                    System.out.println();
                }
            }
        }
    }


}
