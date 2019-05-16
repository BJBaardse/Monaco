package shared.models.billing;

import shared.models.Kilometertarief;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movement {
    @Id
    @GeneratedValue
    private int ID;
    private String street;
    private int kilometers;
    @ManyToOne
    private Kilometertarief BaseTarief;
    @ManyToOne
    private Kilometertarief additionTarief;



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public Kilometertarief getBaseTarief() {
        return BaseTarief;
    }

    public void setBaseTarief(Kilometertarief baseTarief) {
        BaseTarief = baseTarief;
    }

    public Kilometertarief getAdditionTarief() {
        return additionTarief;
    }

    public void setAdditionTarief(Kilometertarief additionTarief) {
        this.additionTarief = additionTarief;
    }
}
