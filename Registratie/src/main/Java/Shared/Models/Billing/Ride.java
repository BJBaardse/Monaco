package Shared.Models.Billing;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Ride {
    @Id
    @GeneratedValue
    private int ID;
    private Date date;
    @OneToMany( fetch = FetchType.EAGER)
    @JoinTable()
    private List<Movement> movements;

    private Double price;


    public Double getPrice(){

        return price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void AddMovement(Movement movement){
        movements.add(movement);
    }
}