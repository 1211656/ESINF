package fileIO;

import org.junit.jupiter.api.Test;


class ReadCSVFileTest implements Files{



    @Test
    void readCSVFile() {
        new ReadCSVFile(CarregadoresFile);
    }
}