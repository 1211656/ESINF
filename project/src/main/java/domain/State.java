package domain;

public class State {

    private String name;

    public State(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return String.format("State{" +
                "name='" + name + '\'' +
                '}');
    }
}
