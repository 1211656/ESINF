package tasks;

import domain.*;

import java.util.*;

/**
 * Classe que serve para atribuir a estrutura pretendida à classe StructureStockCapacity
 */
public class TaskStockCapacity {
    /**
     * Construtor
     */
    public TaskStockCapacity(){

    }

    /**
     * @param countries
     * @param superchargerList
     * @return lista de superchargers que é filtrada por país
     */
    public List<Supercharger> getListSuperChargerByCountries(List<Country> countries,List<Supercharger> superchargerList){
        List<Supercharger> superchargers = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            for (int j = 0; j < superchargerList.size(); j++) {
                if(superchargerList.get(j).getAddress().getCountry().equals(countries.get(i))){
                    superchargers.add(superchargerList.get(j));
                }
            }
        }
        return superchargers;

    }

    /**
     * @param superchargers
     * @param n
     * @return lista de superchargers com mais capacidade de armazenamento
     */
    public List<Supercharger> buscarSuperChargersComMaisCapacidadeArmazenamento(List<Supercharger> superchargers, int n) {
        Comparator<Supercharger> comparator = (o1, o2) -> Integer.compare(o2.getCapacidadeArmazenamento(), o1.getCapacidadeArmazenamento());
        Collections.sort(superchargers, comparator);
        return removeElementsUntilN(n,superchargers);
    }

    /**
     * @param n
     * @param arrayList
     * @return remove um elemento até o valor N
     */
    public  List<Supercharger> removeElementsUntilN(int n, List<Supercharger> arrayList) {
        if (n >= 0 && n < arrayList.size()) {
            arrayList.subList(n, arrayList.size()).clear();
        } else {
            // Lidar com casos onde n está fora dos limites do ArrayList.
            // Você pode optar por lançar uma exceção ou tomar outra ação apropriada.
            // Neste exemplo, não fazemos nada.
        }
        return arrayList;
    }
    // método que cria os objetos a partir da matriz de strings

    /**
     * @param data
     * @param superchargerList
     * @return allocation of the objects
     */
    public boolean allocateObjects(String[][] data, List<Supercharger> superchargerList){
        boolean status = false;
        for (int i = 0; i < data.length; i++) {
            if(data[i][11].equalsIgnoreCase("open")){
                status = true;
            }
            try{

                superchargerList.add(new Supercharger(data[i][6],data[i][4],data[i][3],data[i][2],data[i][5]
                        ,new Stalls(Integer.parseInt(data[i][7]))
                        ,new PowerKw(Integer.parseInt(data[i][8]))
                        ,new Elevm(Integer.parseInt(data[i][10]))
                        ,new Status(status), data[i][9]));
            }catch (NumberFormatException e){
                e.printStackTrace();
                return false;
            }
            status = false;
        }
        return true;
    }

    /**
     * prints list of superchargers
     * @param superchargers
     */
    public void printList(List<Supercharger> superchargers){
        for (int i = 0; i < superchargers.size(); i++) {
            System.out.println(superchargers.get(i).getCapacidadeArmazenamento());
            System.out.println(superchargers.get(i).getAddress().getCountry());
        }
    }

    /**
     * prints list of cities
     * @param cities
     */
    public void printListCity(List<City> cities){
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
    }

    /**
     * gets acumulated capacities
     * @param superchargers
     * @return
     */
    public int getAcumulatedCapacity(List<Supercharger> superchargers){
        int soma = 0;
        for (int i = 0; i < superchargers.size(); i++) {
            soma += superchargers.get(i).getCapacidadeArmazenamento();
        }
        return soma;
    }

    /**
     *
     * @param state
     * @param superchargers
     * @return gets of cities by list of states in supercharger list
     */
    public List<City> getListCityByState(State state, List<Supercharger> superchargers){
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < superchargers.size(); i++) {
            if(superchargers.get(i).getAddress().getState().equals(state)){
                cities.add(superchargers.get(i).getAddress().getCity());
            }
        }
        return cities;
    }

    /**
     *
     * @param states
     * @param superchargerList
     * @return gets list of superchargers by state
     */
    public List<Supercharger> getListSuperChargerByState(List<State> states, List<Supercharger> superchargerList){
        List<Supercharger> ret = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < superchargerList.size(); j++) {
                if(superchargerList.get(j).getAddress().getState().equals(states.get(i))){
                    ret.add(superchargerList.get(i));
                }
            }
        }
        return ret;
    }

    /**
     * prints the final structure
     * @param map
     */
    public void printMap(Map<LinkedHashMap<State,List<City>>,Integer> map){
        for(Map.Entry<LinkedHashMap<State, List<City>>, Integer> entry : map.entrySet()){
            for(Map.Entry<State, List<City>> entry1 : entry.getKey().entrySet()){
                System.out.printf("Numero acumulado -> %d -> State %s -> Cidades -> %d\n",entry.getValue(),entry1.getKey(),entry1.getValue().size());
                printListCity(entry1.getValue());
            }
        }
    }
}
