package tasks;

import domain.Country;
import domain.State;
import domain.Supercharger;
import org.junit.jupiter.api.Test;
import structures.StructureStockCapacity;
import utils.Bootstrap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskStockCapacityTest {

    StructureStockCapacity structure;
    List<Country> countryList;
    List<State> stateList;

    public TaskStockCapacityTest(Bootstrap bootstrap) throws IOException {
        structure = new StructureStockCapacity(bootstrap);
        countryList = new ArrayList<>();
        stateList = new ArrayList<>();
    }

    @Test
    void getListSuperChargerByCountries() {

        countryList.add(new Country("Portugal"));
        countryList.add(new Country("Sweden"));

        structure.getTask().printList(structure.getTask().buscarSuperChargersComMaisCapacidadeArmazenamento(structure.getTask().getListSuperChargerByCountries(countryList,structure.getSuperchargerList()),3));


    }

    @Test
    void buscarSuperChargersComMaisCapacidadeArmazenamento() {

    }

    @Test
    void removeElementsUntilN() {

    }

    @Test
    void allocateObjects() {
        stateList.add(new State("Estado1"));
        stateList.add(new State("Estado2"));
        stateList.add(new State("Estado3"));

        structure.getTask().printMap(structure.fulfill(structure.getTask().buscarSuperChargersComMaisCapacidadeArmazenamento(structure.getTask().getListSuperChargerByState(stateList,structure.getSuperchargerList()),2)));
    }

    @Test
    void getListSuperChargerByState() {
        stateList.add(new State("Estado1"));
        stateList.add(new State("Estado2"));
        stateList.add(new State("Estado3"));
        structure.getTask().getListSuperChargerByState(stateList,structure.getSuperchargerList());
    }
}