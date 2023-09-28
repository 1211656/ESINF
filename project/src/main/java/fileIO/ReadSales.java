package fileIO;

import domain.Sale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadSales{
    public ReadSales(File file){

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            br.readLine();
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(","); // Divide a linha em campos usando ponto e vírgula como delimitador
                Sale.createSale(campos[0],campos[1],campos[2],campos[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
