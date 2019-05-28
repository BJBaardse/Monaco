package shared.models.billing;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Movement> movements = new ArrayList<>();

    private Double price;
    private int Kilometers;


    public Ride() {
    }

    public Ride(Date date) {
        this.date = date;
    }

    public double getPrice(){

        return price;
    }

    public double GetPrices(){
        double price = 0;

        for( Movement movement : movements){
            double baseprice = movement.getBaseTarief().getPrice();
            if(movement.getAdditionTarief() != null) {
                double Additionprice = movement.getAdditionTarief().getPrice();

                price += baseprice * (Additionprice / 100 + 1) * movement.getKilometers();
            } else {
                price += baseprice * movement.getKilometers();
            }

        }
        this.price = price;
        return price;
    }

    public int getKilometers() {
        return Kilometers;
    }

    public void CalcData(){
        CalcPrice();
        CalcKilometers();
    }

    public void CalcPrice(){
            double price = 0;

            for( Movement movement : movements){
                double baseprice = movement.getBaseTarief().getPrice();
                if(movement.getAdditionTarief() != null) {
                    double Additionprice = movement.getAdditionTarief().getPrice();

                    price += baseprice * (Additionprice / 100 + 1) * movement.getKilometers();
                } else {
                    price += baseprice * movement.getKilometers();
                }

            }
            this.price = price;
    }

    public void CalcKilometers(){

        int kilometers = 0;

        for(Movement movement : movements){
            kilometers += movement.getKilometers();
        }
        this.Kilometers = kilometers;

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


    public void AddMovement(Movement movement){
        movements.add(movement);
    }

    public int getKilometersCalc(){
        int kilometers = 0;

        for(Movement movement : movements){
            kilometers += movement.getKilometers();
        }

        return kilometers;


    }
}