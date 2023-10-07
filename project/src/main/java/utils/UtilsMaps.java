package utils;

import java.util.*;

public class UtilsMaps {
    /**
     * @param map
     * @return linkedHashMap ordenado pelas chaves
     * @param <K>
     * @param <V>
     */
    public static <K extends Comparable<? super K>,V> LinkedHashMap<K,V> ordenateMapAlphabeticallyKey(Map<K,V> map){
        List<Map.Entry<K, V>> listaDeEntradas = new ArrayList<>(map.entrySet());
        Collections.sort(listaDeEntradas, (entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));

        // Crie um novo mapa ordenado
        LinkedHashMap<K, V> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : listaDeEntradas) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }
        return mapaOrdenado;
    }
}
