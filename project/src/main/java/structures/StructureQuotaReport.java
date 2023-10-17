package structures;

import domain.Country;
import domain.Sale;
import domain.Supercharger;
import fileIO.Files;
import tasks.TaskChargerClusterByPOI;
import tasks.TaskQuotaReport;
import utils.Bootstrap;
import utils.UtilsFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructureQuotaReport implements Files {
    private int ratio;
    private String fileSales;
    private String fileSuperchargers;
    private List<Sale> saleList;
    private List<Supercharger> superchargerList;
    private Map<Country, Integer> stallsData;
    private Map<Country, Integer> vehiclesData;
    private Map<Country, Map<List<Integer>, Double>> quotaDataByCountry;
    private Map<Country, Double> quotaData;
    private String[][] data ;
    private TaskQuotaReport task;
    private TaskChargerClusterByPOI taskChargerClusterByPOI;
    private Bootstrap bootstrap;

    public StructureQuotaReport(Bootstrap bootstrap) throws IOException {
        this.bootstrap = bootstrap;
        data = bootstrap.getMatrizQuota();
        task = new TaskQuotaReport();
        saleList = task.getDataFromFile(bootstrap.getMatrizQuotaSales());
        superchargerList = taskChargerClusterByPOI.getDataFromFile(data);
    }

    public Map<Country, Map<List<Integer>, Double>> getYearlyQuotaByCountry(int year){
        task.getQuotaData(year,quotaData,stallsData,vehiclesData,ratio,saleList,superchargerList);
        quotaDataByCountry = new HashMap<>();
        for (Country country :
                quotaData.keySet()) {
            Map<List<Integer>, Double> aux = new HashMap<>();
            aux.put(Arrays.asList(stallsData.get(country), vehiclesData.get(country)), quotaData.get(country));
            quotaDataByCountry.put(country, aux);
        }
        return quotaDataByCountry;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
}
