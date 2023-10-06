package utils;

import java.util.*;

public class Utils {

    public static Double[] stringToDoubleGPS(String gps){
        Double[] res = new Double[2];
        String[] strings = gps.split(", ");
        int index = 0;
        for (String strings1 : strings) {
            res[index] = Double.parseDouble(strings1);
            index ++;
        }
        // "62.073923, 9.125562"
        return res;
    }

    // ordena qualquer mapa alfabeticamente pela chave
    public static <K extends Comparable<? super K>,V>LinkedHashMap<K,V> ordenateMapAlphabeticallyKey(Map<K,V> map){
        List<Map.Entry<K, V>> listaDeEntradas = new ArrayList<>(map.entrySet());
        Collections.sort(listaDeEntradas, (entry1,entry2) -> entry1.getKey().compareTo(entry2.getKey()));

        // Crie um novo mapa ordenado
        LinkedHashMap<K, V> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : listaDeEntradas) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }
        return mapaOrdenado;
    }

    // método que ordena alfabeticamente uma lista
    public static <T extends Comparable<? super T>> boolean ordenarListaAlfabeticamente(List<T> lista){
        try{
            Collections.sort(lista);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
