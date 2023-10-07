package domain;

/**
 * Class that represents the gps
 */
public class Gps implements Comparable<Gps>{
    /**
     * atributos de objeto
     */
    private double latitude;
    private double longitude;

    /**
     * constante da classe
     */
    private static final double RADIUS_EARTH = 6371; // km

    /**
     * construtor do objeto
     * @param latitude
     * @param longitude
     */
    public Gps(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return coordinates in array
     */
    public double[] getCoordinates() {
        double[] coordinates = new double[2];
        coordinates[0] = latitude;
        coordinates[1] = longitude;
        return coordinates;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return String.format("Latitude : %.7f\nLongitude : %.7f",latitude,longitude);
    }

    /**
     * @param other
     * @return the distance in KM between two GPS
     */
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
        return (RADIUS_EARTH*c);
    }

    /**
     *
     * @param o the object to be compared.
     * @return 0 if equal, positive if this is higher, negative if is lower
     */
    @Override
    public int compareTo(Gps o) {
        // Primeiro, comparamos as latitudes
        int latitudeComparison = Double.compare(this.latitude, o.latitude);

        // Se as latitudes forem iguais, comparamos as longitudes
        if (latitudeComparison == 0) {
            return Double.compare(this.longitude, o.longitude);
        }

        // Se as latitudes forem diferentes, retornamos a comparação das latitudes
        return latitudeComparison;
    }

    /**
     *
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        int result = 17; // Valor inicial, um número primo

        long latBits = Double.doubleToLongBits(latitude);
        long lonBits = Double.doubleToLongBits(longitude);

        int latHash = (int) (latBits ^ (latBits >>> 32)); // Hash da latitude (XOR) + deslocação de 32 bits à direita
        int lonHash = (int) (lonBits ^ (lonBits >>> 32)); // Hash da longitude

        result = 31 * result + latHash;
        result = 31 * result + lonHash;

        return result;
    }

    /**
     * @param obj
     * @return true if objects are equal
     */
    @Override
    public boolean equals(Object obj) {
       if(obj==this){
           return true;
       }
       if(obj==null || obj.getClass()!=getClass()){
           return false;
       }
       Gps gps = (Gps) obj;
       return gps.longitude==this.longitude&&gps.latitude==this.latitude;
    }

    /**
     * @param gps
     * @return array que tem como primeiro elemento a latitude e 2º elemento a longitude
     */
    public static Double[] stringToDoubleGPS(String gps){
        Double[] res = new Double[2];
        String[] strings = gps.split(", ");
        int index = 0;
        for (String strings1 : strings) {
            res[index] = Double.parseDouble(strings1);
            index ++;
        }
        // "62.073923, 9.125562"
        return res;
    }
}
