package tasks;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaskChargersByCountry {
/**
    public TaskChargersByCountry(){}
    /**
     * conta quantos carregadores existem por país
     * @param chargersCidade
     */

/**
    public LinkedList<Map<Country,PowerKw>> contaCarregadorPais(Map<Country, Map<City, Stalls>> chargersCidade) {
        LinkedList<Map<Country,PowerKw>> ret = new LinkedList<>();
        // Mapa que guarda o país e o número total de carregadores para kW <= 150
        Map<Country, PowerKw> carregadoresKwInferior = new HashMap<>();
        // Mapa que guarda o país e o número total de carregadores para kW > 150
        Map<Country, PowerKw> carregadoresKwSuperior = new HashMap<>();

        int KwLimit = 150;

        // Ciclo que percorre o Map chargersCidade
        for (Map.Entry<Country, Map<City, Stalls>> entry : chargersCidade.entrySet()) {
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

            // Adiciona o país ao Map correspondente
            if (totalcarregadoresKwInferior > 0) {
                carregadoresKwInferior.put(entry.getKey(), new PowerKw(totalcarregadoresKwInferior));
            }
            if (totalcarregadoresKwSuperior > 0) {
                carregadoresKwSuperior.put(entry.getKey(), new PowerKw(totalcarregadoresKwSuperior));
            }
            ret.add(carregadoresKwInferior,carregadoresKwSuperior);
        }

        // Imprime os resultados usando a função de impressão separada
        mostraResultadoPorPais(carregadoresKwInferior, "Carregadores com kW <= " + KwLimit + " por país:\n");
        mostraResultadoPorPais(carregadoresKwSuperior, "\nCarregadores com kW > " + KwLimit + " por país:\n");
    }

    /**
     * mostra os resultados por país
     * @param chargersByCountry
     * @param message
     */
/**
    public void mostraResultadoPorPais(Map<Country, PowerKw> chargersByCountry, String message) {
        System.out.println(message);
        // Ordena o Map chargersByCountry por número de carregadores de forma decrescente, e por ordem alfabética do nome do país em caso de empate
        chargersByCountry.entrySet().stream()
                .sorted((a, b) -> {
                    int compara = Integer.compare(b.getValue().getKw(), a.getValue().getKw());
                    if (compara == 0) {
                        return a.getKey().getName().compareTo(b.getKey().getName());
                    }
                    return compara;
                })
                .forEach(entry -> System.out.println(" *" + entry.getKey().getName() + " - Carregadores Totais: " + entry.getValue().getKw()));
    }
    */

}
