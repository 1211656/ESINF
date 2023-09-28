package fileIO;

import domain.City;
import domain.Country;
import domain.Stalls;
import domain.Zip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CarregadoresCidade implements Files{

    //  País  ,  Cidade  ,  "Stalls"
    Map<Country, Map<City, Stalls>> chargersCidade = new HashMap<>();

    public void CountChargers(File file){



        try (BufferedReader br = new BufferedReader(new FileReader(Teste))) {

            String linha;
            br.readLine(); //Ignora a primeira linha

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(","); // Divide a linha em campos usando ponto e vírgula como delimitador

                Country country = new Country(campos[6].trim());
                City city = new City(campos[3].trim());
                Stalls stalls = new Stalls(Integer.parseInt(campos[7].trim()));

                if(searchForCountryInMap(country.getName())){
                    chargersCidade.get(country).put(city, stalls);
                }
                else{
                    chargersCidade.put(country, new HashMap<>()).put(city, stalls);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(chargersCidade);
    }

    // vê se existe o país que vem como argumento como chave no mapa
    private boolean searchForCountryInMap(String country){
        for(Map.Entry<Country,Map<City,Stalls>> entry : chargersCidade.entrySet()){
            if(entry.getKey().getName().equals(country)){
                return true;
            }
        }
        return false;
    }

    public void mostraCarregadorCidade(){
        for(Map.Entry<Country,Map<City,Stalls>> entry : chargersCidade.entrySet()){
            System.out.println(entry.getKey().getName());
            for(Map.Entry<City,Stalls> entry2 : entry.getValue().entrySet()){
                System.out.println(entry2.getKey().getName() + " " + entry2.getValue().getNumber());
            }
        }

    }
}