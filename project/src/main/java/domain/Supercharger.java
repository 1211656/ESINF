package domain;


public class Supercharger {
    private Address address;
    private Stalls stalls;
    private PowerKw powerKw;
    private Elevm elevm;
    private String description;
    private String status;

    public Supercharger(String countryName, String stateName, String cityName, String streetAddress, String zipCode, String stalls, String powerKw, String elevm, String gpsCoordinates, String description, String status){
        this.address = new Address(countryName,stateName,cityName,streetAddress,zipCode, gpsCoordinates);
        this.stalls = new Stalls(Integer.parseInt(stalls));
        this.powerKw = new PowerKw(Integer.parseInt(powerKw));
        this.elevm = new Elevm(Integer.parseInt(elevm));
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
    public String getDescription(){return description;}

    @Override
    public String toString() {
        return getDescription();
    }
}
