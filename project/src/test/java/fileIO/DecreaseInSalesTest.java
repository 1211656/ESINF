package fileIO;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DecreaseInSalesTest {

    //! Falta assert
    @Test
    void test1() throws IOException {
        DecreaseInSales decreaseInSales = new DecreaseInSales();
        decreaseInSales.getData();
        decreaseInSales.print();
    }
}
