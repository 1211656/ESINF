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
        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(other.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lon2 = Math.toRadians(other.longitude);

        double difLatitude = (lat1-lat2);
        double difLongitude =  (lon1-lon2);
        double a = (Math.sin(difLatitude/2)*(Math.sin(difLatitude/2)
                + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(difLongitude/2),2)));
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return (RADIUS_EARTH*c);
    }

    @Override
    public int compareTo(Gps o) {
        return 0;
    }
}
