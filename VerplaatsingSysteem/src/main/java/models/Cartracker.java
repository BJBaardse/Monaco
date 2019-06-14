package models;

import java.util.ArrayList;

public class Cartracker {
    private int id;
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

    public Cartracker(int id, String beginTime, String endTime, ArrayList<Movements> movements, double totalDistance, double totalDuration){
        setMovements(movements);
        setId(id);
        setTotalDistance(totalDistance);
        setTotalDuration(totalDuration);
        setBeginTime(beginTime);
        setEndTime(endTime);
    }

    @Override
    public String toString() {
        return "Cartracker{" +
                "id=" + id +
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
    public Date convertStringToDate(String datumTijd){
        String[] splitted = datumTijd.split(" ");
        String[] datumSplit = splitted[0].split("-");
        String[] tijdSplit = splitted[1].split(":");

        Date convertedString = new Date();
        convertedString.setDay(datumSplit[0]);
        convertedString.setMonth(datumSplit[1]);
        convertedString.setYear(datumSplit[2]);
        convertedString.setHour(tijdSplit[0]);
        convertedString.setMinute(tijdSplit[1]);

        return convertedString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}