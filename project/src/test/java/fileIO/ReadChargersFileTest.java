package fileIO;

import domain.Supercharger;
import org.junit.jupiter.api.Test;
import utils.UtilsFile;

import java.io.IOException;
import java.util.List;

public class ReadChargersFileTest implements Files{


    @Test
    public void testReadChargersFile() throws IOException {
        /**
        List<Supercharger> csvData = ReadChargersFile.getDataFromFile(UtilsFile.readFileToArray(TesteCarregadores));
        printCSVData(csvData);*/
    }

    public static void printCSVData(List<Supercharger> csvData) {
        for (Supercharger row : csvData) {
                System.out.print(row.getAddress().getCountry()); // Assuming tab ('\t') as a delimiter for column separation
            System.out.println(); // Move to the next line for the next row
        }
    }
}
