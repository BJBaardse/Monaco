package shared.models.movements;

import java.util.Date;

public class move implements Imovement {

    private Double distance;
    private String street;
    private Date date;

    private Double duration;

    @Override
    public Double GetDistance() {
        return distance;
    }

    @Override
    public String GetStreet() {
        return street;
    }

    @Override
    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }


    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
