/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "obra_social_por_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObraSocialPorPaciente.findAll", query = "SELECT o FROM ObraSocialPorPaciente o"),
    @NamedQuery(name = "ObraSocialPorPaciente.findByPacienteDNIPac", query = "SELECT o FROM ObraSocialPorPaciente o WHERE o.obraSocialPorPacientePK.pacienteDNIPac = :pacienteDNIPac"),
    @NamedQuery(name = "ObraSocialPorPaciente.findByObraSocialCodIdObraSocial", query = "SELECT o FROM ObraSocialPorPaciente o WHERE o.obraSocialPorPacientePK.obraSocialCodIdObraSocial = :obraSocialCodIdObraSocial"),
    @NamedQuery(name = "ObraSocialPorPaciente.findByNumeroAfiliado", query = "SELECT o FROM ObraSocialPorPaciente o WHERE o.numeroAfiliado = :numeroAfiliado")})
public class ObraSocialPorPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObraSocialPorPacientePK obraSocialPorPacientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_afiliado")
    private int numeroAfiliado;
    @JoinColumn(name = "obra_social_cod_id_obra_social", referencedColumnName = "cod_id_obra_social", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ObraSocial obraSocial;
    @JoinColumn(name = "paciente_DNI_Pac", referencedColumnName = "DNI_Pac", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

    public ObraSocialPorPaciente() {
    }

    public ObraSocialPorPaciente(ObraSocialPorPacientePK obraSocialPorPacientePK) {
        this.obraSocialPorPacientePK = obraSocialPorPacientePK;
    }

    public ObraSocialPorPaciente(ObraSocialPorPacientePK obraSocialPorPacientePK, int numeroAfiliado) {
        this.obraSocialPorPacientePK = obraSocialPorPacientePK;
        this.numeroAfiliado = numeroAfiliado;
    }

    public ObraSocialPorPaciente(int pacienteDNIPac, int obraSocialCodIdObraSocial) {
        this.obraSocialPorPacientePK = new ObraSocialPorPacientePK(pacienteDNIPac, obraSocialCodIdObraSocial);
    }

    public ObraSocialPorPacientePK getObraSocialPorPacientePK() {
        return obraSocialPorPacientePK;
    }

    public void setObraSocialPorPacientePK(ObraSocialPorPacientePK obraSocialPorPacientePK) {
        this.obraSocialPorPacientePK = obraSocialPorPacientePK;
    }

    public int getNumeroAfiliado() {
        return numeroAfiliado;
    }

    public void setNumeroAfiliado(int numeroAfiliado) {
        this.numeroAfiliado = numeroAfiliado;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obraSocialPorPacientePK != null ? obraSocialPorPacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObraSocialPorPaciente)) {
            return false;
        }
        ObraSocialPorPaciente other = (ObraSocialPorPaciente) object;
        if ((this.obraSocialPorPacientePK == null && other.obraSocialPorPacientePK != null) || (this.obraSocialPorPacientePK != null && !this.obraSocialPorPacientePK.equals(other.obraSocialPorPacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObraSocialPorPaciente[ obraSocialPorPacientePK=" + obraSocialPorPacientePK + " ]";
    }
    
}
