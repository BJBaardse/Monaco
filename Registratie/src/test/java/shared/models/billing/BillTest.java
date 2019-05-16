package shared.models.billing;

import org.junit.Before;
import org.junit.Test;
import shared.models.services.BillService;

import java.util.List;

import static org.junit.Assert.assertNotNull;
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
