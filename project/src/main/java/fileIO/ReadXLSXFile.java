package fileIO;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;



public class ReadXLSXFile implements Files{




    public static void readXLSXFile(){
        try {
            // Carregue o arquivo Excel
            FileInputStream arquivo = new FileInputStream(XLSXfile);

            // Crie uma instância de Workbook
            Workbook workbook = new XSSFWorkbook(arquivo);

            // Obtenha a primeira planilha
            Sheet sheet = workbook.getSheetAt(0);

            // Itere pelas linhas da planilha
            for (Row row : sheet) {
                // Itere pelas células de cada linha
                for (Cell cell : row) {
                    // Dependendo do tipo de dado na célula, você pode lê-lo de diferentes maneiras
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println(); // Quebra de linha após cada linha da planilha
            }

            // Feche o arquivo
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
