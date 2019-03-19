package model;

import javax.persistence.*;

@Entity
public class Voertuig {
    @Id
    @GeneratedValue
    private int voertuigID;
    private String kenteken;
    private boolean gestolen;
    private int gewicht;
    private int aantalWielen;
    @ManyToOne
    private Eigenaar eigenaar;

    public int getVoertuigID() {
        return voertuigID;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public boolean isGestolen() {
        return gestolen;
    }

    public void setGestolen(boolean gestolen) {
        this.gestolen = gestolen;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public int getAantalWielen() {
        return aantalWielen;
    }

    public void setAantalWielen(int aantalWielen) {
        this.aantalWielen = aantalWielen;
    }

    public Eigenaar getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(Eigenaar eigenaar) {
        this.eigenaar = eigenaar;
    }

    public Voertuig() {

    }
}
