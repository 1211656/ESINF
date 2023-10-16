package structures;

import domain.Country;
import domain.Sale;
import org.junit.jupiter.api.Test;
import utils.Bootstrap;

import java.io.IOException;
import java.util.Map;

public class StructureEvolutionNumberVehiclesTest {

    Bootstrap bootstrap;
    StructureEvolutionNumberVehicles structure;

    Map<Country,Double> map;


    public StructureEvolutionNumberVehiclesTest() throws IOException {
        bootstrap = new Bootstrap();
        structure = new StructureEvolutionNumberVehicles(bootstrap);
        map = structure.getEvolutionNumberVehicles(2015,1017);
    }

    @Test
    void generate(){
        for(Map.Entry<Country,Double> entry : map.entrySet()){
            System.out.printf("Country : %s -> Oscilação entre o número de veículos: %.2f\n",entry.getKey(),entry.getValue());
        }
    }
}
