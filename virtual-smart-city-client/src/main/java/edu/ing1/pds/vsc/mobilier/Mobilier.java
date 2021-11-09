package edu.ing1.pds.vsc.mobilier;

/**
 *
 * @author Ines
 */
public class Mobilier {
    private Integer id;
    private String typeMobilier;
    private String lib;
    private String code;    
    private String batiment;
    private String etage;
    private String numero;
    private Integer idLocal;
    private int idEnterprise;

    public Mobilier() {
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
        final Mobilier other = (Mobilier) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
