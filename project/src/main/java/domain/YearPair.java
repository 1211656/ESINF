package domain;

import java.util.Objects;

public class YearPair {
    private int firstYear;
    private int secondYear;

    public YearPair(int firstYear, int secondYear) {
        this.firstYear = firstYear;
        this.secondYear = secondYear;
    }

    // Override equals and hashCode to compare contents
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearPair yearPair = (YearPair) o;
        return firstYear == yearPair.firstYear &&
                secondYear == yearPair.secondYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstYear, secondYear);
    }

    public int getFirstYear() {
        return firstYear;
    }
    public int getSecondYear() {
        return secondYear;
    }

    @Override
    public String toString() {
        return String.format("%d-%d", firstYear, secondYear);
    }
}
