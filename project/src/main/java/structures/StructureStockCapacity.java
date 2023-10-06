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


public class StructureStockCapacity implements Files {

    //capacidade de carregamento é o somatório do nº de
    //postos (Stalls) x potência (kW) de cada um dos Supercharger cujo Status é “Open”

    private List<Supercharger> list = new ArrayList<>();

    private Integer capacityAcumulated;

    private String[][] data;
    private List<Supercharger> superchargerList;

    public StructureStockCapacity()throws IOException {
        data = ReadCarregadores.readFileToArray(Teste);
        allocateObjects();
        superchargerList = SuperchargerRepository.superchargerList;


    }

    public List<Supercharger> buscarEstadosComMaisCapacidadeArmazenamento(List<Country> countries, int n){
        List<Supercharger> res = new ArrayList<>();
        List<Country> countries1 = countries;
        List<Supercharger> superchargers = superchargerList;
        int index = 0;
        for (int i = 0; i < superchargers.size(); i++) {
            if(countries1.get(index).equals(superchargers.get(i)));
        }




        return res;
    }


    public List<State> buscarEstadosComMaisCapacidadeArmazenamento(int n,List<State> states){
        return null;
    }


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
                        ,new Status(status));
            }catch (NumberFormatException e){
                e.printStackTrace();
                return false;
            }
            status = false;
        }
        return true;
    }








}