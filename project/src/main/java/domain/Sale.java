package domain;

public class Sale {
    private int numberVehicles;
    private String typeVehicle;
    private Country country;
    private int year;

    public Sale(int numberVehicles, String typeVehicle, Country country, int year){
        this.numberVehicles=numberVehicles;
        this.typeVehicle=typeVehicle;
        this.country=country;
        this.year=year;
    }

}
