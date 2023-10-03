package fileIO;

import com.sun.source.tree.Tree;
import domain.Country;
import domain.Gps;
import org.apache.poi.ss.formula.functions.T;
import utils.Utils;

import java.io.*;
import java.util.*;

public class ReadCarregadores {

    // get a map where the information of a gps and country are encountered from the chargers file
    public static LinkedHashMap<Gps,Country> readFile(File file) throws IOException{
        String[] campos = null;
        LinkedHashMap<Gps,Country> res = new LinkedHashMap<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha ;
            br.readLine();

            while((linha = br.readLine())!=null){
                campos = CarregadoresCidade.splitCSVLine(linha);

                try{
                    Country country = new Country(campos[6].trim());
                    Double[] arrGPS = Utils.stringToDoubleGPS(campos[9]);
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
