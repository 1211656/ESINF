package structures;

import domain.Country;
import domain.Gps;
import fileIO.Files;
import fileIO.ReadCarregadores;
import fileIO.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

class StructureWithMinAutonomyTest implements Files {


    private StructureWithMinAutonomy structureWithMinAutonomy;
    private SortedMap<Country,String> map ;
    @Test
    void generate() throws IOException {

        // guarda a matriz dos dados
        LinkedHashMap<Gps,Country> res  = ReadCarregadores.readFile(Teste);
        System.out.println("Keys    ->     Values");
        for(SortedMap.Entry<Gps,Country> entry : res.entrySet()){
            System.out.printf("%.5f , %.5f -> %s\n", entry.getKey().getLatitude(),entry.getKey().getLongitude(), entry.getValue());
        }





    }

}