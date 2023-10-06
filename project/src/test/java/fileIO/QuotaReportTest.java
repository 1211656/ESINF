package fileIO;

import domain.Country;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class QuotaReportTest {
    Map<Country, Map<List<Integer>, Double>> quotaDataByCountry;
    @Test
    public void testQuotaReport() {

        QuotaReport quotaReport = new QuotaReport();
        quotaReport.defineFiles("C://Users//Diogo//Documents//ESINF//testeSales.csv", "C://Users//Diogo//Documents//ESINF//testChargers.csv");
        quotaReport.defineRatio(10);
        quotaDataByCountry = quotaReport.getYearlyQuotaByCountry(2011);
        printQuotaDataByCountry();
    }
    private void printQuotaDataByCountry() {
        for (Map.Entry<Country, Map<List<Integer>, Double>> entry : quotaDataByCountry.entrySet()) {
            Country country = entry.getKey();
            Map<List<Integer>, Double> data = entry.getValue();

            System.out.println("Country: " + country.getName());
            for (Map.Entry<List<Integer>, Double> innerEntry : data.entrySet()) {
                List<Integer> key = innerEntry.getKey();
                Double value = innerEntry.getValue();

                System.out.println("Key: " + key);
                System.out.println("Value: " + value);
            }
            System.out.println(); // Separate entries for readability
        }
    }
}
