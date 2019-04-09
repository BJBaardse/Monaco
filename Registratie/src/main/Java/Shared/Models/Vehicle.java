package Shared.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity

@NamedQueries({
        @NamedQuery(name = "ALLVehicles", query = "select  v  from Vehicle v"),
        @NamedQuery(name = "VehicleID", query = "select  v  from Vehicle v where v.id = :ID"),
        @NamedQuery(name = "UserVehicles", query = "select  v  from Vehicle v where v.Owner = :owner")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue
    private int vehicleID;
    @Column(unique = true)
    private String license;
    private boolean stolen;
    private int weight;
    private int wheels;
    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "Owner_id", nullable = false)
    private User Owner;

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String kenteken) {
        this.license = kenteken;
    }

    public boolean isStolen() {
        return stolen;
    }

    public void setStolen(boolean gestolen) {
        this.stolen = gestolen;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int gewicht) {
        this.weight = gewicht;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int aantalWielen) {
        this.wheels = aantalWielen;
    }
    @JsonIgnore
    public User getOwner() {
        return Owner;
    }

    public void setOwner(User owner) {
        this.Owner = owner;
    }

    public Vehicle() {
    }

    public Vehicle(String license, boolean stolen, int weight, int wheels, User owner) {
        this.license = license;
        this.stolen = stolen;
        this.weight = weight;
        this.wheels = wheels;
        Owner = owner;
    }
}
