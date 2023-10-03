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


    private SortedMap<Gps,Country> sortedMap;

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


    // método que me dá uma lista com as coordenadas cuja distancia entre elas é maior
    private List<Gps> getHighestDistanceBetweenChargersInCountry(List<Gps> gpsList){
        Gps gps1 = null;
        Gps gps2 = null;
        double distancia=0;
        List<Gps> ret = new ArrayList<>();
        for (int i = 0; i < gpsList.size()-1; i++) {
            if(gpsList.get(i).getDistanceBetweenTwoChargers(gpsList.get(i+1))>distancia){
                distancia = gpsList.get(i).getDistanceBetweenTwoChargers(gpsList.get(i+1));
                gps1 = gpsList.get(i);
                gps2 = gpsList.get(i+1);
            }
        }
        ret.add(gps1);
        ret.add(gps2);
        return ret;
    }







}
