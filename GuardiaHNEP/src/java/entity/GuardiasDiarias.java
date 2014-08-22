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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "guardias_diarias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuardiasDiarias.findAll", query = "SELECT g FROM GuardiasDiarias g"),
    @NamedQuery(name = "GuardiasDiarias.findByIdGuardiasDiarias", query = "SELECT g FROM GuardiasDiarias g WHERE g.idGuardiasDiarias = :idGuardiasDiarias"),
    @NamedQuery(name = "GuardiasDiarias.findByHoraInicio", query = "SELECT g FROM GuardiasDiarias g WHERE g.horaInicio = :horaInicio"),
    @NamedQuery(name = "GuardiasDiarias.findByHoraSalida", query = "SELECT g FROM GuardiasDiarias g WHERE g.horaSalida = :horaSalida")})
public class GuardiasDiarias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guardias_diarias")
    private Integer idGuardiasDiarias;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @JoinTable(name = "medicos_has_guardias_diarias", joinColumns = {
        @JoinColumn(name = "guardias_diarias_id_guardias_diarias", referencedColumnName = "id_guardias_diarias")}, inverseJoinColumns = {
        @JoinColumn(name = "medicos_matricula_med", referencedColumnName = "matricula_med")})
    @ManyToMany
    private Collection<Medicos> medicosCollection;
    @ManyToMany(mappedBy = "guardiasDiariasCollection")
    private Collection<Enfermero> enfermeroCollection;
    @JoinColumn(name = "dias_iddias", referencedColumnName = "iddias")
    @ManyToOne(optional = false)
    private Dias diasIddias;
    @JoinColumn(name = "jefe_servicio", referencedColumnName = "matricula_med")
    @ManyToOne(optional = false)
    private Medicos jefeServicio;

    public GuardiasDiarias() {
    }

    public GuardiasDiarias(Integer idGuardiasDiarias) {
        this.idGuardiasDiarias = idGuardiasDiarias;
    }

    public Integer getIdGuardiasDiarias() {
        return idGuardiasDiarias;
    }

    public void setIdGuardiasDiarias(Integer idGuardiasDiarias) {
        this.idGuardiasDiarias = idGuardiasDiarias;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @XmlTransient
    public Collection<Medicos> getMedicosCollection() {
        return medicosCollection;
    }

    public void setMedicosCollection(Collection<Medicos> medicosCollection) {
        this.medicosCollection = medicosCollection;
    }

    @XmlTransient
    public Collection<Enfermero> getEnfermeroCollection() {
        return enfermeroCollection;
    }

    public void setEnfermeroCollection(Collection<Enfermero> enfermeroCollection) {
        this.enfermeroCollection = enfermeroCollection;
    }

    public Dias getDiasIddias() {
        return diasIddias;
    }

    public void setDiasIddias(Dias diasIddias) {
        this.diasIddias = diasIddias;
    }

    public Medicos getJefeServicio() {
        return jefeServicio;
    }

    public void setJefeServicio(Medicos jefeServicio) {
        this.jefeServicio = jefeServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuardiasDiarias != null ? idGuardiasDiarias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuardiasDiarias)) {
            return false;
        }
        GuardiasDiarias other = (GuardiasDiarias) object;
        if ((this.idGuardiasDiarias == null && other.idGuardiasDiarias != null) || (this.idGuardiasDiarias != null && !this.idGuardiasDiarias.equals(other.idGuardiasDiarias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GuardiasDiarias[ idGuardiasDiarias=" + idGuardiasDiarias + " ]";
    }
    
}
