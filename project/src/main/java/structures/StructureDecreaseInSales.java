package structures;

import domain.Country;
import fileIO.Files;
import tasks.TaskDecreaseInSales;
import utils.UtilsFile;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class StructureDecreaseInSales implements Files {

    private Map<Country, Map<Integer[], Map<String, Integer>>> map;
    private String[][] data;
    private TaskDecreaseInSales task;

    public StructureDecreaseInSales() throws IOException {
        this.map = new TreeMap<>();
        task = new TaskDecreaseInSales();
        data = UtilsFile.readFileToArraySale(SalesFile);
        getData();
    }

    public void getData(){
        int firstYear = 0;
        int firstYearSales = 0;
        for (String[] line :
                data) {
            if(line[0] == null){
                break;
            } else {
                if (firstYear < Integer.parseInt(line[2]) && firstYearSales > Integer.parseInt(line[3])){
                    task.addLine(line, firstYear, firstYearSales- Integer.parseInt(line[3]),map);
                }

                firstYear = Integer.parseInt(line[2]);
                firstYearSales = Integer.parseInt(line[3]);
            }
        }
    }


}
