package fileIO;

import domain.Sale;
import domain.Supercharger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSalesFile {
    public static List<Sale> getDataFromFile(String path){
        List<Sale> sales = new ArrayList<>();
        try(BufferedReader csvReader = new BufferedReader(new FileReader(path))) {
            csvReader.readLine();
            String line;

            while ((line = csvReader.readLine()) != null){
                String[] row = line.split(";");

                sales.add(new Sale(row[1].trim(), row[0].trim(), row[2].trim(), row[3].trim()));
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sales;
    }
}