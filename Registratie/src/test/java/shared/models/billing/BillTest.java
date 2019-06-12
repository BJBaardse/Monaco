package shared.models.billing;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import shared.models.Kilometertarief;
import shared.models.services.BillService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class BillTest {


    BillService billService;

    private BillLogic billLogic;

    @Before
    public void setUp() {

        this.billService = mock(BillService.class);
        this.billLogic = new BillLogic();


    }

    @Test
    public void Getallbills() {

        List<Bill> bills = this.billService.GetAll();


        assertNotNull(bills);


    }



    @Test
    public void testBilllogicGetLatest() throws Exception {

        List<Kilometertarief> kilometertariefs = new ArrayList<>();

        Calendar calendardate1 = Calendar.getInstance();

        calendardate1.setTimeInMillis(1559901460168L);
        Date date = calendardate1.getTime();


        Calendar calendardate2 = Calendar.getInstance();

        calendardate2.setTimeInMillis(1659901560168L);
        Date date2 = calendardate2.getTime();

        Kilometertarief kilometertariefdate1 = new Kilometertarief("test",10,date,date2);
        kilometertariefs.add(kilometertariefdate1);



        Calendar calendardate3 = Calendar.getInstance();

        calendardate3.setTimeInMillis(1569901460168L);
        Date date3 = calendardate3.getTime();


        Calendar calendardate4 = Calendar.getInstance();

        calendardate4.setTimeInMillis(1659901560168L);
        Date date4 = calendardate4.getTime();

        Kilometertarief kilometertariefdate2 = new Kilometertarief("test2",12,date3,date4);
        kilometertariefs.add(kilometertariefdate2);



        Calendar caldatecheck = Calendar.getInstance();

        caldatecheck.setTimeInMillis(1579901560168L);
        Date datacheck = caldatecheck.getTime();


        Kilometertarief kilometertarief = Whitebox.invokeMethod(billLogic,"GetLatest",kilometertariefs,datacheck);


        assertNotNull(kilometertarief);
        assertEquals(kilometertarief, kilometertariefdate2);




    }





}
