package fileIO;

import domain.Country;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadSalesTest implements Files{


    Map<Country, Double> map ;
    ReadSales readSales = new ReadSales();




    @Test
    void getEvolutionNumberVehicles() {
        map = readSales.getEvolutionNumberVehicles(2019,2020);
        for (Map.Entry<Country,Double> entry : map.entrySet()){
            assertEquals(entry.getKey().toString(),"Australia");
            assertEquals(entry.getValue(),-0.25);
        }

    }

    @Test
    void getEvolutionNumberVehiclesNoYearsFound(){
        map = readSales.getEvolutionNumberVehicles(0,0);
        boolean expected = true;
        assertEquals(expected,map.isEmpty());

        SortedMap<String,Integer> linked = new TreeMap<>();
        linked.put("tarefa1",2);
        linked.put("tarefa2",1);
        linked.put("tarefa3",3);
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(linked.get(o2),linked.get(o1));
            }

        };
        SortedMap<String,Integer> linkedOrdenada = new TreeMap<>(comparator);
        linkedOrdenada.putAll(linked);

        for(Map.Entry<String,Integer> entry : linkedOrdenada.entrySet()){
            System.out.printf("%s -> %d\n",entry.getKey(), entry.getValue());

        }
    }


}