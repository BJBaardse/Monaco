package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Eigenaar {
    @Id
    @GeneratedValue
    private int BSN;
    private String voornaam;
    private String achternaam;
    private String tussenvoegsel;
    @OneToMany
    private List<Voertuig> voertuigen;

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public int getBSN() {
        return BSN;
    }

    public List<Voertuig> getVoertuigen() {
        return voertuigen;
    }

    public void setVoertuigen(List<Voertuig> voertuigen) {
        this.voertuigen = voertuigen;
    }

    public Eigenaar(){

    }
}
