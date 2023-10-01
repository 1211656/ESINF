package domain;

import repositories.Repositories;

public class Sale {

    private String typeVehicle;
    private Country country;
    private int year;

    public Sale( String typeVehicle, String country, int year) {
        this.typeVehicle = typeVehicle;
        this.country = new Country(country);
        this.year = year;
        Repositories.getSalesList().add(this);
    }

    public Country getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    @Override
    public String toString() {
        return String.format("Country: %s | Type : %s | Year : %d |\n",country.toString(),typeVehicle,year);
    }
}
