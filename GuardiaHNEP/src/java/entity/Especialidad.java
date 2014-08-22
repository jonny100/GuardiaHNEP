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
@Table(name = "especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByCodIdEsp", query = "SELECT e FROM Especialidad e WHERE e.codIdEsp = :codIdEsp"),
    @NamedQuery(name = "Especialidad.findByNombreEsp", query = "SELECT e FROM Especialidad e WHERE e.nombreEsp = :nombreEsp")})
public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_id_esp")
    private Integer codIdEsp;
    @Size(max = 20)
    @Column(name = "nombre_esp")
    private String nombreEsp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidadCodIdEsp")
    private Collection<Medicos> medicosCollection;

    public Especialidad() {
    }

    public Especialidad(Integer codIdEsp) {
        this.codIdEsp = codIdEsp;
    }

    public Integer getCodIdEsp() {
        return codIdEsp;
    }

    public void setCodIdEsp(Integer codIdEsp) {
        this.codIdEsp = codIdEsp;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    @XmlTransient
    public Collection<Medicos> getMedicosCollection() {
        return medicosCollection;
    }

    public void setMedicosCollection(Collection<Medicos> medicosCollection) {
        this.medicosCollection = medicosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdEsp != null ? codIdEsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.codIdEsp == null && other.codIdEsp != null) || (this.codIdEsp != null && !this.codIdEsp.equals(other.codIdEsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Especialidad[ codIdEsp=" + codIdEsp + " ]";
    }
    
}
