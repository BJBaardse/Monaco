package Shared.Models;

import java.io.Serializable;
import java.util.List;

public interface IUser extends Serializable {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public String getLastname();

    public void setLastname(String lastname);

    public String getEmail();

    public void setEmail(String email);

    public String getPassword();

    public void setPassword(String password);

    public List<Role> getRoles();

    public void setRoles(List<Role> roles);

    public int getBSN();

    public void setBSN(int BSN);

    public List<Shared.Models.Vehicle> getVehicle();

    public void setVehicle(List<Shared.Models.Vehicle> vehicle);

    public void addVehicle(Shared.Models.Vehicle vehicle) ;




}
