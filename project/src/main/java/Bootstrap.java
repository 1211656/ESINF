import fileIO.Files;
import utils.UtilsFile;

import java.io.IOException;

public class Bootstrap implements Files {

    public String[][] matrizSales;
    public String[][] matrizChargers;

    public Bootstrap()throws IOException {
        matrizChargers = UtilsFile.readFileToArray(CarregadoresFile);
        matrizSales = UtilsFile.readFileToArraySale(SalesFile);
    }
}
