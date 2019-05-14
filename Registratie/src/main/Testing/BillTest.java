import Shared.Models.Billing.Bill;
import Shared.Models.Services.BillService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class BillTest {


    BillService billService;

    @Before
    public void setUp() {
        //this.kilometertariefService = new StockService(); // Tested class, so don't mock it.
        this.billService = mock(BillService.class);


    }

    @Test
    public void Getallbills() {

        List<Bill> bills = this.billService.GetAll();
        assertNotNull(bills);


    }



}
