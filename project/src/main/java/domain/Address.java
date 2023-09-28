package domain;

public class Address {
    private Country country;
    private State state;
    private City city;
    private StreetAdress streetAdress;
    private Zip zip;

    public Address(Country country, State state, City city, StreetAdress streetAdress, Zip zip){
        this.country=country;
        this.state=state;
        this.city = city;
        this.streetAdress=streetAdress;
        this.zip=zip;
    }
}
