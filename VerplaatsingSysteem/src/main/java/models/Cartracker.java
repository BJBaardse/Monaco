package models;

import java.util.ArrayList;
import java.util.Date;

public class Cartracker {
    private int cartrackerID;
    private ArrayList<Movements> movements;
    private double totalDistance;
    private double totalDuration;
    private String beginTime;
    private String endTime;
    private Date beginDateTime;
    private Date endDateTime;

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

    public ArrayList getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movements> movements) {
        this.movements = movements;
    }

    public Cartracker(){

    }

    public Cartracker(int cartrackerID, String beginTime, String endTime, ArrayList<Movements> movements, double totalDistance, double totalDuration){
        setMovements(movements);
        setCartrackerID(cartrackerID);
        setTotalDistance(totalDistance);
        setTotalDuration(totalDuration);
        setBeginTime(beginTime);
        setEndTime(endTime);
    }

    @Override
    public String toString() {
        return "Cartracker{" +
                "cartrackerID=" + cartrackerID +
                ", movements=" + movements +
                ", totalDistance=" + totalDistance +
                ", totalDuration=" + totalDuration +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }


    public int getCartrackerID() {
        return cartrackerID;
    }

    public void setCartrackerID(int cartrackerID) {
        this.cartrackerID = cartrackerID;
    }
}