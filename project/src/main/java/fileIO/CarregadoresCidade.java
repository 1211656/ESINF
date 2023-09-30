package fileIO;

import domain.City;
import domain.Country;
import domain.Stalls;
import domain.State;

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
                Country country = new Country(campos[6].trim());
                City city = new City(campos[3].trim());
                Stalls stalls = new Stalls(Integer.parseInt(campos[7].trim()));

                //Adiciona ao Map chargersCidade o país, cidade e carregadores
                chargersCidade.putIfAbsent(country, new HashMap<>());
                chargersCidade.get(country).put(city, stalls);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Função que divide a linha em campos usando a vírgula como delimitador, ignorando as vírgulas dentro de aspas.
    private String[] splitCSVLine(String line) {
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
                System.out.println(entry2.getKey().getName() + " | " + entry2.getValue().getNumber());
            }
        }
    }


    // vê se já existe a cidade no map
    public boolean searchForCityInMap(Country country,City city){
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



}