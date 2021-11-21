package edu.ing1.pds.vsc.capteur;

/**
 *
 * @author Ines
 */
public class CapteurAnnee {
    private int idEnterprise;
    private int annee;
    private int nbre;

    public CapteurAnnee() {
    }

    public int getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(int idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idEnterprise;
        hash = 71 * hash + this.annee;
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
        final CapteurAnnee other = (CapteurAnnee) obj;
        if (this.idEnterprise != other.idEnterprise) {
            return false;
        }
        if (this.annee != other.annee) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CapteurAnnee{" + "idEnterprise=" + idEnterprise + ", annee=" + annee + ", nbre=" + nbre + '}';
    }
    
    
}
