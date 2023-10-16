package structures;

import domain.City;
import domain.Country;
import domain.PowerKw;
import domain.Stalls;
import tasks.TaskCityChargers;
import utils.Bootstrap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StructureCityChargers {
    /**
     * Atributos de objeto
     */
    private Map<Country, Map<City, Stalls>> chargersCidade;
    private String[][] data;
    private Bootstrap bootstrap;
    private TaskCityChargers task;

    /**
     * Construtor do objeto
     * @throws IOException
     */
    public StructureCityChargers(Bootstrap bootstrap) throws IOException {
        bootstrap = bootstrap;
        task = new TaskCityChargers();
        data = bootstrap.getMatrizChargers();
        chargersCidade= new HashMap<>();
        getChargers();
    }

    /**
     * @return bootstrap
     */
    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    /**
     * @return map(structure)
     */
    public Map<Country, Map<City, Stalls>> getChargersCidade() {
        return chargersCidade;
    }

    /**
     * @return data
     */
    public String[][] getData() {
        return data;
    }

    /**
     * @return task
     */
    public TaskCityChargers getTask() {
        return task;
    }

    /**
     * Gets the structure calling task methods from the referent Task class and fulfills the map chargersCidade
     */
    public void getChargers() {
        for (int i = 0; i < data.length; i++) {

            try{
                // Divide a linha em campos usando a vírgula como delimitador
                String[] campos = data[i];

                //Cria os objetos Country, City e Stalls
                Country country = task.getCountryInMap(campos[6].trim(),chargersCidade);
                City city = task.getCityInMap(campos[3].trim(),country,chargersCidade);
                PowerKw powerKw = new PowerKw(Integer.parseInt(campos[8].trim()));
                Stalls stalls = new Stalls(Integer.parseInt(campos[7].trim()), powerKw);




                // verificar se já existe o país
                if(task.searchForCountryInMap(country,chargersCidade)){
                    // verificar se já existe a cidade
                    if(task.searchForCityInMap(country,city,chargersCidade)){
                        // se já existir a cidade então temos de adicionar o número de stalls à cidade já existente
                        task.addStallsToCity(country,city,stalls,chargersCidade);
                    }
                    // se já existir país mas não existir cidade, adicionas à chave country equivalente o mapa <Ciy, Stall> para não haver repetilção de países
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
