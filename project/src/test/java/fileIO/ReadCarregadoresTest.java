package fileIO;

import org.junit.jupiter.api.Test;
import utils.UtilsFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadCarregadoresTest implements Files{

    @Test
    void readFile() {
    }

    @Test
    void readFileToArray() throws IOException {
        String[][] arr = UtilsFile.readFileToArray(Teste);

    }



    @Test
    void getNumberLinesOfFile() throws IOException{
        assertEquals(16,UtilsFile.getNumberLinesOfFile(Teste));
    }
    @Test
    void getNumberColumnsOfFile()throws IOException{
        assertEquals(12,UtilsFile.getNumberOfColumnsFile(Teste));
    }
}