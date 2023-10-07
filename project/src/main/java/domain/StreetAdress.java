package domain;

public class StreetAdress {
    private String description;

    public StreetAdress(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "StreetAdress{" +
                "description='" + description + '\'' +
                '}';
    }
}
