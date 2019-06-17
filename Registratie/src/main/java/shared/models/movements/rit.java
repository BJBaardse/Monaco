package shared.models.movements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class rit implements Irit {


    private List<move> movements = new ArrayList<>();

    private Date beginDateTime;

    private Date endDateTime;

    private Double totalDistance;

    private Double totalDuration;


    public List<move> getMovements() {
        return movements;
    }


    public Date GetBeginDateTime() {
        return beginDateTime;
    }

    public void setMovements(List<move> movements) {
        this.movements = movements;
    }

    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Double totalDuration) {
        this.totalDuration = totalDuration;
    }
}
