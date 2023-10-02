package domain;

public class Stalls {
    private int numberOfStalls;
    private PowerKw powerKw;

    public Stalls(int n){
        this.numberOfStalls = n;
    }

    public Stalls(int n, PowerKw powerKw){
        this.numberOfStalls = n;
        this.powerKw = powerKw;
    }

    public int getNumberOfStalls() {
        return numberOfStalls;
    }

    public void setNumberOfStalls(int numberOfStalls) {
        this.numberOfStalls = numberOfStalls;
    }

    public PowerKw getPowerKw() {
        return powerKw;
    }

}
