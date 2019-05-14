package Shared.Models.Billing;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@NamedQueries({
        @NamedQuery(name = "Allbill", query = "select  b  from Bill b")
})
public class Bill {
    @Id
    @GeneratedValue
    private int ID;

    private Date date;
    private Double price;
    private int Kilometers;
    @OneToMany
    @JoinTable()
    private List<Ride> rides = new ArrayList<>();

    public Bill() {
    }

    public Bill(Date date, int kilometers, List<Ride> rides) {
        this.date = date;

        Kilometers = kilometers;
        this.rides = rides;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
//        double price = 0;
//        for(Ride ride : rides){
//            price += ride.getPrice();
//        }

        return this.price;
    }

    public void CalcPrice() {
        double price = 0;
        for(Ride ride : rides){
            price += ride.GetPrices();
        }

        this.price = price;
    }

    public void CalcKilometer(){

        int kilometers = 0;

        for(Ride ride : rides){
            kilometers += ride.getKilometers();
        }

        this.Kilometers = kilometers;

    }


    public int getKilometers() {
        return Kilometers;
    }


    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
