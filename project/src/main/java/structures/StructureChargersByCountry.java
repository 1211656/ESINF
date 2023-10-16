package structures;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;
import tasks.TaskChargersByCountry;
import tasks.TaskCityChargers;
import utils.Bootstrap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StructureChargersByCountry {
    private Map<Country, Map<City, Stalls>> chargersCidade;
    private Bootstrap bootstrap;
    private TaskChargersByCountry task;
    private TaskCityChargers cityTask;
    private String[][] data; // Adicione esta variável para armazenar os dados

    public StructureChargersByCountry(Bootstrap bootstrap) throws IOException {
        // inicializa o bootstrap
        bootstrap = bootstrap;
        // inicializa task
        task = new TaskChargersByCountry();
        cityTask = new TaskCityChargers();
        // cria o mapa
        chargersCidade = new HashMap<>();
        // recebe a matriz de strings
        data = bootstrap.getMatrizChargers();
        // preenche o mapa referente ao exercicio
        getChargers();
    }

    /**
     * @return bootstrap
     */
    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    /**
     * @return mapa do ex1
     */
    public Map<Country, Map<City, Stalls>> getChargersCidade() {
        return chargersCidade;
    }

    /**
     * @return task
     */
    public TaskChargersByCountry getTask() {
        return task;
    }

    /**
     * @return informação do ficheiro em matriz de strings
     */
    public String[][] getData() {
        return data;
    }

    /**
     * método que preenche o mapa do ex1
     */
    public void getChargers() {
        for (int i = 0; i < data.length; i++) {

            try{
                // Divide a linha em campos usando a vírgula como delimitador
                String[] campos = data[i];

                //Cria os objetos Country, City e Stalls
                Country country = cityTask.getCountryInMap(campos[6].trim(),chargersCidade);
                City city = cityTask.getCityInMap(campos[3].trim(),country,chargersCidade);
                PowerKw powerKw = new PowerKw(Integer.parseInt(campos[8].trim()));
                Stalls stalls = new Stalls(Integer.parseInt(campos[7].trim()), powerKw);

                // verificar se já existe o país
                if(cityTask.searchForCountryInMap(country,chargersCidade)){
                    // verificar se já existe a cidade
                    if(cityTask.searchForCityInMap(country,city,chargersCidade)){
                        // se já existir a cidade então temos de adicionar o número de stalls à cidade já existente
                        cityTask.addStallsToCity(country,city,stalls,chargersCidade);
                    }
                    // se já existir país mas não existir cidade, adicionas à chave country equivalente o mapa <Ciy, Stall> para não haver repetição de países
                    else{
                        chargersCidade.get(country).put(city,stalls);
                    }
                }
                else{
                    //Adiciona ao Map chargersCidade o país, cidade e carregadores
                    chargersCidade.put(country, new HashMap<>());
                    chargersCidade.get(country).put(city, stalls);
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    }
}
