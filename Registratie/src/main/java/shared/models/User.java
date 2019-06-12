package shared.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import shared.models.billing.Bill;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name ="Users")
@NamedQueries({
        @NamedQuery(name = "login", query = "select  u  from User u where u.email = :email  AND u.password = :password"),
        @NamedQuery(name = "ID", query = "select  u  from User u where u.id = :ID")
})
@JsonIgnoreProperties(ignoreUnknown = false)
public class User implements Serializable {
    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //this is the user id
    private String name;
    private String lastname;
    @Email
    @Column(unique=true)
    private String email;

    @NotEmpty(message = "password cannot be Empty")

    @JsonIgnore
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "Users_roles",
            joinColumns       = @JoinColumn(name = "id", nullable=false),
            uniqueConstraints = { @UniqueConstraint(columnNames={"ID","Role_Name"}) } )
    @Enumerated(EnumType.STRING)
    @Column(name="Role_Name", nullable=false)
    private List<Role> Roles;
    private int BSN;
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "Owner")
//    private List<Vehicle> Vehicles = new ArrayList<>();

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user")
    private List<Bill> bills = new ArrayList<>();

    @JsonIgnore
    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setRoles(List<Role> roles) {
        Roles = roles;
    }

    public int getBSN() {
        return BSN;
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

//    public List<Vehicle> getVehicle() {
//        return Vehicles;
//    }
//
//    public void setVehicle(List<Vehicle> vehicle) {
//        Vehicles = vehicle;
//    }
//
//    public void addVehicle(Vehicle vehicle) {
//        Vehicles.add(vehicle);
//    }

    public User() {
    }

    public User(String name, String lastname, @Email String email, @NotEmpty(message = "password cannot be Empty") String password, List<Role> roles, int BSN) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        Roles = roles;
        this.BSN = BSN;
    }
}
