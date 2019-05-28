package shared.models;


import shared.models.enums.Energy;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "GetEnergy", query = "select  k  from KilometertariefEnergy k where  k.energy = :energy")
})
public class KilometertariefEnergy extends Kilometertarief {

    private Energy energy;

    public KilometertariefEnergy() {

    }

    public KilometertariefEnergy(String name, int price, Energy energy) {
        super(name, price);
        this.energy = energy;
    }

    public KilometertariefEnergy(String name, int price, Date start, Energy energy) {
        super(name, price, start);
        this.energy = energy;
    }

    public KilometertariefEnergy(Date expire, String name, int price, Energy energy) {
        super(expire, name, price);
        this.energy = energy;
    }

    public KilometertariefEnergy(String name, int price, Date start, Date expire, Energy energy) {
        super(name, price, start, expire);
        this.energy = energy;
    }


    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }
}
