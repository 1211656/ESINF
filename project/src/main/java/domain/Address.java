package domain;

import java.util.Objects;

/**
 * Esta classe serve para definir o endereço, tem como atributos os objetos em baixo definidos
 */
public class Address {

    /**
     * atributos da instancia address
     */
    private Country country;
    private State state;
    private City city;
    private StreetAdress streetAdress;
    private Zip zip;
    private Gps gpsCoordinates;

    /**
     * Construtor do objeto address
     * @param countryName
     * @param stateName
     * @param cityName
     * @param streetAddress
     * @param zipCode
     * @param gpsCoordinates
     */
    public Address(String countryName, String stateName, String cityName, String streetAddress, String zipCode, String gpsCoordinates){
        this.country=new Country(countryName);
        this.state=new State(stateName);
        this.city = new City(cityName);
        this.streetAdress=new StreetAdress(streetAddress);
        this.zip=new Zip(zipCode);
        Double[] gps = Gps.stringToDoubleGPS(gpsCoordinates);
        this.gpsCoordinates= new Gps(gps[0],gps[1]);
    }

    /**
     * @return gps coordinates
     */
    public Gps getGpsCoordinates(){
        return this.gpsCoordinates;
    }

    /**
     * @return country
     */
    public Country getCountry() {
        return country;
    }


    /**
     * @return city
     */
    public City getCity() {
        return city;
    }


    /**
     * @return state
     */
    public State getState() {
        return state;
    }


    /**
     * @return street adress
     */
    public StreetAdress getStreetAdress() {
        return streetAdress;
    }

    /**
     * @return zip
     */
    public Zip getZip() {
        return zip;
    }

    /**
     * sets city
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * sets country
     * @param country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * sets gps coordinates
     * @param gpsCoordinates
     */
    public void setGpsCoordinates(Gps gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    /**
     * sets state
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * sets streetAddress
     * @param streetAdress
     */
    public void setStreetAdress(StreetAdress streetAdress) {
        this.streetAdress = streetAdress;
    }

    /**
     * sets zip
     * @param zip
     */
    public void setZip(Zip zip) {
        this.zip = zip;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s\n",country,city,state,streetAdress,zip,gpsCoordinates);
    }

    /**
     * @param obj
     * @return true if object is equal to the object pass into argument
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same instance
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false; // obj is null or not an instance of Address
        }

        Address other = (Address) obj; // Cast obj to Address

        // Compare all relevant fields
        if (!Objects.equals(country, other.country)) return false;
        if (!Objects.equals(state, other.state)) return false;
        if (!Objects.equals(city, other.city)) return false;
        if (!Objects.equals(streetAdress, other.streetAdress)) return false;
        if (!Objects.equals(zip, other.zip)) return false;
        if (!Objects.equals(gpsCoordinates, other.gpsCoordinates)) return false;

        return true; // All fields are equal
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        int result = 17; // numero primo evita colisões e ajuda a garantir uma distribuição uniforme


        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (streetAdress != null ? streetAdress.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (gpsCoordinates != null ? gpsCoordinates.hashCode() : 0);

        return result;
    }
}
