package Shared.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Entity
@Table(name ="Users")
@Cacheable(false)
@NamedQuery(name = "login", query = "select  u  from User u where u.email = :email  AND u.password = :password")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastname;
    @Email
    @Column(unique=true)
    private String email;

    @NotEmpty(message = "password cannot be Empty")
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "Users_roles",
            joinColumns       = @JoinColumn(name = "id", nullable=false),
            uniqueConstraints = { @UniqueConstraint(columnNames={"ID","Role_Name"}) } )
    @Enumerated(EnumType.STRING)
    @Column(name="Role_Name", nullable=false)
    private List<Role> Roles;
    private int BSN;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
