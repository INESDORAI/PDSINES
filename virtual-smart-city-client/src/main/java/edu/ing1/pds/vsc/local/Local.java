package edu.ing1.pds.vsc.local;

import java.text.DecimalFormat;

/**
 *
 * @author Ines
 */
public class Local {

    private Integer id;
    private String lib;
    private String batiment;
    private String etage;
    private String numero;
    private Integer nbrePlace;
    private Integer nbrePlaceOccupe;
    private String tauxOccupation;
    private int nbreCapteur;
    private int nbreMateriel;
    private int nbreMobilier;
    private Integer idEnterprise;

    public Local() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(Integer nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    public Integer getNbrePlaceOccupe() {
        return nbrePlaceOccupe;
    }

    public void setNbrePlaceOccupe(Integer nbrePlaceOccupe) {
        this.nbrePlaceOccupe = nbrePlaceOccupe;
    }

    public Integer getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Integer idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getTauxOccupation() {
        if (nbrePlace == 0) {
            tauxOccupation = "0.00";
        }
        double taux = (nbrePlaceOccupe * Double.valueOf(100.00)) / nbrePlace;
        DecimalFormat df = new DecimalFormat("0.00");
        tauxOccupation = df.format(taux);
        return tauxOccupation;
    }

    public void setTauxOccupation(String tauxOccupation) {
        this.tauxOccupation = tauxOccupation;
    }

    public int getNbreCapteur() {
        return nbreCapteur;
    }

    public void setNbreCapteur(int nbreCapteur) {
        this.nbreCapteur = nbreCapteur;
    }

    public int getNbreMateriel() {
        return nbreMateriel;
    }

    public void setNbreMateriel(int nbreMateriel) {
        this.nbreMateriel = nbreMateriel;
    }

    public int getNbreMobilier() {
        return nbreMobilier;
    }

    public void setNbreMobilier(int nbreMobilier) {
        this.nbreMobilier = nbreMobilier;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Local other = (Local) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
