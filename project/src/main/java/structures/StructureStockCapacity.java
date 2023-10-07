package structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import domain.*;
import fileIO.CarregadoresCidade;
import fileIO.Files;
import fileIO.ReadCarregadores;
import repositories.SuperchargerRepository;
import utils.UtilsFile;


public class StructureStockCapacity implements Files {

    //capacidade de carregamento é o somatório do nº de
    //postos (Stalls) x potência (kW) de cada um dos Supercharger cujo Status é “Open”

    private List<Supercharger> list = new ArrayList<>();

    private Integer capacityAcumulated;

    private String[][] data;
    private List<Supercharger> superchargerList;

    public StructureStockCapacity()throws IOException {
        data = UtilsFile.readFileToArray(Teste);
        allocateObjects();
        superchargerList = SuperchargerRepository.superchargerList;


    }

    public List<Supercharger> buscarEstadosComMaisCapacidadeArmazenamento(List<Country> countries, int n) {

        List<Supercharger> res = new ArrayList<>();
        List<Supercharger> superchargers = superchargerList;
        int index = -1;
        int maiorValor = 0;
        for (int j = 0; j <countries.size(); j++) {
            while (n != 0) {
                for (int i = 0; i < superchargers.size(); i++) {
                    if (superchargers.get(i).getCapacidadeArmazenamento() > maiorValor && superchargers.get(i).getAddress().getCountry().equals(countries.get(j))) {
                        index = i;
                        maiorValor = superchargers.get(i).getCapacidadeArmazenamento();
                    }
                }
                if (index == -1) {

                } else {
                    res.add(superchargers.get(index));
                    superchargers.remove(index);
                }
                index = -1;
                maiorValor = 0;
                n--;
            }

        }
        return res;
    }


    public List<State> buscarEstadosComMaisCapacidadeArmazenamento(int n,List<State> states){
        return null;
    }


    public int getNumberOfCountriesByType(Country country){
        int contador = 0;
        for (int i = 0; i < superchargerList.size(); i++) {
            if(superchargerList.get(i).getAddress().getCountry().equals(country)){
                contador++;
            }
        }
        return contador;
    }

    // método que cria os objetos a partir da matriz de strings
    private boolean allocateObjects(){
        boolean status = false;
        for (int i = 0; i < data.length; i++) {
            if(data[i][11].equalsIgnoreCase("open")){
                status = true;
            }
            try{
                 new Supercharger(data[i][6],data[i][4],data[i][3],data[i][2],data[i][5]
                 ,new Stalls(Integer.parseInt(data[i][7]))
                 ,new PowerKw(Integer.parseInt(data[i][8]))
                 ,new Elevm(Integer.parseInt(data[i][10]))
                 ,new Status(status), data[i][9]);
            }catch (NumberFormatException e){
                e.printStackTrace();
                return false;
            }
            status = false;
        }
        return true;
    }








}
