package shared.models.movements;

import java.util.Date;

public class move implements Imovement {

    private int distance;
    private String street;
    private Date date;

    @Override
    public int GetDistance() {
        return distance;
    }

    @Override
    public String GetStreet() {
        return street;
    }

    @Override
    public Date getDate() {
        return date;
    }


    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
