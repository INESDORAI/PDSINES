package edu.ing1.pds.vsc.materiel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ines
 */
public class Materiel {

    private Integer id;
    private String code;
    private String lib;
    private String typeMateriel;
    private String uniteConsommation;
    private Double moyenneConsommation;
    private Double sommeConsommation;
    private String batiment;
    private String etage;
    private String numero;
    private Integer idLocal;
    private int idEnterprise;
    private List<ConsommationMateriel> consommationMaterielList;

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

    public String getTypeMateriel() {
        return typeMateriel;
    }

    public void setTypeMateriel(String typeMateriel) {
        this.typeMateriel = typeMateriel;
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

    public String getUniteConsommation() {
        return uniteConsommation;
    }

    public void setUniteConsommation(String uniteConsommation) {
        this.uniteConsommation = uniteConsommation;
    }

    public List<ConsommationMateriel> getConsommationMaterielList() {
        if (consommationMaterielList == null) {
            consommationMaterielList = new ArrayList<>();
        }
        return consommationMaterielList;
    }

    public void setConsommationMaterielList(List<ConsommationMateriel> consommationMaterielList) {
        this.consommationMaterielList = consommationMaterielList;
    }

    public Double getMoyenneConsommation() {
        return moyenneConsommation;
    }

    public void setMoyenneConsommation(Double moyenneConsommation) {
        this.moyenneConsommation = moyenneConsommation;
    }

    public Double getSommeConsommation() {
        return sommeConsommation;
    }

    public void setSommeConsommation(Double sommeConsommation) {
        this.sommeConsommation = sommeConsommation;
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
