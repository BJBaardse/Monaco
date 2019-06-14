package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movements {
    @Id
    @GeneratedValue()
    private int ID;
    private String streetName;
    private double distance;
    private double duration;

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public Movements(){

    }
    public Movements(double duration, double distance, String streetName){
        setDuration(duration);
        setDistance(distance);
        setStreetName(streetName);
    }

    @Override
    public String toString() {
        return "Movements{" +
                "streetName='" + streetName + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
