package domain;


/**
 * Classe que representa a potência de um supercharger
 */
public class PowerKw {
    /**
     * atributos de objeto
     */
    private int kw;

    /**
     * construtor do objeto
     * @param kw
     */
    public PowerKw(int kw) {
        this.kw = kw;
    }

    /**
     * @return kW
     */
    public int getKw() {
        return kw;
    }

    /**
     * sets kw
     * @param kw
     */
    public void setKw(int kw) {
        this.kw = kw;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return "PowerKw{" +
                "kw=" + kw +
                '}';
    }

    /**
     * @param o
     * @return true if o equals to this object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerKw powerKw = (PowerKw) o;
        return kw == powerKw.kw;
    }

    /**
     * @return hashcode of this object
     */
    @Override
    public int hashCode() {
        int result = 17;

        return 31 * result + kw;
    }
}
