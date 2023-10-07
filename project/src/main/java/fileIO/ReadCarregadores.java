package fileIO;

import domain.Country;
import domain.Gps;
import utils.UtilsFile;

import java.io.*;
import java.util.*;

public class ReadCarregadores {

    /**
     *
     * @param file
     * @return map where the information of a gps and country are encountered from the chargers file
     * @throws IOException
     */
    public static LinkedHashMap<Gps,Country> readFile(File file) throws IOException{
        String[] campos = null;
        LinkedHashMap<Gps,Country> res = new LinkedHashMap<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha ;
            br.readLine();

            while((linha = br.readLine())!=null&&!linha.equals("")){
                campos = UtilsFile.splitCSVLine(linha);

                try{
                    Country country = new Country(campos[6].trim());
                    Double[] arrGPS = Gps.stringToDoubleGPS(campos[9]);
                    Gps gps = new Gps(arrGPS[0],arrGPS[1]);
                    res.put(gps,country);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return  res;

    }





}
