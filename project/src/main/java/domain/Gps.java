package domain;

public class Gps implements Comparable<Gps>{

    private double latitude;
    private double longitude;

    private static final double RADIUS_EARTH = 6.371; // km


    public Gps(double latitude, double longitude) {
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

    // getting the distance between two gps
    public double getDistanceBetweenTwoChargers(Gps other){
        double difLatitude = this.latitude - other.latitude;
        double difLongitude = this.longitude - other.longitude;
        double a = Math.pow(Math.sin(difLatitude/2),2) + Math.cos(this.latitude)*Math.cos(this.longitude)*Math.pow(Math.sin(difLongitude/2),2);
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return RADIUS_EARTH*c;
    }

    @Override
    public int compareTo(Gps o) {
        return 0;
    }
}
