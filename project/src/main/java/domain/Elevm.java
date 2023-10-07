package domain;

import java.util.Objects;

/**
 * Class that represents the elevation
 */
public class Elevm {
    /**
     * atributos de objeto
     */
    private int elevm;

    /**
     * construtor do objeto
     * @param elevm
     */
    public Elevm(int elevm) {
        this.elevm = elevm;
    }

    /**
     * @return elevm
     */
    public int getElevm() {
        return elevm;
    }

    /**
     * sets elevm
     * @param elevm
     */
    public void setElevm(int elevm) {
        this.elevm = elevm;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return "Elevm{" +
                "elevm=" + elevm +
                '}';
    }

    /**
     * @param obj
     * @return true if objects are the same, false if the opposite
     */
    @Override
    public boolean equals(Object obj) {
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        if(this == obj){
            return true;
        }
        Elevm elevm1 = (Elevm) obj;

        return elevm1.elevm == this.elevm;
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + elevm;
        return result;
    }
}
