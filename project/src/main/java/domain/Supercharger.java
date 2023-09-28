package domain;


public class Supercharger {
    private Address address;
    private Stalls stalls;
    private PowerKw powerKw;
    private Elevm elevm;

    public Supercharger(String countryName, String stateName, String cityName, String streetAddress, String zipCode, Stalls stalls, PowerKw powerKw, Elevm elevm) {
        this.address = new Address(countryName,stateName,cityName,streetAddress,zipCode);
        this.stalls = stalls;
        this.powerKw = powerKw;
        this.elevm = elevm;
    }

    public Address getAddress() {
        return address;
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
}
