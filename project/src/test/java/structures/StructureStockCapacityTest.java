package structures;

import domain.City;
import domain.State;
import org.junit.jupiter.api.Test;
import utils.Bootstrap;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StructureStockCapacityTest {

    Bootstrap bootstrap;

    StructureStockCapacity structure;

    Map<LinkedHashMap<State, List<City>>,Integer> map;

    public StructureStockCapacityTest() throws IOException {
        bootstrap = new Bootstrap();
        structure = new StructureStockCapacity(bootstrap);
        map = structure.getMap();
    }

    @Test
    void generate(){
        for(Map.Entry<LinkedHashMap<State,List<City>>,Integer> entry : map.entrySet()){
            System.out.printf("Capacity: %d kw\n",entry.getValue());
            for(Map.Entry<State,List<City>> entry1 : entry.getKey().entrySet()){
                System.out.printf("%s\n",entry1.getKey());
                for(int i = 0; i < entry1.getValue().size(); i++){
                    System.out.printf("%s\n",entry1.getValue().get(i));
                }
            }
        }
    }


}
