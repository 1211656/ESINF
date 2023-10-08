package domain;

import java.util.Objects;

/**
 * Class that represents status
 */
public class Status {
    /**
     * atributos de objeto
     */
    private boolean status;

    /**
     *  Construtor de objeto a partir de string
     * @param status
     * @return status
     */
    public static Status createStatus(String status){
        if(status.equals("OPEN")){
            return new Status(true);
        }
        else{
            return new Status(false);
        }
    }

    /**
     * construtor de objeto
     * @param status
     */
    public Status(boolean status) {
        this.status = status;
    }

    /**
     * @return status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * sets status
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return "Status{" +
                "status=" + status +
                '}';
    }

    /**
     *
     * @param o
     * @return true if objects are the same false if the opposite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return status == status1.status;
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return status ? 1 : 0;
    }
}
