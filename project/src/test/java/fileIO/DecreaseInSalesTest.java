package fileIO;

import domain.Country;
import domain.YearPair;
import org.apache.poi.hssf.record.InterfaceHdrRecord;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecreaseInSalesTest {

    //Make more tests
    @Test
    void test1(){
        Map<Country, Map<YearPair, Map<String, Integer>>> decreasedYearlySalesByCountry, expectedResults;
        DecreaseInSales decreaseInSales = new DecreaseInSales();
        decreasedYearlySalesByCountry = decreaseInSales.getData("C://Users//Diogo//Documents//ESINF//project//src//test//testFiles//decreaseSalesTest.csv");
        expectedResults = new TreeMap<>();
        decreaseInSales.print();
        populateExpectedResultsTest1(expectedResults);
        assertEquals(decreasedYearlySalesByCountry, expectedResults);
    }
/*
    @Test
    void testInutil(){
        DecreaseInSales decreaseInSales = new DecreaseInSales();
        decreaseInSales.getData("C://Users//Diogo//Documents//ESINF//project//src//test//testFiles//decreaseSalesTest.csv");
        decreaseInSales.print();
    }
*/
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
}
