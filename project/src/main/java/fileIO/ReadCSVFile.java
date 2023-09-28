package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile{
    public static void readCSVFile(File file){

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(","); // Divide a linha em campos usando ponto e vírgula como delimitador
                for (String campo : campos) {
                    System.out.print(campo + " \t"); // Imprime cada campo, separado por uma guia (ou outro caractere de sua escolha)
                }
                System.out.println(); // Quebra de linha após cada linha do CSV
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
