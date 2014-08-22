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
@Table(name = "obra_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObraSocial.findAll", query = "SELECT o FROM ObraSocial o"),
    @NamedQuery(name = "ObraSocial.findByCodIdObraSocial", query = "SELECT o FROM ObraSocial o WHERE o.codIdObraSocial = :codIdObraSocial"),
    @NamedQuery(name = "ObraSocial.findByNombreOs", query = "SELECT o FROM ObraSocial o WHERE o.nombreOs = :nombreOs"),
    @NamedQuery(name = "ObraSocial.findByDireccionOs", query = "SELECT o FROM ObraSocial o WHERE o.direccionOs = :direccionOs"),
    @NamedQuery(name = "ObraSocial.findByTelefOs", query = "SELECT o FROM ObraSocial o WHERE o.telefOs = :telefOs")})
public class ObraSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_id_obra_social")
    private Integer codIdObraSocial;
    @Size(max = 15)
    @Column(name = "nombre_os")
    private String nombreOs;
    @Size(max = 20)
    @Column(name = "direccion_os")
    private String direccionOs;
    @Column(name = "telef_os")
    private Integer telefOs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obraSocial")
    private Collection<ObraSocialPorPaciente> obraSocialPorPacienteCollection;

    public ObraSocial() {
    }

    public ObraSocial(Integer codIdObraSocial) {
        this.codIdObraSocial = codIdObraSocial;
    }

    public Integer getCodIdObraSocial() {
        return codIdObraSocial;
    }

    public void setCodIdObraSocial(Integer codIdObraSocial) {
        this.codIdObraSocial = codIdObraSocial;
    }

    public String getNombreOs() {
        return nombreOs;
    }

    public void setNombreOs(String nombreOs) {
        this.nombreOs = nombreOs;
    }

    public String getDireccionOs() {
        return direccionOs;
    }

    public void setDireccionOs(String direccionOs) {
        this.direccionOs = direccionOs;
    }

    public Integer getTelefOs() {
        return telefOs;
    }

    public void setTelefOs(Integer telefOs) {
        this.telefOs = telefOs;
    }

    @XmlTransient
    public Collection<ObraSocialPorPaciente> getObraSocialPorPacienteCollection() {
        return obraSocialPorPacienteCollection;
    }

    public void setObraSocialPorPacienteCollection(Collection<ObraSocialPorPaciente> obraSocialPorPacienteCollection) {
        this.obraSocialPorPacienteCollection = obraSocialPorPacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdObraSocial != null ? codIdObraSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObraSocial)) {
            return false;
        }
        ObraSocial other = (ObraSocial) object;
        if ((this.codIdObraSocial == null && other.codIdObraSocial != null) || (this.codIdObraSocial != null && !this.codIdObraSocial.equals(other.codIdObraSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObraSocial[ codIdObraSocial=" + codIdObraSocial + " ]";
    }
    
}
