package domain;

public class GPS {

    private double latitude;
    private double longitude;

    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double[] getCoordinates() {
        double[] coordinates = new double[2];
        coordinates[0] = latitude;
        coordinates[1] = longitude;
        return coordinates;
    }
}
