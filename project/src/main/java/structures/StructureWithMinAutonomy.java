package structures;

import domain.Country;
import domain.Gps;
import fileIO.Files;
import tasks.TaskMinAutonomy;
import utils.Bootstrap;

import java.io.IOException;
import java.util.*;

public class StructureWithMinAutonomy implements Files {


    // matriz que contem os dados do ficheiro
    private Map<Gps,Country> mapGeneral;


    private SortedMap<Gps,Country> sortedMap;
    private String[][] data;
    private TaskMinAutonomy task;

    public StructureWithMinAutonomy(Bootstrap bootstrap) throws IOException {
        bootstrap = new Bootstrap();
        data = bootstrap.getMatrizChargers();
        task = new TaskMinAutonomy();
        mapGeneral = new HashMap<>();
        allocateObjects(data);

    }

    public TaskMinAutonomy getTask() {
        return task;
    }

    public Map<Gps,Country> getMapGeneral() {
        return mapGeneral;
    }

    public void allocateObjects(String[][] data){
        for(int i = 0; i < data.length; i++){
            String[] campos = data[i];
            String[] gpsArr = campos[9].split(",");
            mapGeneral.put(new Gps(Double.parseDouble(gpsArr[0].trim()),Double.parseDouble(gpsArr[1].trim())),new Country(campos[6]));
        }
    }

    //final map
    public LinkedHashMap<Country,Double> getFinalMap(){
        LinkedHashMap<Country,Double> finalMap = new LinkedHashMap<>();
        for (Map.Entry<Gps,Country> entry : mapGeneral.entrySet()) {
            if (!task.findKeyInMapByString(entry.getValue().toString(),finalMap)) {
                Map<Gps, Country> countryMap = task.getMapByCountry(entry.getValue(), mapGeneral);
                List<Gps> gpsList = task.getListOfGpsByMapCountry(countryMap);
                finalMap.put(entry.getValue(), task.getHighestDistanceBetweenChargersInCountry(gpsList));
            }

        }
        return finalMap;
    }

    public LinkedHashMap<Country,Double> ordenateMap2(LinkedHashMap<Country,Double> sortedMap){
        List<Map.Entry<Country,Double>> listaEntradas = new ArrayList<>(sortedMap.entrySet());
        Collections.sort(listaEntradas,(entry1, entry2) -> {
            int comparacaoPorValor = Double.compare(entry2.getValue(),entry1.getValue());
            if(comparacaoPorValor==0){
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return comparacaoPorValor;
        });
        LinkedHashMap<Country, Double> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<Country, Double> entry : listaEntradas) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }
        return mapaOrdenado;
    }





















}
