package domain;

public class City {

    private String name;

    public City(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null || getClass() != other.getClass()){
            return false;
        }
        City city = (City) other;
        return name.equals(city.name);
    }


}
