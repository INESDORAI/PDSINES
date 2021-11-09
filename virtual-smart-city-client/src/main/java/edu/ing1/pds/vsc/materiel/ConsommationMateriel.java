
package edu.ing1.pds.vsc.materiel;

import java.util.Objects;

/**
 *
 * @author Ines
 */
public class ConsommationMateriel {
    private Integer id;
    private String datePrelevement;
    private Double valeur;
    private int idMateriel;

    public ConsommationMateriel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatePrelevement() {
        return datePrelevement;
    }

    public void setDatePrelevement(String datePrelevement) {
        this.datePrelevement = datePrelevement;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final ConsommationMateriel other = (ConsommationMateriel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
