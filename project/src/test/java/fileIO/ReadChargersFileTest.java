package fileIO;

import domain.Supercharger;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReadChargersFileTest {
    @Test
    public void testReadChargersFile() {
        List<Supercharger> csvData = ReadChargersFile.getDataFromFile("C://Users//Diogo//Documents//ESINF//testChargers.csv");
        printCSVData(csvData);
    }

    public static void printCSVData(List<Supercharger> csvData) {
        for (Supercharger row : csvData) {
                //System.out.print(row.getAddress() + "::" + row.getDescription() + "::" + row.getStalls() + "\t"); // Assuming tab ('\t') as a delimiter for column separation
            System.out.println(); // Move to the next line for the next row
        }
    }
}
