package utils;

import domain.Gps;

public class Utils {

    public static Double[] stringToDoubleGPS(String gps){
        Double[] res = new Double[2];
        String[] strings = gps.split(", ");
        int index = 0;
        for (String strings1 : strings) {
            res[index] = Double.parseDouble(strings1);
            index ++;
        }
        // "62.073923, 9.125562"
        return res;
    }
}
