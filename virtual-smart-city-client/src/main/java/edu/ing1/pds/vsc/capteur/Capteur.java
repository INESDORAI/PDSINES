package edu.ing1.pds.vsc.capteur;

/**
 *
 * @author Karim
 */
public class Capteur {
    private Integer id;
    private String typeCapteur;
    private Double valeurCapteur;
    private String code;    
    private String batiment;
    private String etage;
    private String numero;
    private Integer idLocal;
    private int idEnterprise;

    public Capteur() {
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

    public String getTypeCapteur() {
        return typeCapteur;
    }

    public void setTypeCapteur(String typeCapteur) {
        this.typeCapteur = typeCapteur;
    }

    public Double getValeurCapteur() {
        return valeurCapteur;
    }

    public void setValeurCapteur(Double valeurCapteur) {
        this.valeurCapteur = valeurCapteur;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(int idEnterprise) {
        this.idEnterprise = idEnterprise;
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
        final Capteur other = (Capteur) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
