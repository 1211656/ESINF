package domain;


import repositories.SuperchargerRepository;

public class Supercharger {




    private Address address;
    private Stalls stalls;
    private PowerKw powerKw;
    private Elevm elevm;
    private Status status;

    public Supercharger(String countryName, String stateName, String cityName, String streetAddress, String zipCode, Stalls stalls, PowerKw powerKw, Elevm elevm,Status status,String gps) {
        this.address = new Address(countryName,stateName,cityName,streetAddress,zipCode,gps);
        this.stalls = stalls;
        this.powerKw = powerKw;
        this.elevm = elevm;
        this.status = status;

        SuperchargerRepository.superchargerList.add(this);
    }

    public Address getAddress() {
        return address;
    }

    public Status getStatus() {
        return status;
    }


    public Stalls getStalls() {
        return stalls;
    }

    public PowerKw getPowerKw() {
        return powerKw;
    }

    public Elevm getElevm() {
        return elevm;
    }

    public int getCapacidadeArmazenamento(){
        if(status.getStatus()){
            return stalls.getNumberOfStalls()*powerKw.getKw();
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s ->  %d",address,getCapacidadeArmazenamento());
    }
}
