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
@Table(name = "diagnosticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnosticos.findAll", query = "SELECT d FROM Diagnosticos d"),
    @NamedQuery(name = "Diagnosticos.findByCodDiagnostico", query = "SELECT d FROM Diagnosticos d WHERE d.codDiagnostico = :codDiagnostico"),
    @NamedQuery(name = "Diagnosticos.findByNomDiagnostico", query = "SELECT d FROM Diagnosticos d WHERE d.nomDiagnostico = :nomDiagnostico")})
public class Diagnosticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_diagnostico")
    private Integer codDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_diagnostico")
    private String nomDiagnostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDiagnostico")
    private Collection<HistClinica> histClinicaCollection;

    public Diagnosticos() {
    }

    public Diagnosticos(Integer codDiagnostico) {
        this.codDiagnostico = codDiagnostico;
    }

    public Diagnosticos(Integer codDiagnostico, String nomDiagnostico) {
        this.codDiagnostico = codDiagnostico;
        this.nomDiagnostico = nomDiagnostico;
    }

    public Integer getCodDiagnostico() {
        return codDiagnostico;
    }

    public void setCodDiagnostico(Integer codDiagnostico) {
        this.codDiagnostico = codDiagnostico;
    }

    public String getNomDiagnostico() {
        return nomDiagnostico;
    }

    public void setNomDiagnostico(String nomDiagnostico) {
        this.nomDiagnostico = nomDiagnostico;
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
        hash += (codDiagnostico != null ? codDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosticos)) {
            return false;
        }
        Diagnosticos other = (Diagnosticos) object;
        if ((this.codDiagnostico == null && other.codDiagnostico != null) || (this.codDiagnostico != null && !this.codDiagnostico.equals(other.codDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Diagnosticos[ codDiagnostico=" + codDiagnostico + " ]";
    }
    
}
