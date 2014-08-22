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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "dias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dias.findAll", query = "SELECT d FROM Dias d"),
    @NamedQuery(name = "Dias.findByIddias", query = "SELECT d FROM Dias d WHERE d.iddias = :iddias"),
    @NamedQuery(name = "Dias.findByDescripcion", query = "SELECT d FROM Dias d WHERE d.descripcion = :descripcion")})
public class Dias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddias")
    private Integer iddias;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diasIddias")
    private Collection<GuardiasDiarias> guardiasDiariasCollection;

    public Dias() {
    }

    public Dias(Integer iddias) {
        this.iddias = iddias;
    }

    public Integer getIddias() {
        return iddias;
    }

    public void setIddias(Integer iddias) {
        this.iddias = iddias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<GuardiasDiarias> getGuardiasDiariasCollection() {
        return guardiasDiariasCollection;
    }

    public void setGuardiasDiariasCollection(Collection<GuardiasDiarias> guardiasDiariasCollection) {
        this.guardiasDiariasCollection = guardiasDiariasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddias != null ? iddias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dias)) {
            return false;
        }
        Dias other = (Dias) object;
        if ((this.iddias == null && other.iddias != null) || (this.iddias != null && !this.iddias.equals(other.iddias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dias[ iddias=" + iddias + " ]";
    }
    
}
