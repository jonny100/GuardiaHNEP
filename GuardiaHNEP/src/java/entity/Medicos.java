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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m"),
    @NamedQuery(name = "Medicos.findByMatriculaMed", query = "SELECT m FROM Medicos m WHERE m.matriculaMed = :matriculaMed"),
    @NamedQuery(name = "Medicos.findByDniMed", query = "SELECT m FROM Medicos m WHERE m.dniMed = :dniMed"),
    @NamedQuery(name = "Medicos.findByApellidoMed", query = "SELECT m FROM Medicos m WHERE m.apellidoMed = :apellidoMed"),
    @NamedQuery(name = "Medicos.findByNombreMed", query = "SELECT m FROM Medicos m WHERE m.nombreMed = :nombreMed"),
    @NamedQuery(name = "Medicos.findByDireccionMed", query = "SELECT m FROM Medicos m WHERE m.direccionMed = :direccionMed"),
    @NamedQuery(name = "Medicos.findByTelMed", query = "SELECT m FROM Medicos m WHERE m.telMed = :telMed")})
public class Medicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula_med")
    private Integer matriculaMed;
    @Column(name = "dni_med")
    private Integer dniMed;
    @Size(max = 20)
    @Column(name = "apellido_med")
    private String apellidoMed;
    @Size(max = 30)
    @Column(name = "nombre_med")
    private String nombreMed;
    @Size(max = 30)
    @Column(name = "direccion_med")
    private String direccionMed;
    @Column(name = "tel_med")
    private Integer telMed;
    @ManyToMany(mappedBy = "medicosCollection")
    private Collection<GuardiasDiarias> guardiasDiariasCollection;
    @ManyToMany(mappedBy = "medicosCollection")
    private Collection<Cargo> cargoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jefeServicio")
    private Collection<GuardiasDiarias> guardiasDiariasCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicosMatriculaMed")
    private Collection<HistClinica> histClinicaCollection;
    @JoinColumn(name = "especialidad_cod_id_esp", referencedColumnName = "cod_id_esp")
    @ManyToOne(optional = false)
    private Especialidad especialidadCodIdEsp;

    public Medicos() {
    }

    public Medicos(Integer matriculaMed) {
        this.matriculaMed = matriculaMed;
    }

    public Integer getMatriculaMed() {
        return matriculaMed;
    }

    public void setMatriculaMed(Integer matriculaMed) {
        this.matriculaMed = matriculaMed;
    }

    public Integer getDniMed() {
        return dniMed;
    }

    public void setDniMed(Integer dniMed) {
        this.dniMed = dniMed;
    }

    public String getApellidoMed() {
        return apellidoMed;
    }

    public void setApellidoMed(String apellidoMed) {
        this.apellidoMed = apellidoMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getDireccionMed() {
        return direccionMed;
    }

    public void setDireccionMed(String direccionMed) {
        this.direccionMed = direccionMed;
    }

    public Integer getTelMed() {
        return telMed;
    }

    public void setTelMed(Integer telMed) {
        this.telMed = telMed;
    }

    @XmlTransient
    public Collection<GuardiasDiarias> getGuardiasDiariasCollection() {
        return guardiasDiariasCollection;
    }

    public void setGuardiasDiariasCollection(Collection<GuardiasDiarias> guardiasDiariasCollection) {
        this.guardiasDiariasCollection = guardiasDiariasCollection;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @XmlTransient
    public Collection<GuardiasDiarias> getGuardiasDiariasCollection1() {
        return guardiasDiariasCollection1;
    }

    public void setGuardiasDiariasCollection1(Collection<GuardiasDiarias> guardiasDiariasCollection1) {
        this.guardiasDiariasCollection1 = guardiasDiariasCollection1;
    }

    @XmlTransient
    public Collection<HistClinica> getHistClinicaCollection() {
        return histClinicaCollection;
    }

    public void setHistClinicaCollection(Collection<HistClinica> histClinicaCollection) {
        this.histClinicaCollection = histClinicaCollection;
    }

    public Especialidad getEspecialidadCodIdEsp() {
        return especialidadCodIdEsp;
    }

    public void setEspecialidadCodIdEsp(Especialidad especialidadCodIdEsp) {
        this.especialidadCodIdEsp = especialidadCodIdEsp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaMed != null ? matriculaMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.matriculaMed == null && other.matriculaMed != null) || (this.matriculaMed != null && !this.matriculaMed.equals(other.matriculaMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Medicos[ matriculaMed=" + matriculaMed + " ]";
    }
    
}
