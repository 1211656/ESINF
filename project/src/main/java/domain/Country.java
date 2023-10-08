package domain;


import java.util.Objects;

/**
 * Class made to represent a country
 */
public class Country implements Comparable<Country>{
    /**
     * atributos de objeto
     */
    private String name;

    /**
     * construtor de objeto
     * @param name
     */
    public Country(String name){
        this.name=name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param other
     * @return true if other equals to this instance
     */
    public boolean equals(Country other){
        if(other == this || other.name.equals(name)){
            return true;
        }
        if(other!=this || other.name!=this.name){
            return false;
        }
        return false;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return String.format("%s",name);
    }

    /**
     * @param o the object to be compared.
     * @return 0 if equal, positive means that "this" is bigger lexicographically than o, and if negative is the opposite
     */
    @Override
    public int compareTo(Country o) {
        return this.name.compareTo( o.getName());
    }

    /**
     * @param obj
     * @return true if objects are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Country other = (Country) obj;
        return name.equals(other.getName());
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
