package shared.models.movements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class rit implements Irit {


    private List<Imovement> movements = new ArrayList<>();

    private Date date;

    @Override
    public List<Imovement> getMovements() {
        return movements;
    }

    @Override
    public Date GetDate() {
        return date;
    }

    public void setMovements(List<Imovement> movements) {
        this.movements = movements;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
