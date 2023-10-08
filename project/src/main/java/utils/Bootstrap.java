package utils;

import fileIO.Files;
import utils.UtilsFile;

import java.io.IOException;

public class Bootstrap implements Files {

    private  String[][] matrizSales;
    private String[][] matrizChargers;

    public Bootstrap() throws IOException {
        matrizChargers = UtilsFile.readFileToArray(TesteCarregadores);
        matrizSales = UtilsFile.readFileToArray(SalesFile);
    }

    public String[][] getMatrizChargers() {
        return matrizChargers;
    }

    public String[][] getMatrizSales() {
        return matrizSales;
    }
}
