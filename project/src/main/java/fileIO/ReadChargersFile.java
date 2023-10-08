package fileIO;

import domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadChargersFile {

    public static List<Supercharger> getDataFromFile(String file){
        List<Supercharger> superchargerList = new ArrayList<>();
        try(BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
            csvReader.readLine();
            String line;

            while ((line = csvReader.readLine()) != null){
                String[] row = line.split(";");

                superchargerList.add(new Supercharger(row[5].trim(), row[3].trim(), row[2].trim(), row[1].trim(), row[4].trim(), new Stalls(Integer.parseInt(row[6].trim())), new PowerKw(Integer.parseInt(row[7].trim())), new Elevm(Integer.parseInt(row[9].trim())), Status.getStatus(row[10].trim()), row[8].trim()));
                /*                          5                 3                  2                  1
                public Supercharger(String countryName, String stateName, String cityName, String streetAddress,
                       4              6                7              9            10          8
                 String zipCode, Stalls stalls, PowerKw powerKw, Elevm elevm,Status status,String gps)
                    *  0            1         2     3   4     5      6    7   8    9    10
                 Supercharger;StreetAddress;City;State;Zip;Country;Stalls;kW;GPS;Elevm;Status
                 */
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return superchargerList;
    }
}