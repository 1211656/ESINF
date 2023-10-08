package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsListTest {

    @Test
    void ordenarListaAlfabeticamente() {
        List<String> lista = new ArrayList<>(Arrays.asList("Zebra", "Girafa", "Elefante", "Leão"));
        assertTrue(UtilsLists.ordenarListaAlfabeticamente(lista));

        // Verifique se a lista está ordenada corretamente
        List<String> listaOrdenada = new ArrayList<>(Arrays.asList("Elefante", "Girafa", "Leão", "Zebra"));
        assertIterableEquals(listaOrdenada, lista);
    }
}
