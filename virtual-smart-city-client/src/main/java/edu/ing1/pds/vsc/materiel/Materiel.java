package edu.ing1.pds.vsc.materiel;

/**
 *
 * @author Karim
 */
public class Materiel {

    private Integer id;
    private String code;
    private String lib;
    private String typeMobilier;
    private Double consommation;
    private String uniteConsommation;
    private String batiment;
    private String etage;
    private String numero;
    private int idLocal;
    private int idEnterprise;

    public Materiel() {
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

    public String getTypeMobilier() {
        return typeMobilier;
    }

    public void setTypeMobilier(String typeMobilier) {
        this.typeMobilier = typeMobilier;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
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

    public Double getConsommation() {
        if (consommation == null) {
            consommation = 0.0;
        }
        return consommation;
    }

    public void setConsommation(Double consommation) {
        this.consommation = consommation;
    }

    public String getUniteConsommation() {
        return uniteConsommation;
    }

    public void setUniteConsommation(String uniteConsommation) {
        this.uniteConsommation = uniteConsommation;
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
        final Materiel other = (Materiel) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
