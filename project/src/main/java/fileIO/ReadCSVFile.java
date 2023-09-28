package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile implements Files{
    public static void readCSVFile(){

        try (BufferedReader br = new BufferedReader(new FileReader(CSVfile))) {
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
