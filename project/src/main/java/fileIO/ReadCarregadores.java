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
    public static LinkedHashMap<Gps,Country> readFile(String[][] matriz) throws IOException{
        String[] campos = null;
        LinkedHashMap<Gps,Country> res = new LinkedHashMap<>();
        for (int i = 0; i < matriz.length; i++) {
            Country country = new Country(matriz[i][6].trim());
            Double[] arrGPS = Gps.stringToDoubleGPS(matriz[i][9]);
            //Gps gps = new Gps(matriz[i][9]);
        }
        Country country = new Country(campos[6].trim());
        Double[] arrGPS = Gps.stringToDoubleGPS(campos[9]);
        Gps gps = new Gps(arrGPS[0],arrGPS[1]);
        res.put(gps,country);


        return  res;

    }





}
