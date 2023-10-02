package structures;

import domain.Country;
import fileIO.Files;
import fileIO.ReadFile;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class StructureWithMinAutonomyTest implements Files {


    private StructureWithMinAutonomy structureWithMinAutonomy;
    private SortedMap<Country,String> map ;
    @Test
    void generate(){

        // guarda a matriz dos dados
        structureWithMinAutonomy = new StructureWithMinAutonomy(ReadFile.readFile(Teste));
        map = structureWithMinAutonomy.getMap();

        for(Map.Entry<Country,String> entry : map.entrySet()){
            System.out.printf("%s -> %s\n",entry.getKey(),entry.getValue());
        }


    }

}