package structures;

import domain.Country;
import domain.Sale;
import fileIO.Files;
import tasks.TaskEvolutionNumberVehicles;
import utils.UtilsFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa a estrutura final da evolução do numero de veículos entre 2 anos dados
 */
public class StructureEvolutionNumberVehicles implements Files {
    private String[][] matriz;
    private Map<Sale,Integer> map;
    TaskEvolutionNumberVehicles task;

    /**
     * Construtor de objetos
     */
    public StructureEvolutionNumberVehicles() throws IOException {
        task = new TaskEvolutionNumberVehicles();
        matriz = UtilsFile.readFileToArraySale(SalesFile);

    }

    /**
     * @param firstYear
     * @param secondYear
     * @return map that gets the evolution of number of vehicles
     */
    public Map<Country,Double> getEvolutionNumberVehicles(int firstYear, int secondYear){
        Map<Country,Double> res = new HashMap<>();
        double diferenca ;
        int valor1 = -1;
        int valor2 = -1;
        int[] arrDifferenceYears = new int[2];
        ArrayList<Country> countries = new ArrayList<>();
        for (Map.Entry<Sale,Integer> entry : map.entrySet()) {
            if (!countries.contains(entry.getKey().getCountry())) {
                if (task.searchIfBothYearsAreInMap(firstYear,secondYear,entry.getKey().getCountry(),map)) {
                    Map<Sale, Integer> map2 = task.getMapByYearsAndCountry(firstYear, secondYear, task.getMapOfCountries(entry.getKey().getCountry(),map));
                    for (Map.Entry<Sale, Integer> map3 : map2.entrySet()) {
                        if (valor1 == -1) {
                            arrDifferenceYears[0] = map3.getKey().getYear();
                            valor1 = map3.getValue();
                        } else {
                            if (valor2 == -1) {
                                arrDifferenceYears[1] = map3.getKey().getYear();
                                valor2 = map3.getValue();
                            }
                        }

                    }

                    if (arrDifferenceYears[1] > arrDifferenceYears[0]) {
                        diferenca = (double) (valor2 - valor1) / valor1;
                    } else {
                        diferenca = (double) (valor1 - valor2) / valor2;
                    }
                    System.out.printf("%s | %.2f\n", entry.getKey().getCountry(), diferenca);
                    res.put(entry.getKey().getCountry(),diferenca);
                    valor1 = -1;
                    valor2 = -1;
                    countries.add(entry.getKey().getCountry());
                }
            }
        }
        return res;
    }






}
