/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "hist_clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistClinica.findAll", query = "SELECT h FROM HistClinica h"),
    @NamedQuery(name = "HistClinica.findByNumHisClin", query = "SELECT h FROM HistClinica h WHERE h.numHisClin = :numHisClin"),
    @NamedQuery(name = "HistClinica.findByFecha", query = "SELECT h FROM HistClinica h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HistClinica.findByPeso", query = "SELECT h FROM HistClinica h WHERE h.peso = :peso"),
    @NamedQuery(name = "HistClinica.findByTalla", query = "SELECT h FROM HistClinica h WHERE h.talla = :talla")})
public class HistClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_his_clin")
    private Integer numHisClin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Float peso;
    @Column(name = "talla")
    private Float talla;
    @JoinColumn(name = "derivacion", referencedColumnName = "cod_id_serv")
    @ManyToOne(optional = false)
    private Servicios derivacion;
    @JoinColumn(name = "dni_paciente", referencedColumnName = "DNI_Pac")
    @ManyToOne(optional = false)
    private Paciente dniPaciente;
    @JoinColumn(name = "cod_diagnostico", referencedColumnName = "cod_diagnostico")
    @ManyToOne(optional = false)
    private Diagnosticos codDiagnostico;
    @JoinColumn(name = "medicos_matricula_med", referencedColumnName = "matricula_med")
    @ManyToOne(optional = false)
    private Medicos medicosMatriculaMed;
    @JoinColumn(name = "cod_patologia", referencedColumnName = "cod_patologia")
    @ManyToOne(optional = false)
    private Patologias codPatologia;

    public HistClinica() {
    }

    public HistClinica(Integer numHisClin) {
        this.numHisClin = numHisClin;
    }

    public HistClinica(Integer numHisClin, Date fecha) {
        this.numHisClin = numHisClin;
        this.fecha = fecha;
    }

    public Integer getNumHisClin() {
        return numHisClin;
    }

    public void setNumHisClin(Integer numHisClin) {
        this.numHisClin = numHisClin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getTalla() {
        return talla;
    }

    public void setTalla(Float talla) {
        this.talla = talla;
    }

    public Servicios getDerivacion() {
        return derivacion;
    }

    public void setDerivacion(Servicios derivacion) {
        this.derivacion = derivacion;
    }

    public Paciente getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(Paciente dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public Diagnosticos getCodDiagnostico() {
        return codDiagnostico;
    }

    public void setCodDiagnostico(Diagnosticos codDiagnostico) {
        this.codDiagnostico = codDiagnostico;
    }

    public Medicos getMedicosMatriculaMed() {
        return medicosMatriculaMed;
    }

    public void setMedicosMatriculaMed(Medicos medicosMatriculaMed) {
        this.medicosMatriculaMed = medicosMatriculaMed;
    }

    public Patologias getCodPatologia() {
        return codPatologia;
    }

    public void setCodPatologia(Patologias codPatologia) {
        this.codPatologia = codPatologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numHisClin != null ? numHisClin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistClinica)) {
            return false;
        }
        HistClinica other = (HistClinica) object;
        if ((this.numHisClin == null && other.numHisClin != null) || (this.numHisClin != null && !this.numHisClin.equals(other.numHisClin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HistClinica[ numHisClin=" + numHisClin + " ]";
    }
    
}
