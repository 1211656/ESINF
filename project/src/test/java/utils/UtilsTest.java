package utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void stringToDoubleGPS() {
    }

    @Test
    void ordenateMapAlphabeticallyKey() {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Zebra", 5);
        mapa.put("Girafa", 2);
        mapa.put("Elefante", 3);
        mapa.put("Leão", 4);

        Map<String, Integer> mapaOrdenado = Utils.ordenateMapAlphabeticallyKey(mapa);
        // Imprima o mapa ordenado
        for (Map.Entry<String, Integer> entry : mapaOrdenado.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}