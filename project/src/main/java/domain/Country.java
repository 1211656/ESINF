package domain;

import org.apache.poi.ss.formula.functions.T;

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
}
