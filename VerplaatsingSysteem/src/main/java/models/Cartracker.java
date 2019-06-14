package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartracker {
    @Id
    @GeneratedValue
    private int ID;
    @OneToMany( fetch = FetchType.EAGER)
    @JoinTable
    private List<Movements> movements = new ArrayList<>();
    private double totalDistance;
    private double totalDuration;
    private String beginTime;
    private String endTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public List<Movements> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movements> movements) {
        this.movements = movements;
    }

    public Cartracker(){

    }

    public Cartracker(String beginTime, String endTime, ArrayList<Movements> movements, double totalDistance, double totalDuration){
        setMovements(movements);
        setTotalDistance(totalDistance);
        setTotalDuration(totalDuration);
        setBeginTime(beginTime);
        setEndTime(endTime);
    }

    @Override
    public String toString() {
        return "Cartracker{" +
                "movements=" + movements +
                ", totalDistance=" + totalDistance +
                ", totalDuration=" + totalDuration +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}