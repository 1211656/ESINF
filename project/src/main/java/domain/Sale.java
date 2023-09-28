package domain;

public class Sale {
    private int numberVehicles;
    private String typeVehicle;
    private Country country;
    private int year;

    public Sale(int numberVehicles, String typeVehicle, String country, int year) {
        this.numberVehicles = numberVehicles;
        this.typeVehicle = typeVehicle;
        this.country = new Country(country);
        this.year = year;

        
    }

    public static boolean createSale(String numberVehicles, String typeVehicle, String country, String year) {
        boolean sairLoop = false;
        while (sairLoop == false) {
            try {
                new Sale(Integer.parseInt(numberVehicles), typeVehicle, country, Integer.parseInt(year));
                sairLoop = true;
            } catch (NumberFormatException e) {

            }
        }
        return sairLoop;
    }


}
