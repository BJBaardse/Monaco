package models;

import java.util.ArrayList;

public class Cartracker {
    private ArrayList movements;
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

    public ArrayList getMovements() {
        return movements;
    }

    public void setMovements(ArrayList movements) {
        this.movements = movements;
    }

    public Cartracker(){

    }

    public Cartracker(ArrayList movements, double totalDistance, double totalDuration, String begintime, String endtime){
        setMovements(movements);
        setTotalDistance(totalDistance);
        setTotalDuration(totalDuration);
        setBeginTime(begintime);
        setEndTime(endtime);
    }
}