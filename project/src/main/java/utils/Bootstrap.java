package utils;

import fileIO.Files;
import tasks.TaskChargerClusterByPOI;
import utils.UtilsFile;

import java.io.IOException;

public class Bootstrap implements Files {

    private  String[][] matrizSales;
    private String[][] matrizChargers;
    private String[][] matrizChargersClusterByPOI;

    private String[][] matrizDecreaseInSalesTest;
    private String[][] matrizQuota;

    public Bootstrap() throws IOException {
        matrizChargers = UtilsFile.readFileToArray(TesteCarregadores);
        matrizSales = UtilsFile.readFileToArraySale(SalesFile);
        matrizChargersClusterByPOI = UtilsFile.readFileToArray(testeClusterByPOI);
        matrizDecreaseInSalesTest = UtilsFile.readFileToArraySale(DecreaseInSalesFile);
        matrizQuota = UtilsFile.readFileToArray(TesteCarregadores);
    }

    public String[][] getMatrizChargers() {
        return matrizChargers;
    }

    public String[][] getMatrizQuota() {
        return matrizQuota;
    }

    public String[][] getMatrizDecreaseInSalesTest() {
        return matrizDecreaseInSalesTest;
    }

    public String[][] getMatrizChargersClusterByPOI() {
        return matrizChargersClusterByPOI;
    }

    public String[][] getMatrizSales() {
        return matrizSales;
    }
}
