package domain;

public class Sale {

    private String typeVehicle;
    private Country country;
    private int year;
    private int vehiclesSold;

    public Sale( String typeVehicle, String country, String year, String vehiclesSold) {
        this.typeVehicle = typeVehicle;
        this.country = new Country(country);
        this.year = Integer.parseInt(year);
        this.vehiclesSold = Integer.parseInt(vehiclesSold);
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

    public int getVehiclesSold() {
        return vehiclesSold;
    }
    @Override
    public String toString() {
        return String.format("Country: %s | Type : %s | Year : %d | Vehicles Sold: %d |\n",country.toString(),typeVehicle,year);
    }
}
