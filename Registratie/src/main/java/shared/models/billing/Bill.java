package shared.models.billing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import shared.models.User;
import shared.models.Vehicle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@NamedQueries({
        @NamedQuery(name = "Allbill", query = "select  b  from Bill b"),
        @NamedQuery(name = "Userbills", query = "select  b  from Bill b where user.id = :ID "),
        @NamedQuery(name = "BillYear", query = "select b from  Bill b where  YEAR(b.date) = YEAR(:date) "),
        @NamedQuery(name = "BillYearUser", query = "select b from  Bill b where  YEAR(b.date) = YEAR(:date) AND  b.user.id = :ID")
})
public class Bill {
    @Id
    @GeneratedValue
    private int ID;

    private Date date;
    private Double price;
    private int Kilometers;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable()
    private List<Ride> rides = new ArrayList<>();

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "bills", nullable = false)
    private User user;

    public Bill() {
    }

    public Bill(Date date, int kilometers, List<Ride> rides) {
        this.date = date;

        Kilometers = kilometers;
        this.rides = rides;
    }

    public Bill(Date date, List<Ride> rides, Vehicle vehicle, User user) {
        this.date = date;
        this.rides = rides;
        this.vehicle = vehicle;
        this.user = user;
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


    public void CalcData(){
        for(Ride r : rides){
            r.CalcData();
        }
        CalcPrice();
        CalcKilometers();
    }

    public void CalcPrice(){
        double price = 0;
        for(Ride ride : rides){
            price =+ ride.getPrice();
        }

        this.price = price;
    }
    public void CalcKilometers(){

        int kilometers = 0;

        for(Ride ride : rides){
            kilometers =+ ride.getKilometers();
        }

        this.Kilometers = kilometers;

    }

    public void CalcPrices() {
        double price = 0;
        for(Ride ride : rides){
            price += ride.GetPrices();
        }

        this.price = price;
    }

    public void CalcKilometer(){

        int kilometers = 0;

        for(Ride ride : rides){
            kilometers = kilometers + ride.getKilometers();
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
