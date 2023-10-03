package fileIO;

import org.junit.jupiter.api.Test;

public class DecreaseInSalesTest {

    //! Falta assert
    @Test
    void test1(){
        DecreaseInSales decreaseInSales = new DecreaseInSales();
        decreaseInSales.getData("C://Users//Diogo//Documents//ESINF//ev_sales.csv");
        decreaseInSales.print();
    }
}
