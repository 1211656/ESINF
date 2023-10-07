package domain;

import java.util.Objects;

/**
 * Classe que representa o state
 */
public class State {
    /**
     * atributos de objeto
     */
    private String name;

    /**
     * construtor do objeto
     * @param name
     */
    public State(String name){
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
     * @param o
     * @return true if objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name);
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        int result = 17;
        return 31*result + (name!=null ? name.hashCode() : 0);
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return String.format("State{" +
                "name='" + name + '\'' +
                '}');
    }
}
