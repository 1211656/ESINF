package fileIO;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class ReadCSVFileTest implements Files{


    /**
     * 1)
     * Devolver numa estrutura de dados para cada país o número de carregadores
     * elétricos por cidade.
     * Map<Country, Map<City, Number of chargers>>
     */



    /**
     * 2)
     * Pretende-se conhecer a evolução do número de veículos elétricos dos vários países. Para isso determine
     * a taxa de crescimento entre 2 quaisquer anos do número de veículos elétricos nos vários países. A taxa é
     * dada por (último ano - primeiro ano) / primeiro ano.
     * Map<Country, Map<Year, Nr of vehicles>>
    */

    /**
     * 3)
     * Pretende-se saber quais os países em que não houve aumento do número de veículos elétricos de um
     * ano para o outro. Deverá ser apresentado na listagem os anos em que tal sucedeu, indicando a diferença
     * do número de veículos para cada tipo de powertrain.
     */


    @Test
    void readCSVFile() {
       /* String data = new ReadCSVFile(Teste).toString();

        //  País  ,  Cidade  ,  "Stalls"
        Map<String, Map<String, Integer>> chargersCidade = new HashMap<>();*/

        CarregadoresCidade carregadoresCidade = new CarregadoresCidade();
        carregadoresCidade.CountChargers(Teste);
        carregadoresCidade.mostraCarregadorCidade();

    }
}