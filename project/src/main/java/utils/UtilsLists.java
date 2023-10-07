package utils;

import java.util.Collections;
import java.util.List;

public class UtilsLists {

    /**
     * @param lista
     * @return List ordenada alfabeticamente
     * @param <T>
     */
    public static <T extends Comparable<? super T>> boolean ordenarListaAlfabeticamente(List<T> lista){
        try{
            Collections.sort(lista);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
