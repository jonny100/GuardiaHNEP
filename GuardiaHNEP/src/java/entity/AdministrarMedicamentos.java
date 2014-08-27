/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "administrar_medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdministrarMedicamentos.findAll", query = "SELECT a FROM AdministrarMedicamentos a"),
    @NamedQuery(name = "AdministrarMedicamentos.findByIdMedicamento", query = "SELECT a FROM AdministrarMedicamentos a WHERE a.administrarMedicamentosPK.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "AdministrarMedicamentos.findByDniPac", query = "SELECT a FROM AdministrarMedicamentos a WHERE a.administrarMedicamentosPK.dniPac = :dniPac")})
public class AdministrarMedicamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministrarMedicamentosPK administrarMedicamentosPK;
    @JoinColumn(name = "dni_enferm", referencedColumnName = "dni_enferm")
    @ManyToOne(optional = false)
    private Enfermero dniEnferm;
    @JoinColumn(name = "dni_pac", referencedColumnName = "DNI_Pac", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "id_medicamento", referencedColumnName = "cod_id_medicamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamentos medicamentos;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public AdministrarMedicamentos() {
    }

    public AdministrarMedicamentos(AdministrarMedicamentosPK administrarMedicamentosPK) {
        this.administrarMedicamentosPK = administrarMedicamentosPK;
    }

    public AdministrarMedicamentos(int idMedicamento, int dniPac) {
        this.administrarMedicamentosPK = new AdministrarMedicamentosPK(idMedicamento, dniPac);
    }

    public AdministrarMedicamentosPK getAdministrarMedicamentosPK() {
        return administrarMedicamentosPK;
    }

    public void setAdministrarMedicamentosPK(AdministrarMedicamentosPK administrarMedicamentosPK) {
        this.administrarMedicamentosPK = administrarMedicamentosPK;
    }

    public Enfermero getDniEnferm() {
        return dniEnferm;
    }

    public void setDniEnferm(Enfermero dniEnferm) {
        this.dniEnferm = dniEnferm;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administrarMedicamentosPK != null ? administrarMedicamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministrarMedicamentos)) {
            return false;
        }
        AdministrarMedicamentos other = (AdministrarMedicamentos) object;
        if ((this.administrarMedicamentosPK == null && other.administrarMedicamentosPK != null) || (this.administrarMedicamentosPK != null && !this.administrarMedicamentosPK.equals(other.administrarMedicamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdministrarMedicamentos[ administrarMedicamentosPK=" + administrarMedicamentosPK + " ]";
    }
    
}
