package fileIO;

import domain.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarregadoresCidade implements Files {

    /* Mapa que guarda o País , Cidade e Carregadores.
       País é a chave principal do Map tendo um Map interno associado,
       onde a cidade atua como a chave e o valor é o número agregado de carregadores.*/


    Map<Country, Map<City, Stalls>> chargersCidade;

    public CarregadoresCidade(){
        chargersCidade= new HashMap<>();
    }

    public void GetChargers(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            br.readLine(); // Ignora a primeira linha

            while ((linha = br.readLine()) != null) {
                // Divide a linha em campos usando a vírgula como delimitador
                String[] campos = splitCSVLine(linha);

                //Cria os objetos Country, City e Stalls

                Country country = getCountryInMap(campos[5].trim());
                City city = getCityInMap(campos[2].trim(),country);
                PowerKw powerKw = new PowerKw(Integer.parseInt(campos[7].trim()));
                Stalls stalls = new Stalls(Integer.parseInt(campos[6].trim()), powerKw);





                // verificar se já existe o país
                if(searchForCountryInMap(country)){
                    // verificar se já existe a cidade
                    if(searchForCityInMap(country,city)){
                        // se já existir a cidade então temos de adicionar o número de stalls à cidade já existente
                        addStallsToCity(country,city,stalls);
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Função que divide a linha em campos usando a vírgula como delimitador, ignorando as vírgulas dentro de aspas.
    public static String[] splitCSVLine(String line) {
        List<String> campos = new ArrayList<>();
        StringBuilder campoAtual = new StringBuilder();
        boolean verificaAspas = false;

    // Percorre a linha
        for (char c : line.toCharArray()) {
            // Se encontrar aspas, inverte o valor da variável verificaAspas
            if (c == '"') {
                verificaAspas = !verificaAspas;
            } else if (c == ',' && !verificaAspas) {
                campos.add(campoAtual.toString().trim());
                campoAtual.setLength(0);
            } else {
                campoAtual.append(c);
            }
        }

        campos.add(campoAtual.toString().trim());

        return campos.toArray(new String[0]);
    }

    // Função que mostra quantos carregardores existem por cidade
    public void mostraCarregadorCidade() {
        // Percorre o Map chargersCidade
        for (Map.Entry<Country, Map<City, Stalls>> entry : chargersCidade.entrySet()) {
            System.out.print(entry.getKey().getName() + " | ");
            // Percorre o Map interno chargersCidade
            for (Map.Entry<City, Stalls> entry2 : entry.getValue().entrySet()) {
                System.out.println(entry2.getKey().getName() + " | " + entry2.getValue().getNumberOfStalls());
            }
        }
    }


    // vê se já existe a cidade no map
    public boolean searchForCityInMap(Country country,City city){
        if(city == null || country == null){
            return false;
        }
        for(Map.Entry<Country,Map<City, Stalls>>  entry : chargersCidade.entrySet()){
            if(country.equals(entry.getKey())){
                Map<City, Stalls> map = entry.getValue();
                for (Map.Entry<City,Stalls> entry1 : map.entrySet()){
                    if(entry1.getKey().equals(city)){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    // vê se já existe o país no map
    public boolean searchForCountryInMap(Country country){
        if(country == null){
            return false;
        }
        for(Map.Entry<Country,Map<City,Stalls>> entry : chargersCidade.entrySet()){
            if(entry.getKey().equals(country)){
                return true;
            }
        }
        return false;
    }

    // adiciona as stalls da mesma cidade
    public boolean addStallsToCity(Country country, City city, Stalls stalls){
        try{
            Map<City,Stalls> map = chargersCidade.get(country);
            map.get(city).setNumberOfStalls(map.get(city).getNumberOfStalls()+stalls.getNumberOfStalls());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    // obtem o país relevante à string lida
    public Country getCountryInMap(String country){
        for(Map.Entry<Country,Map<City,Stalls>> entry : chargersCidade.entrySet()){
            if(entry.getKey().getName().equalsIgnoreCase(country)){
                return entry.getKey();
            }
        }
        return new Country(country);
    }

    // obtem a cidade relevante à string lida
    public City getCityInMap(String city, Country country){
        if(chargersCidade.isEmpty() || !searchForCountryInMap(country)){
            return new City(city);
        }
        Map<City,Stalls> map = chargersCidade.get(country);
        for(Map.Entry<City,Stalls> entry : map.entrySet()){
            if(entry.getKey().getName().equalsIgnoreCase(city)){
                return entry.getKey();
            }
        }
        return new City(city);
    }

    // Função que mostra quantos carregardores existem por país, separados por kW <= 150 e kW > 150
    public void contaCarregadorPais() {
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
        }

        // Imprime os resultados usando a função de impressão separada
        mostraResultadoPorPais(carregadoresKwInferior, "Carregadores com kW <= " + KwLimit + " por país:\n");
        mostraResultadoPorPais(carregadoresKwSuperior, "\nCarregadores com kW > " + KwLimit + " por país:\n");
    }

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
                .forEach(entry -> System.out.println(" *" + entry.getKey().getName() + " - Carregadores Totais: " + entry.getValue().getKw()));    }
}