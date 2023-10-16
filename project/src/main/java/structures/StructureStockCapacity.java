package structures;

import java.io.IOException;
import java.util.*;


import com.graphbuilder.math.FuncNode;
import domain.*;
import fileIO.Files;
import tasks.TaskStockCapacity;
import utils.Bootstrap;
import utils.UtilsFile;

/**
 * Classe serve para guardar a estrutura do exercício 8
 */
public class StructureStockCapacity implements Files {

    //capacidade de carregamento é o somatório do nº de
    //postos (Stalls) x potência (kW) de cada um dos Supercharger cujo Status é “Open”
    /**
     * atributos de objeto
     */
    private List<Supercharger> list;
    private Map<LinkedHashMap<State,List<City>>,Integer> map;
    private String[][] data;
    private List<Supercharger> superchargerList;
    private TaskStockCapacity task;
    private Bootstrap bootstrap;

    /**
     * Construtor de objeto
     * @throws IOException
     */
    public StructureStockCapacity(Bootstrap btsrap)throws IOException {
        bootstrap =btsrap;
        task = new TaskStockCapacity();
        list = new ArrayList<>();
        superchargerList = new ArrayList<>();
        data = btsrap.getMatrizChargers();
        task.allocateObjects(data,superchargerList);
        map = fulfill(superchargerList);

    }

    /**
     * @return superchargersList
     */
    public List<Supercharger> getSuperchargerList() {
        return superchargerList;
    }

    /**
     * @return task
     */
    public TaskStockCapacity getTask() {
        return task;
    }

    /**
     * @return map
     */
    public Map<LinkedHashMap<State,List<City>>, Integer> getMap() {
        return map;
    }

    /**
     * @param superchargers
     * @return structure of ex8
     */
    public Map<LinkedHashMap<State,List<City>>,Integer> fulfill(List<Supercharger> superchargers){
        Map<LinkedHashMap<State,List<City>>,Integer> ret = new HashMap<>();
        LinkedHashMap<State,List<City>> map1 = new LinkedHashMap<>();

        List<State> states = new ArrayList<>();
        for (int i = 0; i < superchargers.size(); i++) {
            if(!states.contains(superchargers.get(i).getAddress().getState())){
                map1.put(superchargers.get(i).getAddress().getState(),task.getListCityByState(superchargers.get(i).getAddress().getState(),superchargers));
                states.add(superchargers.get(i).getAddress().getState());
            }
        }
        ret.put(map1,task.getAcumulatedCapacity(superchargers));
        return ret;
    }
}
