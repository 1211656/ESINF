package domain;

import utils.Utils;

public class Address {
    private Country country;
    private State state;
    private City city;
    private StreetAdress streetAdress;
    private Zip zip;
    private Gps gpsCoordinates;

    public Address(String countryName, String stateName, String cityName, String streetAddress, String zipCode, String gpsCoordinates){
        this.country=new Country(countryName);
        this.state=new State(stateName);
        this.city = new City(cityName);
        this.streetAdress=new StreetAdress(streetAddress);
        this.zip=new Zip(zipCode);
        Double[] gps = Utils.stringToDoubleGPS(gpsCoordinates);
        this.gpsCoordinates= new Gps(gps[0],gps[1]);
    }

    public Gps getGpsCoordinates(){
        return this.gpsCoordinates;
    }

    public Country getCountry() {
        return country;
    }
}
