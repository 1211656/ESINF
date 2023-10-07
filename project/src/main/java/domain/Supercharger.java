package domain;


import repositories.SuperchargerRepository;

import java.util.Objects;

/**
 * Classe que representa um supercharger
 */
public class Supercharger {


    /**
     * Atributos de objeto
     */
    private Address address;
    private Stalls stalls;
    private PowerKw powerKw;
    private Elevm elevm;
    private Status status;

    /**
     * construtor de objeto
     * @param countryName
     * @param stateName
     * @param cityName
     * @param streetAddress
     * @param zipCode
     * @param stalls
     * @param powerKw
     * @param elevm
     * @param status
     * @param gps
     */
    public Supercharger(String countryName, String stateName, String cityName, String streetAddress, String zipCode, Stalls stalls, PowerKw powerKw, Elevm elevm,Status status,String gps) {
        this.address = new Address(countryName,stateName,cityName,streetAddress,zipCode,gps);
        this.stalls = stalls;
        this.powerKw = powerKw;
        this.elevm = elevm;
        this.status = status;

        SuperchargerRepository.superchargerList.add(this);
    }

    /**
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @return stalls
     */
    public Stalls getStalls() {
        return stalls;
    }

    /**
     * @return powerKw
     */
    public PowerKw getPowerKw() {
        return powerKw;
    }

    /**
     * @return elevm
     */
    public Elevm getElevm() {
        return elevm;
    }

    /**
     * sets status
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * sets powerKw
     * @param powerKw
     */
    public void setPowerKw(PowerKw powerKw) {
        this.powerKw = powerKw;
    }

    /**
     * sets elevm
     * @param elevm
     */
    public void setElevm(Elevm elevm) {
        this.elevm = elevm;
    }

    /**
     * sets address
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * sets stalls
     * @param stalls
     */
    public void setStalls(Stalls stalls) {
        this.stalls = stalls;
    }

    /**
     * @return capacidade de armazenamento
     */
    public int getCapacidadeArmazenamento(){
        if(status.getStatus()){
            return stalls.getNumberOfStalls()*powerKw.getKw();
        }
        return 0;
    }

    /**
     * @return description of the object
     */
    @Override
    public String toString() {
        return String.format("%s ->  %d",address,getCapacidadeArmazenamento());
    }

    /**
     * @param o
     * @return true if objects are the same, false if aren´t
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supercharger that = (Supercharger) o;
        return Objects.equals(address, that.address) && Objects.equals(stalls, that.stalls) && Objects.equals(powerKw, that.powerKw) && Objects.equals(elevm, that.elevm) && Objects.equals(status, that.status);
    }

    /**
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(address, stalls, powerKw, elevm, status);
    }
}
