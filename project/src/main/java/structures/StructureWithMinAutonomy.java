package structures;

import domain.Country;
import domain.Gps;
import fileIO.Files;
import fileIO.ReadFile;
import org.apache.commons.collections4.list.TreeList;
import org.apache.poi.ss.formula.functions.Count;

import java.util.*;

public class StructureWithMinAutonomy implements Files {


    // matriz que contem os dados do ficheiro
    private Map<Gps,Country> mapGeneral;


    private SortedMap<Gps,Country> listCountry;

    public StructureWithMinAutonomy(Map<Gps,Country> mapGeneral){
        this.mapGeneral = mapGeneral;
    }

    public Map<Gps,Country> getMapGeneral() {
        return mapGeneral;
    }

    private Map<Gps,Country> getMapByCountry(Country country){
        SortedMap<Gps,Country> mapCountry = new TreeMap<>();

        for(Map.Entry<Gps,Country> entry : mapGeneral.entrySet()){
            if(entry.getValue().equals(country)){
                mapCountry.put(entry.getKey(),entry.getValue());
            }
        }
        return mapCountry;
    }







}
