/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JonnyW7
 */
@Embeddable
public class ObraSocialPorPacientePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "paciente_DNI_Pac")
    private int pacienteDNIPac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obra_social_cod_id_obra_social")
    private int obraSocialCodIdObraSocial;

    public ObraSocialPorPacientePK() {
    }

    public ObraSocialPorPacientePK(int pacienteDNIPac, int obraSocialCodIdObraSocial) {
        this.pacienteDNIPac = pacienteDNIPac;
        this.obraSocialCodIdObraSocial = obraSocialCodIdObraSocial;
    }

    public int getPacienteDNIPac() {
        return pacienteDNIPac;
    }

    public void setPacienteDNIPac(int pacienteDNIPac) {
        this.pacienteDNIPac = pacienteDNIPac;
    }

    public int getObraSocialCodIdObraSocial() {
        return obraSocialCodIdObraSocial;
    }

    public void setObraSocialCodIdObraSocial(int obraSocialCodIdObraSocial) {
        this.obraSocialCodIdObraSocial = obraSocialCodIdObraSocial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pacienteDNIPac;
        hash += (int) obraSocialCodIdObraSocial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObraSocialPorPacientePK)) {
            return false;
        }
        ObraSocialPorPacientePK other = (ObraSocialPorPacientePK) object;
        if (this.pacienteDNIPac != other.pacienteDNIPac) {
            return false;
        }
        if (this.obraSocialCodIdObraSocial != other.obraSocialCodIdObraSocial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObraSocialPorPacientePK[ pacienteDNIPac=" + pacienteDNIPac + ", obraSocialCodIdObraSocial=" + obraSocialCodIdObraSocial + " ]";
    }
    
}
