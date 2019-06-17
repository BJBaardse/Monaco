package shared.models.movements;

import java.util.Date;

public class move implements Imovement {

    private Double distance;
    private String streetName;
    private Date date;

    private Double duration;

    @Override
    public Double GetDistance() {
        return distance;
    }

    @Override
    public String GetStreetName() {
        return streetName;
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
        this.streetName = street;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
