package shared.models.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.modules.junit4.PowerMockRunner;
import shared.models.User;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class VehicleTest {

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = mock(UserService.class);

    }

    @Test
    public void GetUsers() {
        List<User> users = this.userService.GetUsers();
        assertNotNull(users);
    }


    @Test
    public void GetUserbyEmailandPassword() {
        User expected = new User();
        expected.setEmail("test");

        when(this.userService.GetUser(Matchers.anyString(),Matchers.anyString()))
                .thenReturn(expected);

        User actual = this.userService.GetUser("test","password");
        verify(this.userService).GetUser("test","password");
        assertEquals(actual,expected);
    }



    @Test
    public void GetUserbyID() {
        User expected = new User();
        expected.setEmail("test");
        expected.setId(2);

        when(this.userService.GetUserID(Matchers.anyInt()))
                .thenReturn(expected);

        User actual = this.userService.GetUserID(2);
        verify(this.userService).GetUserID(2);
        assertEquals(actual,expected);
    }
}
