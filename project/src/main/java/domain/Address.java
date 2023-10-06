package domain;

public class Address {
    private Country country;
    private State state;
    private City city;
    private StreetAdress streetAdress;
    private Zip zip;

    public Address(String countryName, String stateName, String cityName, String streetAddress, String zipCode){
        this.country=new Country(countryName);
        this.state=new State(stateName);
        this.city = new City(cityName);
        this.streetAdress=new StreetAdress(streetAddress);
        this.zip=new Zip(zipCode);
    }

    public Country getCountry() {
        return country;
    }

    public City getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public StreetAdress getStreetAdress() {
        return streetAdress;
    }

    public Zip getZip() {
        return zip;
    }

}
