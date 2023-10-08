package utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsFileTest {

    File FileTest = new File("../teste.csv");

    @Test
    void splitCSVLine() {
        String line = "País,Cidade,\"Rua de x, porta 42\",50";
        String[] campos = UtilsFile.splitCSVLine(line);

        assertArrayEquals(new String[]{"País", "Cidade", "Rua de x, porta 42", "50"}, campos);
    }

    @Test
    void getNumberLinesOfFile() throws IOException {
        int numLines = UtilsFile.getNumberLinesOfFile(FileTest);
        assertEquals(2, numLines);
    }

    @Test
    void getNumberOfColumnsFile() throws IOException {
        int numColumns = UtilsFile.getNumberOfColumnsFile(FileTest);
        assertEquals(11, numColumns);
    }

}