package domain;

public class Gps implements Comparable<Gps>{

    private double latitude;
    private double longitude;

    private static final double RADIUS_EARTH = 6371; // km


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

    @Override
    public String toString() {
        return String.format("Latitude : %.7f\nLongitude : %.7f",latitude,longitude);
    }

    // getting the distance between two gps
    public double getDistanceBetweenTwoChargers(Gps other){
        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(other.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lon2 = Math.toRadians(other.longitude);

        double difLatitude = (lat2-lat1);
        double difLongitude =  (lon2-lon1);
        double a = Math.pow((Math.sin(difLatitude/2)),2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.pow(Math.sin(difLongitude/2),2);
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return Math.round(RADIUS_EARTH*c);
    }

    @Override
    public int compareTo(Gps o) {
        return 0;
    }
}
