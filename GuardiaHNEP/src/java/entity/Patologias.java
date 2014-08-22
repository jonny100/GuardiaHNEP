/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "patologias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patologias.findAll", query = "SELECT p FROM Patologias p"),
    @NamedQuery(name = "Patologias.findByCodPatologia", query = "SELECT p FROM Patologias p WHERE p.codPatologia = :codPatologia"),
    @NamedQuery(name = "Patologias.findByNomPatologia", query = "SELECT p FROM Patologias p WHERE p.nomPatologia = :nomPatologia")})
public class Patologias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_patologia")
    private Integer codPatologia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_patologia")
    private String nomPatologia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPatologia")
    private Collection<HistClinica> histClinicaCollection;

    public Patologias() {
    }

    public Patologias(Integer codPatologia) {
        this.codPatologia = codPatologia;
    }

    public Patologias(Integer codPatologia, String nomPatologia) {
        this.codPatologia = codPatologia;
        this.nomPatologia = nomPatologia;
    }

    public Integer getCodPatologia() {
        return codPatologia;
    }

    public void setCodPatologia(Integer codPatologia) {
        this.codPatologia = codPatologia;
    }

    public String getNomPatologia() {
        return nomPatologia;
    }

    public void setNomPatologia(String nomPatologia) {
        this.nomPatologia = nomPatologia;
    }

    @XmlTransient
    public Collection<HistClinica> getHistClinicaCollection() {
        return histClinicaCollection;
    }

    public void setHistClinicaCollection(Collection<HistClinica> histClinicaCollection) {
        this.histClinicaCollection = histClinicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPatologia != null ? codPatologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patologias)) {
            return false;
        }
        Patologias other = (Patologias) object;
        if ((this.codPatologia == null && other.codPatologia != null) || (this.codPatologia != null && !this.codPatologia.equals(other.codPatologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Patologias[ codPatologia=" + codPatologia + " ]";
    }
    
}
