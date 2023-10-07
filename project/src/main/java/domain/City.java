package domain;

/**
 * Class made to represent each city
 */
public class City {

    /**
     * atributos de instancia de city
     */
    private String name;

    /**
     * Construtor do objeto city
     * @param name
     */
    public City(String name){
        this.name=name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param other
     * @return true if other equals to this instance
     */
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

    /**
     * description of the object
     * @return
     */
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode(){
        int result = 17; // numero primo evita colisões e ajuda a garantir uma distribuição uniforme

        result = 31*result + (name!=null ? name.hashCode() : 0);
        return result;
    }
}
