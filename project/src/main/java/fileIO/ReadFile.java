package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    public static String[][] readFile(File file){
        String[] campos = null;
        String[][] res = new String[3000][4];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            br.readLine(); // Ignora a primeira linha


            while ((linha = br.readLine())!=null) {
                // Divide a linha em campos usando a vírgula como delimitador

                campos = linha.split(",");

                if(campos.length==4){
                    try{res[index][0] = campos[0];
                        res[index][1] = campos[1];
                        res[index][2] = campos[2];
                        res[index][3] = campos[3];
                        index ++;
                    }catch (Exception e){
                        System.out.println("e");
                    }
                }



            }



            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }




}
