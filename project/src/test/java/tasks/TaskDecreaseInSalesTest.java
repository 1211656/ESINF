package tasks;

import domain.Country;
import org.junit.jupiter.api.Test;
import structures.StructureDecreaseInSales;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskDecreaseInSalesTest {

    StructureDecreaseInSales structure;


    TaskDecreaseInSalesTest() throws IOException {
        structure = new StructureDecreaseInSales();
    }

    @Test
    void testAddLine() {
        TaskDecreaseInSales task = new TaskDecreaseInSales();

        Map<Country, Map<Integer[], Map<String, Integer>>> map = new HashMap<>();
        String[] line = {"Country1", "Powertrain1", "2022", "10"};
        int firstYear = 2022;
        int salesVariation = 10;

        task.addLine(line, firstYear, salesVariation, map);

        assertTrue(map.containsKey(new Country("Country1")));

        Map<Integer[], Map<String, Integer>> countryData = map.get(new Country("Country1"));
        assertTrue(countryData.containsKey(new Integer[]{2022, 10}));

        Map<String, Integer> powertrainData = countryData.get(new Integer[]{2022, 10});
        assertTrue(powertrainData.containsKey("Powertrain1"));
        assertEquals(10, powertrainData.get("Powertrain1"));
    }


    @Test
    void print() {
    }

}