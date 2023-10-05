package fileIO;

import domain.Supercharger;

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

                superchargerList.add(new Supercharger(row[5].trim(), row[3].trim(), row[2].trim(), row[1].trim(), row[4].trim(), row[6].trim(), row[7].trim(), row[9].trim(), row[8].trim(), row[0].trim(), row[10].trim()));
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return superchargerList;
    }
}

/*
public Supercharger(String countryName, String stateName, String cityName, String streetAddress, String zipCode, Stalls stalls, PowerKw powerKw, Elevm elevm, String gpsCoordinates, String description) {
        this.address = new Address(countryName,stateName,cityName,streetAddress,zipCode, gpsCoordinates);
        this.stalls = stalls;
        this.powerKw = powerKw;
        this.elevm = elevm;
        this.description = description;
    }
 */