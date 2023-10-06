package domain;

import org.apache.poi.ss.formula.functions.T;

import java.util.Objects;

public class Country implements Comparable<Country>{

    private String name;

    public Country(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Country other){
        if(other == this || other.name.equals(name)){
            return true;
        }
        if(other!=this || other.name!=this.name){
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s",name);
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo( o.getName());
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
