package domain;

public class Zip {

    private String code;

    public Zip(String code){
        this.code=code;
    }

    @Override
    public String toString() {
        return "Zip{" +
                "code='" + code + '\'' +
                '}';
    }
}
