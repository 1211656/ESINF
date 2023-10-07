package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilsFile {
    /**
     * Função que divide a linha em campos usando a vírgula como delimitador, ignorando as vírgulas dentro de aspas.
     * @param line
     * @return array de strings com os campos do CSV dos carregadores
     */
    public static String[] splitCSVLine(String line) {
        List<String> campos = new ArrayList<>();
        StringBuilder campoAtual = new StringBuilder();
        boolean verificaAspas = false;

        // Percorre a linha
        for (char c : line.toCharArray()) {
            // Se encontrar aspas, inverte o valor da variável verificaAspas
            if (c == '"') {
                verificaAspas = !verificaAspas;
            } else if (c == ',' && !verificaAspas) {
                campos.add(campoAtual.toString().trim());
                campoAtual.setLength(0);
            } else {
                campoAtual.append(c);
            }
        }

        campos.add(campoAtual.toString().trim());

        return campos.toArray(new String[0]);
    }

    /**
     * @param file
     * @return number of lines in a file
     * @throws IOException
     */
    public static int getNumberLinesOfFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        int contadorLinhas = 0;
        br.readLine();
        while( br.readLine()!=null){
            contadorLinhas ++;
        }
        return contadorLinhas-1;
    }

    /**
     * @param file
     * @return number of columns file
     * @throws IOException
     */
    public static int getNumberOfColumnsFile(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        int contadorColunas = 0;
        String[] campos;
        br.readLine();
        String linha;
        while( ( linha =br.readLine())!=null){
            campos = UtilsFile.splitCSVLine(linha);
            if(contadorColunas< campos.length){
                contadorColunas = campos.length;
            }
        }
        return contadorColunas;
    }

    /**
     *
     * @param file
     * @return matriz de dados que recebe do ficheiro CSV Carregadores
     * @throws IOException
     */
    public static String[][] readFileToArray(File file)throws IOException{
        String[] campos = null;
        String[][] res = new String[getNumberLinesOfFile(file)][getNumberOfColumnsFile(file)];
        boolean sair = false;
        while(sair == false){
            try{
                int index = 0;
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linha;
                br.readLine();

                while((linha = br.readLine())!=null&&!linha.equals("")){
                    campos = UtilsFile.splitCSVLine(linha);
                    res[index] = campos;
                    index ++;
                }

                sair = true;


            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * @param file
     * @return matriz dos dados que recebe do ficheiro CSV Sales
     * @throws IOException
     */
    public static String[][] readFileToArraySale(File file)throws IOException{
        String[][] res = new String[getNumberLinesOfFile(file)][getNumberOfColumnsFile(file)];
        boolean sair = false;
        String[] campos = null;
        while(sair == false){
            try{
                int index = 0;
                BufferedReader br = new BufferedReader(new FileReader(file));

                String linha;
                br.readLine();
                while((linha = br.readLine())!=null&&!linha.equals("")){
                    campos = linha.split(",");
                    res[index] = campos;
                    index ++;
                }

                sair = true;

            }catch (FileNotFoundException e) {e.printStackTrace();}
        }
        return res;
    }
}
