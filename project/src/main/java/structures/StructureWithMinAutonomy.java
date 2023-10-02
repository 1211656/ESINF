package structures;

import domain.Country;
import fileIO.Files;
import fileIO.ReadFile;
import org.apache.poi.ss.formula.functions.Count;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class StructureWithMinAutonomy implements Files {


    // matriz que contem os dados do ficheiro
    private String[][] matriz;
    private SortedMap<Country,String> map = new TreeMap<>();
    public StructureWithMinAutonomy(String[][] matriz){
        this.matriz = matriz;
        map = allocateObjectsThatAreInMatrix();
    }

    public SortedMap<Country, String> getMap() {
        return map;
    }

    //allocates the Objects (creating them using the string that ar in the matrix), using a sortedMap to sort alphabetically or descendent
    private SortedMap<Country,String> allocateObjectsThatAreInMatrix(){
        int stay = 0;
        while (stay==0){
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][6] == null) {
                    stay = -1;

                }
                else{
                    System.out.println(matriz[i][6]);
                    map.put(new Country(matriz[i][6]), matriz[i][9] + matriz[i][10]);
                }
            }

        }
        return map;
    }


}
