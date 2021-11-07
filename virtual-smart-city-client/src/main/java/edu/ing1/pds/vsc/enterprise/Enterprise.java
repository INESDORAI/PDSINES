package edu.ing1.pds.vsc.enterprise;

/**
 *
 * @author Karim
 */
public class Enterprise {
    private Integer id;
    private String code;
    private String lib;
    private String adresse;
    private String codePostal;
    private String pays;
    private Integer nbreLocal;
    private Integer nbreCapteur;
    private Integer nbreMateriel;
    private Integer nbreMobilier;

    public Enterprise() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getNbreLocal() {
        return nbreLocal;
    }

    public void setNbreLocal(Integer nbreLocal) {
        this.nbreLocal = nbreLocal;
    }

    public Integer getNbreCapteur() {
        return nbreCapteur;
    }

    public void setNbreCapteur(Integer nbreCapteur) {
        this.nbreCapteur = nbreCapteur;
    }

    public Integer getNbreMateriel() {
        return nbreMateriel;
    }

    public void setNbreMateriel(Integer nbreMateriel) {
        this.nbreMateriel = nbreMateriel;
    }

    public Integer getNbreMobilier() {
        return nbreMobilier;
    }

    public void setNbreMobilier(Integer nbreMobilier) {
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
        final Enterprise other = (Enterprise) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
