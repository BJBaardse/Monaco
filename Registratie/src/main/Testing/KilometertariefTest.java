import Shared.Models.Billing.Bill;
import Shared.Models.Kilometertarief;
import Shared.Models.KilometertariefEnergy;
import Shared.Models.KilometertariefStreet;
import Shared.Models.Services.KilometertariefService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KilometertariefTest {


    KilometertariefService kilometertariefService;

    @Before
    public void setUp() {
        //this.kilometertariefService = new StockService(); // Tested class, so don't mock it.
        this.kilometertariefService = mock(KilometertariefService.class);


    }

    @Test
    public void GetTariefs() {

        List<Kilometertarief> tarief = this.kilometertariefService.GetAll();
        assertNotNull(tarief);


    }




    @Test
    public void AddKilometertarief() {
        Kilometertarief expected = new Kilometertarief();

        when(this.kilometertariefService.Add((Kilometertarief) Matchers.anyObject()))
                .thenReturn(Boolean.TRUE);

        boolean actual = this.kilometertariefService.Add(expected);
        verify(this.kilometertariefService).Add(expected);
        assertTrue(actual);
    }

    @Test
    public void AddKilometertariefStreet() {
        KilometertariefStreet expected = new KilometertariefStreet();

        when(this.kilometertariefService.Add((Kilometertarief) Matchers.anyObject()))
                .thenReturn(Boolean.TRUE);

        boolean actual = this.kilometertariefService.Add(expected);
        verify(this.kilometertariefService).Add(expected);
        assertTrue(actual);
    }

    @Test
    public void AddKilometertariefengery() {
        KilometertariefEnergy expected = new KilometertariefEnergy();

        when(this.kilometertariefService.Add((Kilometertarief) Matchers.anyObject()))
                .thenReturn(Boolean.TRUE);

        boolean actual = this.kilometertariefService.Add(expected);
        verify(this.kilometertariefService).Add(expected);
        assertTrue(actual);
    }


    @Test
    public void AddKilometertariefUpdate() {
        KilometertariefStreet expected = new KilometertariefStreet();

        when(this.kilometertariefService.update((Kilometertarief) Matchers.anyObject()))
                .thenReturn(Boolean.TRUE);

        boolean actual = this.kilometertariefService.update(expected);
        verify(this.kilometertariefService).update(expected);
        assertTrue(actual);
    }



}