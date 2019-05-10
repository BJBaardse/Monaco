package Shared.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Kilometertarief {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;

    private Date start;
    private Date expire;

    public Kilometertarief() {
    }

    public Kilometertarief(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Kilometertarief(String name, int price, Date start) {
        this.name = name;
        this.price = price;
        this.start = start;
    }

    public Kilometertarief(Date expire,String name, int price ) {
        this.name = name;
        this.price = price;
        this.expire = expire;
    }

    public Kilometertarief(String name, int price, Date start, Date expire) {
        this.name = name;
        this.price = price;
        this.start = start;
        this.expire = expire;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
