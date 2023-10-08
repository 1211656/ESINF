package tasks;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskChargersByCountry {
    public Map<Country, Map<String, Integer>> contaCarregadorPais(Map<Country, Map<City, Stalls>> chargersCidade, int KwLimit) {
        Map<Country, Map<String, Integer>> resultado = new HashMap<>();

        // Ciclo que percorre o Map chargersCidade
        for (Map.Entry<Country, Map<City, Stalls>> entry : chargersCidade.entrySet()) {
            Map<String, Integer> countryResult = new HashMap<>();
            int totalcarregadoresKwInferior = 0;
            int totalcarregadoresKwSuperior = 0;

            // Ciclo que percorre o Map interno chargersCidade
            for (Map.Entry<City, Stalls> entry2 : entry.getValue().entrySet()) {
                int stalls = entry2.getValue().getNumberOfStalls();
                PowerKw powerKw = entry2.getValue().getPowerKw();

                if (powerKw.getKw() <= KwLimit) {
                    totalcarregadoresKwInferior += stalls;
                } else {
                    totalcarregadoresKwSuperior += stalls;
                }
            }

            // Adicione os resultados ao Map
            countryResult.put("kW > " + KwLimit, totalcarregadoresKwSuperior);
            countryResult.put("kW <= " + KwLimit, totalcarregadoresKwInferior);
            resultado.put(entry.getKey(), countryResult);
        }

        return resultado;
    }
    /**
     * Apresentar o número de carregadores por país com kWs abaixo e acima de um determinado valor,
     * por ordem decrescente do número total de carregadores e em caso de empate, por ordem alfabética do nome do país.
     *
     * @param chargersCidade O mapa de carregadores por país e cidade.
     */
    public void apresentaCarregadoresPorPais(Map<Country, Map<City, Stalls>> chargersCidade, int kwThreshold) {
        // Calcula o número total de carregadores por país com kWs abaixo e acima do limite
        Map<Country, Integer> carregadoresPorPais = chargersCidade.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().values().stream()
                                .filter(stalls -> stalls.getPowerKw().getKw() <= kwThreshold)
                                .mapToInt(Stalls::getNumberOfStalls)
                                .sum()
                ));

        // Ordena os países por número total de carregadores em ordem decrescente e em caso de empate, por ordem alfabética
        List<Country> sortedCountries = carregadoresPorPais.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int compareByTotal = Integer.compare(entry2.getValue(), entry1.getValue());
                    if (compareByTotal != 0) {
                        return compareByTotal;
                    } else {
                        return entry1.getKey().getName().compareTo(entry2.getKey().getName());
                    }
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Exibe os resultados ordenados
        System.out.printf("%-20s %-10s\n", "País", "Total de Carregadores");
        for (Country country : sortedCountries) {
            int total = carregadoresPorPais.get(country);
            System.out.printf("%-20s %-10d\n", country.getName(), total);
        }
    }

    private int getTotalCarregadores(Map<String, Integer> countryResult) {
        int total = 0;
        for (Integer value : countryResult.values()) {
            total += value;
        }
        return total;
    }
}
