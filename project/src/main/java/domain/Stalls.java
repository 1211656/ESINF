package domain;

import java.util.Objects;

/**
 * Classe que representa as stalls de um supercharger
 */
public class Stalls {
    /**
     * Atributos de objeto
     */
    private int numberOfStalls;
    private PowerKw powerKw;

    /**
     * construtor de objeto
     * @param n
     */
    public Stalls(int n){
        this.numberOfStalls = n;
    }

    /**
     * construtor de objeto
     * @param n
     * @param powerKw
     */
    public Stalls(int n, PowerKw powerKw){
        this.numberOfStalls = n;
        this.powerKw = powerKw;
    }

    /**
     * @return number of stalls
     */
    public int getNumberOfStalls() {
        return numberOfStalls;
    }

    /**
     * sets number of stalls
     * @param numberOfStalls
     */
    public void setNumberOfStalls(int numberOfStalls) {
        this.numberOfStalls = numberOfStalls;
    }

    /**
     * sets powerKw
     * @param powerKw
     */
    public void setPowerKw(PowerKw powerKw) {
        this.powerKw = powerKw;
    }

    /**
     * @return powerKw
     */
    public PowerKw getPowerKw() {
        return powerKw;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return "Stalls{" +
                "numberOfStalls=" + numberOfStalls +
                ", powerKw=" + powerKw +
                '}';
    }

    /**
     * @param o
     * @return true if objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stalls stalls = (Stalls) o;
        return numberOfStalls == stalls.numberOfStalls && Objects.equals(powerKw, stalls.powerKw);
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + numberOfStalls;
        result = 31 * result + (powerKw!=null ? powerKw.hashCode() : 0);
        return result;
    }
}
