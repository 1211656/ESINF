package repositories;

import domain.Sale;

import java.util.ArrayList;
import java.util.List;

public class Repositories {

    private static List<Sale> salesList = new ArrayList<>();

    public Repositories(){

    }

    public static List<Sale> getSalesList() {
        return salesList;
    }
}
