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
@Table(name = "tutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByDNITut", query = "SELECT t FROM Tutor t WHERE t.dNITut = :dNITut"),
    @NamedQuery(name = "Tutor.findByApellidoTut", query = "SELECT t FROM Tutor t WHERE t.apellidoTut = :apellidoTut"),
    @NamedQuery(name = "Tutor.findByNombreTut", query = "SELECT t FROM Tutor t WHERE t.nombreTut = :nombreTut"),
    @NamedQuery(name = "Tutor.findByTelefono", query = "SELECT t FROM Tutor t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Tutor.findByFamiliaridad", query = "SELECT t FROM Tutor t WHERE t.familiaridad = :familiaridad")})
public class Tutor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNI_Tut")
    private Integer dNITut;
    @Size(max = 30)
    @Column(name = "Apellido_Tut")
    private String apellidoTut;
    @Size(max = 20)
    @Column(name = "Nombre_Tut")
    private String nombreTut;
    @Column(name = "telefono")
    private Integer telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "familiaridad")
    private String familiaridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorDNITut")
    private Collection<Paciente> pacienteCollection;

    public Tutor() {
    }

    public Tutor(Integer dNITut) {
        this.dNITut = dNITut;
    }

    public Tutor(Integer dNITut, String familiaridad) {
        this.dNITut = dNITut;
        this.familiaridad = familiaridad;
    }

    public Integer getDNITut() {
        return dNITut;
    }

    public void setDNITut(Integer dNITut) {
        this.dNITut = dNITut;
    }

    public String getApellidoTut() {
        return apellidoTut;
    }

    public void setApellidoTut(String apellidoTut) {
        this.apellidoTut = apellidoTut;
    }

    public String getNombreTut() {
        return nombreTut;
    }

    public void setNombreTut(String nombreTut) {
        this.nombreTut = nombreTut;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getFamiliaridad() {
        return familiaridad;
    }

    public void setFamiliaridad(String familiaridad) {
        this.familiaridad = familiaridad;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dNITut != null ? dNITut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.dNITut == null && other.dNITut != null) || (this.dNITut != null && !this.dNITut.equals(other.dNITut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tutor[ dNITut=" + dNITut + " ]";
    }
    
}
