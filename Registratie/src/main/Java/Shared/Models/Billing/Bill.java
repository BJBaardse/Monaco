package Shared.Models.Billing;

import Shared.Models.Kilometertarief;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Bill {
    @Id
    @GeneratedValue
    private int ID;

    private Date date;
    private Double price;
    private int Killometers;
    @OneToMany
    @JoinTable()
    private List<Ride> rides = new ArrayList<>();

    public Bill() {
    }

    public Bill(Date date, Double price, int killometers, List<Ride> rides) {
        this.date = date;
        this.price = price;
        Killometers = killometers;
        this.rides = rides;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getKillometers() {
        return Killometers;
    }

    public void setKillometers(int killometers) {
        Killometers = killometers;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
