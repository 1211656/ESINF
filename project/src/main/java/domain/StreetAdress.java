package domain;

import java.util.Objects;

/**
 * Classe que representa uma Rua
 */
public class StreetAdress {
    /**
     * atributos de objeto
     */
    private String description;

    /**
     * construtor de objeto
     * @param description
     */
    public StreetAdress(String description) {
        this.description = description;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return "StreetAdress{" +
                "description='" + description + '\'' +
                '}';
    }

    /**
     * @param o
     * @return true if objects are the same and false if aren't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetAdress that = (StreetAdress) o;
        return Objects.equals(description, that.description);
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return 17*31 + (description!=null ? description.hashCode() : 0);
    }
}
