package structures;

import domain.Country;
import domain.YearPair;
import fileIO.Files;
import org.junit.jupiter.api.Test;
import utils.Bootstrap;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructureDecreaseInSalesTest implements Files {

    Bootstrap bootstrap;

    StructureDecreaseInSales structure;
    Map<Country, Map<YearPair, Map<String, Integer>>> map;

    public StructureDecreaseInSalesTest() throws IOException {
        bootstrap = new Bootstrap();
        structure = new StructureDecreaseInSales(bootstrap);
        map = structure.getMap();


    }

    @Test
    void generate(){
        for(Map.Entry<Country, Map<YearPair, Map<String, Integer>>> entry : map.entrySet()){
            System.out.printf("Country : %s\n", entry.getKey());
            System.out.println("--------------------------");
            for(Map.Entry<YearPair, Map<String, Integer>> entry1 : entry.getValue().entrySet()){
                System.out.printf("Year Pair: %s\n",entry1.getKey());
                for(Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()){
                    System.out.printf("%s  ->  %d\n", entry2.getKey(),entry2.getValue());
                }
            }
        }
    }

    @Test
    void test1() throws IOException {
        Map<Country, Map<YearPair, Map<String, Integer>>> decreasedYearlySalesByCountry, expectedResults;

        structure.getData();
        decreasedYearlySalesByCountry = structure.getMap();
        expectedResults = new TreeMap<>();
        populateExpectedResultsTest1(expectedResults);
        assertEquals(decreasedYearlySalesByCountry, expectedResults);
    }

    @Test
    void testSaleFile() throws IOException {
        Map<Country, Map<YearPair, Map<String, Integer>>> decreasedYearlySalesByCountry, expectedResults;
        StructureDecreaseInSales decreaseInSales = new StructureDecreaseInSales(bootstrap);
        decreaseInSales.setData(bootstrap.getMatrizSales());

        decreaseInSales.getData();
        decreasedYearlySalesByCountry = decreaseInSales.getMap();
        print(decreasedYearlySalesByCountry);
    }

    private void populateExpectedResultsTest1 (Map<Country, Map<YearPair, Map<String, Integer>>> expectedResults){
        Country portugal = new Country("Portugal");
        Country spain = new Country("Spain");
        Country unitedKingdom = new Country("United Kingdom");
        Country netherlands = new Country("Netherlands");

        Map<String, Integer> portugalSales = new HashMap<>();
        portugalSales.put("BEV", -1);
        portugalSales.put("PHEV", -6);
        Map<String, Integer> spainSales = new HashMap<>();
        spainSales.put("BEV", -3);
        spainSales.put("PHEV", -3);
        Map<String, Integer> unitedKingdomSales = new HashMap<>();
        unitedKingdomSales.put("BEV", -3);
        unitedKingdomSales.put("PHEV", -8);
        Map<String, Integer> netherlandsSales = new HashMap<>();
        netherlandsSales.put("BEV", -4);
        netherlandsSales.put("PHEV", -4);

        Map<YearPair, Map<String, Integer>> portugalMap = new HashMap<>();
        portugalMap.put(new YearPair(2011, 2012), portugalSales);
        Map<YearPair, Map<String, Integer>> spainMap = new HashMap<>();
        spainMap.put(new YearPair(2011, 2012), spainSales);
        Map<YearPair, Map<String, Integer>> unitedKingdomMap = new HashMap<>();
        unitedKingdomMap.put(new YearPair(2011, 2012), unitedKingdomSales);
        Map<YearPair, Map<String, Integer>> netherlandsMap = new HashMap<>();
        netherlandsMap.put(new YearPair(2011, 2012), netherlandsSales);

        expectedResults.put(portugal, portugalMap);
        expectedResults.put(spain, spainMap);
        expectedResults.put(unitedKingdom, unitedKingdomMap);
        expectedResults.put(netherlands, netherlandsMap);
    }

    public void print(Map<Country, Map<YearPair, Map<String, Integer>>> map){
        for (Map.Entry<Country, Map<YearPair, Map<String, Integer>>> entry :
                map.entrySet()) {
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
