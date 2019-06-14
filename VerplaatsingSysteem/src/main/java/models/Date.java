package models;

public class Date {
    private String day;
    private String month;
    private String year;
    private String hour;
    private String minute;

    public Date(){

    }
    public Date(String day, String month, String year, String hour, String minute){
         setDay(day);
         setMonth(month);
         setHour(hour);
         setYear(year);
         setMinute(minute);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", hour='" + hour + '\'' +
                ", minute='" + minute + '\'' +
                '}';
    }
}
