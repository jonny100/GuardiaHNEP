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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "enfermero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermero.findAll", query = "SELECT e FROM Enfermero e"),
    @NamedQuery(name = "Enfermero.findByDniEnferm", query = "SELECT e FROM Enfermero e WHERE e.dniEnferm = :dniEnferm"),
    @NamedQuery(name = "Enfermero.findByApellEnferm", query = "SELECT e FROM Enfermero e WHERE e.apellEnferm = :apellEnferm"),
    @NamedQuery(name = "Enfermero.findByNombreEnfer", query = "SELECT e FROM Enfermero e WHERE e.nombreEnfer = :nombreEnfer"),
    @NamedQuery(name = "Enfermero.findByDireccion", query = "SELECT e FROM Enfermero e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Enfermero.findByTelEnfer", query = "SELECT e FROM Enfermero e WHERE e.telEnfer = :telEnfer")})
public class Enfermero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni_enferm")
    private Integer dniEnferm;
    @Size(max = 20)
    @Column(name = "apell_enferm")
    private String apellEnferm;
    @Size(max = 20)
    @Column(name = "nombre_enfer")
    private String nombreEnfer;
    @Size(max = 20)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tel_enfer")
    private Integer telEnfer;
    @JoinTable(name = "enfermero_has_guardias_diarias", joinColumns = {
        @JoinColumn(name = "enfermero_dni_enferm", referencedColumnName = "dni_enferm")}, inverseJoinColumns = {
        @JoinColumn(name = "guardias_diarias_id_guardias_diarias", referencedColumnName = "id_guardias_diarias")})
    @ManyToMany
    private Collection<GuardiasDiarias> guardiasDiariasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dniEnferm")
    private Collection<AdministrarMedicamentos> administrarMedicamentosCollection;

    public Enfermero() {
    }

    public Enfermero(Integer dniEnferm) {
        this.dniEnferm = dniEnferm;
    }

    public Integer getDniEnferm() {
        return dniEnferm;
    }

    public void setDniEnferm(Integer dniEnferm) {
        this.dniEnferm = dniEnferm;
    }

    public String getApellEnferm() {
        return apellEnferm;
    }

    public void setApellEnferm(String apellEnferm) {
        this.apellEnferm = apellEnferm;
    }

    public String getNombreEnfer() {
        return nombreEnfer;
    }

    public void setNombreEnfer(String nombreEnfer) {
        this.nombreEnfer = nombreEnfer;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelEnfer() {
        return telEnfer;
    }

    public void setTelEnfer(Integer telEnfer) {
        this.telEnfer = telEnfer;
    }

    @XmlTransient
    public Collection<GuardiasDiarias> getGuardiasDiariasCollection() {
        return guardiasDiariasCollection;
    }

    public void setGuardiasDiariasCollection(Collection<GuardiasDiarias> guardiasDiariasCollection) {
        this.guardiasDiariasCollection = guardiasDiariasCollection;
    }

    @XmlTransient
    public Collection<AdministrarMedicamentos> getAdministrarMedicamentosCollection() {
        return administrarMedicamentosCollection;
    }

    public void setAdministrarMedicamentosCollection(Collection<AdministrarMedicamentos> administrarMedicamentosCollection) {
        this.administrarMedicamentosCollection = administrarMedicamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniEnferm != null ? dniEnferm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermero)) {
            return false;
        }
        Enfermero other = (Enfermero) object;
        if ((this.dniEnferm == null && other.dniEnferm != null) || (this.dniEnferm != null && !this.dniEnferm.equals(other.dniEnferm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Enfermero[ dniEnferm=" + dniEnferm + " ]";
    }
    
}
