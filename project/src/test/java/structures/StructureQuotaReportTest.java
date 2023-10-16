package structures;

import domain.Country;
import org.junit.jupiter.api.Test;
import utils.Bootstrap;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StructureQuotaReportTest {

    Bootstrap bootstrap;
    StructureQuotaReport structure;
    Map<Country, Map<List<Integer>, Double>> getYearlyQuotaByCountry;

    public StructureQuotaReportTest() throws IOException {
        bootstrap = new Bootstrap();
        structure = new StructureQuotaReport(bootstrap);
        getYearlyQuotaByCountry = structure.getYearlyQuotaByCountry(2015);
    }

    @Test
    void generate(){
        for(Map.Entry<Country, Map<List<Integer>, Double>> entry : getYearlyQuotaByCountry.entrySet()){
            System.out.printf("Country: %s\n",entry.getKey());
            for(Map.Entry<List<Integer>, Double> entry1 : entry.getValue().entrySet()){
                for(int i = 0; i < entry1.getKey().size(); i++){
                    System.out.printf("year : %d\n",entry1.getKey().get(i));
                }
                System.out.printf("Quota is : %.2f\n\n\n", entry1.getValue());
            }
        }
    }
}
