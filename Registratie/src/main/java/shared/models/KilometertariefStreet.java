package shared.models;


import javax.persistence.*;
import java.util.Date;
import shared.models.Kilometertarief;

@Entity
@NamedQueries({
        @NamedQuery(name = "AllStreet", query = "select  k  from KilometertariefStreet k "),
        @NamedQuery(name = "GetStreet", query = "select  k  from KilometertariefStreet k where k.street = :street"),

})

@Table(name = "KilometertariefStreet")
@PrimaryKeyJoinColumn(name = "Kilometertarief")
public class KilometertariefStreet extends Kilometertarief {

    private String street;

    public KilometertariefStreet() {

    }

    public KilometertariefStreet(String name, int price, String street) {
        super(name, price);
        this.street = street;
    }

    public KilometertariefStreet(String name, int price, Date start, String street) {
        super(name, price, start);
        this.street = street;
    }

    public KilometertariefStreet(Date expire, String name, int price, String street) {
        super(expire, name, price);
        this.street = street;
    }

    public KilometertariefStreet(String name, int price, Date start, Date expire, String street) {
        super(name, price, start, expire);
        this.street = street;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
