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
@Table(name = "internacion_transitoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InternacionTransitoria.findAll", query = "SELECT i FROM InternacionTransitoria i"),
    @NamedQuery(name = "InternacionTransitoria.findByNumIntern", query = "SELECT i FROM InternacionTransitoria i WHERE i.numIntern = :numIntern"),
    @NamedQuery(name = "InternacionTransitoria.findByFechaIngreso", query = "SELECT i FROM InternacionTransitoria i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "InternacionTransitoria.findByFechaAlta", query = "SELECT i FROM InternacionTransitoria i WHERE i.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "InternacionTransitoria.findByMotivoAlta", query = "SELECT i FROM InternacionTransitoria i WHERE i.motivoAlta = :motivoAlta"),
    @NamedQuery(name = "InternacionTransitoria.findByTraslado", query = "SELECT i FROM InternacionTransitoria i WHERE i.traslado = :traslado")})
public class InternacionTransitoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_intern")
    private Integer numIntern;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Size(max = 20)
    @Column(name = "motivo_alta")
    private String motivoAlta;
    @Size(max = 20)
    @Column(name = "traslado")
    private String traslado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "internacionTransitoriaNumIntern")
    private Collection<Camas> camasCollection;
    @JoinColumn(name = "dni_pac", referencedColumnName = "DNI_Pac")
    @ManyToOne(optional = false)
    private Paciente dniPac;

    public InternacionTransitoria() {
    }

    public InternacionTransitoria(Integer numIntern) {
        this.numIntern = numIntern;
    }

    public Integer getNumIntern() {
        return numIntern;
    }

    public void setNumIntern(Integer numIntern) {
        this.numIntern = numIntern;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getMotivoAlta() {
        return motivoAlta;
    }

    public void setMotivoAlta(String motivoAlta) {
        this.motivoAlta = motivoAlta;
    }

    public String getTraslado() {
        return traslado;
    }

    public void setTraslado(String traslado) {
        this.traslado = traslado;
    }

    @XmlTransient
    public Collection<Camas> getCamasCollection() {
        return camasCollection;
    }

    public void setCamasCollection(Collection<Camas> camasCollection) {
        this.camasCollection = camasCollection;
    }

    public Paciente getDniPac() {
        return dniPac;
    }

    public void setDniPac(Paciente dniPac) {
        this.dniPac = dniPac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIntern != null ? numIntern.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InternacionTransitoria)) {
            return false;
        }
        InternacionTransitoria other = (InternacionTransitoria) object;
        if ((this.numIntern == null && other.numIntern != null) || (this.numIntern != null && !this.numIntern.equals(other.numIntern))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InternacionTransitoria[ numIntern=" + numIntern + " ]";
    }
    
}
