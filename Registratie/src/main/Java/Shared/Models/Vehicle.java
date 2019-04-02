package Shared.Models;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity

@NamedQueries({
        @NamedQuery(name = "ALLVehicles", query = "select  v  from Vehicle v"),
        @NamedQuery(name = "VehicleID", query = "select  v  from Vehicle v where v.id = :ID"),
        @NamedQuery(name = "UserVehicles", query = "select  v  from Vehicle v where v.Owner = :owner")
})
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleID;

    private String license;
    private boolean stolen;
    private int weight;
    private int wheels;
    @ManyToOne(cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "Owner_id", nullable = false)
    private User Owner;

    public int getVehicleID() {
        return vehicleID;
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

    public User getOwner() {
        return Owner;
    }

    public void setOwner(User owner) {
        this.Owner = owner;
    }

    public Vehicle() {
    }


}
