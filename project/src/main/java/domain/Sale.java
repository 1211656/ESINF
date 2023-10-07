package domain;

import java.util.Objects;

/**
 * Classe que represanta uma sale
 */
public class Sale {
    /**
     * atributos de objeto
     */
    private String typeVehicle;
    private Country country;
    private int year;
    private int vehiclesSold;

    /**
     * construtor de objeto
     * @param typeVehicle
     * @param country
     * @param year
     * @param vehiclesSold
     */
    public Sale( String typeVehicle, String country, String year, String vehiclesSold) {
        this.typeVehicle = typeVehicle;
        this.country = new Country(country);
        this.year = Integer.parseInt(year);
        this.vehiclesSold = Integer.parseInt(vehiclesSold);
    }

    /**
     * @return country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return typeVehicle
     */
    public String getTypeVehicle() {
        return typeVehicle;
    }

    /**
     * @return vehicleSold
     */
    public int getVehiclesSold() {
        return vehiclesSold;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return String.format("Country: %s | Type : %s | Year : %d | Vehicles Sold: %d |\n",country.toString(),typeVehicle,year);
    }

    /**
     * @param o
     * @return true if objects are equal, false if the opposite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return year == sale.year
                && vehiclesSold == sale.vehiclesSold
                && Objects.equals(typeVehicle, sale.typeVehicle)
                && Objects.equals(country, sale.country);
    }

    /**
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
       int result = 17;
       result = 31*result + (typeVehicle!=null ? typeVehicle.hashCode() : 0);
       result = 31*result + (country!=null ? country.hashCode() : 0);
       result = 31*result + vehiclesSold;
       result = 31*result + year;
       return result;

    }
}
