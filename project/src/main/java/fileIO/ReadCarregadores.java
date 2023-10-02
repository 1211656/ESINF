package fileIO;

import java.io.*;

public class ReadCarregadores {

    public String[][] readFile(File file) throws IOException{
        String[] campos = null;
        String[][] res = new String[5000][11];


        try{

            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha ;
            br.readLine();

            while((linha = br.readLine())!=null){
                campos = CarregadoresCidade.splitCSVLine(linha);
            }




        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

}
