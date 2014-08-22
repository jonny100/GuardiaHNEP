/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByDNIPac", query = "SELECT p FROM Paciente p WHERE p.dNIPac = :dNIPac"),
    @NamedQuery(name = "Paciente.findByApellidoPac", query = "SELECT p FROM Paciente p WHERE p.apellidoPac = :apellidoPac"),
    @NamedQuery(name = "Paciente.findByNombrePac", query = "SELECT p FROM Paciente p WHERE p.nombrePac = :nombrePac"),
    @NamedQuery(name = "Paciente.findByDomicilio", query = "SELECT p FROM Paciente p WHERE p.domicilio = :domicilio"),
    @NamedQuery(name = "Paciente.findByLocalidad", query = "SELECT p FROM Paciente p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Paciente.findByFechaNacPac", query = "SELECT p FROM Paciente p WHERE p.fechaNacPac = :fechaNacPac")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNI_Pac")
    private Integer dNIPac;
    @Size(max = 30)
    @Column(name = "Apellido_Pac")
    private String apellidoPac;
    @Size(max = 20)
    @Column(name = "Nombre_Pac")
    private String nombrePac;
    @Size(max = 40)
    @Column(name = "Domicilio")
    private String domicilio;
    @Size(max = 40)
    @Column(name = "Localidad")
    private String localidad;
    @Column(name = "Fecha_Nac_Pac")
    @Temporal(TemporalType.DATE)
    private Date fechaNacPac;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dniPac")
    private Collection<InternacionTransitoria> internacionTransitoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dniPaciente")
    private Collection<HistClinica> histClinicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<ObraSocialPorPaciente> obraSocialPorPacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<AdministrarMedicamentos> administrarMedicamentosCollection;
    @JoinColumn(name = "tutor_DNI_Tut", referencedColumnName = "DNI_Tut")
    @ManyToOne(optional = false)
    private Tutor tutorDNITut;

    public Paciente() {
    }

    public Paciente(Integer dNIPac) {
        this.dNIPac = dNIPac;
    }

    public Integer getDNIPac() {
        return dNIPac;
    }

    public void setDNIPac(Integer dNIPac) {
        this.dNIPac = dNIPac;
    }

    public String getApellidoPac() {
        return apellidoPac;
    }

    public void setApellidoPac(String apellidoPac) {
        this.apellidoPac = apellidoPac;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFechaNacPac() {
        return fechaNacPac;
    }

    public void setFechaNacPac(Date fechaNacPac) {
        this.fechaNacPac = fechaNacPac;
    }

    @XmlTransient
    public Collection<InternacionTransitoria> getInternacionTransitoriaCollection() {
        return internacionTransitoriaCollection;
    }

    public void setInternacionTransitoriaCollection(Collection<InternacionTransitoria> internacionTransitoriaCollection) {
        this.internacionTransitoriaCollection = internacionTransitoriaCollection;
    }

    @XmlTransient
    public Collection<HistClinica> getHistClinicaCollection() {
        return histClinicaCollection;
    }

    public void setHistClinicaCollection(Collection<HistClinica> histClinicaCollection) {
        this.histClinicaCollection = histClinicaCollection;
    }

    @XmlTransient
    public Collection<ObraSocialPorPaciente> getObraSocialPorPacienteCollection() {
        return obraSocialPorPacienteCollection;
    }

    public void setObraSocialPorPacienteCollection(Collection<ObraSocialPorPaciente> obraSocialPorPacienteCollection) {
        this.obraSocialPorPacienteCollection = obraSocialPorPacienteCollection;
    }

    @XmlTransient
    public Collection<AdministrarMedicamentos> getAdministrarMedicamentosCollection() {
        return administrarMedicamentosCollection;
    }

    public void setAdministrarMedicamentosCollection(Collection<AdministrarMedicamentos> administrarMedicamentosCollection) {
        this.administrarMedicamentosCollection = administrarMedicamentosCollection;
    }

    public Tutor getTutorDNITut() {
        return tutorDNITut;
    }

    public void setTutorDNITut(Tutor tutorDNITut) {
        this.tutorDNITut = tutorDNITut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dNIPac != null ? dNIPac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.dNIPac == null && other.dNIPac != null) || (this.dNIPac != null && !this.dNIPac.equals(other.dNIPac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paciente[ dNIPac=" + dNIPac + " ]";
    }
    
}
