package shared.models.movements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class rit implements Irit {


    private List<move> movements = new ArrayList<>();

    private Date date;


    public List<move> getMovements() {
        return movements;
    }


    public Date GetBeginDateTime() {
        return date;
    }

    public void setMovements(List<move> movements) {
        this.movements = movements;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
