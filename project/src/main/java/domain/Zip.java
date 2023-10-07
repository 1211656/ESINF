package domain;

import java.util.Objects;

/**
 * classe que rpresenta o zip code
 */
public class Zip {
    /**
     * atributos de objeto
     */
    private String code;

    /**
     * construtor de objeto
     * @param code
     */
    public Zip(String code){
        this.code=code;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * sets code
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * description of the object
     * @return
     */
    @Override
    public String toString() {
        return "Zip{" +
                "code='" + code + '\'' +
                '}';
    }

    /**
     * @param o
     * @return true if objects are the same, false if aren't the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zip zip = (Zip) o;
        return Objects.equals(code, zip.code);
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return 17*31 + (code!=null ? code.hashCode() : 0);
    }
}
