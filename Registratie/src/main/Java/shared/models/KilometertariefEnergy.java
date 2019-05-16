package shared.models;


import shared.models.enums.Energy;

import javax.persistence.Entity;
import java.util.Date;

@Entity
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
