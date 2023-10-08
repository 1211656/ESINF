package structures;

import domain.Country;
import domain.YearPair;
import fileIO.Files;
import tasks.TaskDecreaseInSales;
import utils.UtilsFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class StructureDecreaseInSales implements Files {

    private Map<Country, Map<YearPair, Map<String, Integer>>> map;
    private String[][] data;
    private TaskDecreaseInSales task;

    public StructureDecreaseInSales(File file) throws IOException {
        this.map = new TreeMap<>();
        task = new TaskDecreaseInSales();
        data = UtilsFile.readFileToArraySale(file);
        getData();
    }

    public void getData() {
            for (String[] line : data) {
                if (line[0] == null) {
                    break;
                }

                for (String[] lineAux : data) {
                    if (lineAux[0] == null) {
                        break;
                    }

                    if (line[0].equals(lineAux[0]) && Integer.parseInt(line[2]) < Integer.parseInt(lineAux[2]) && line[1].equals(lineAux[1]) && Integer.parseInt(line[3]) > Integer.parseInt(lineAux[3])) {
                        int salesVariation = Integer.parseInt(line[3]) - Integer.parseInt(lineAux[3]);
                        task.addLine(lineAux, Integer.parseInt(line[2]), salesVariation, map);
                    }
                }
            }

    }

    public Map<Country, Map<YearPair, Map<String, Integer>>> getMap() {
        return map;
    }


}
