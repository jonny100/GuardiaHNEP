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
public class AdministrarMedicamentosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medicamento")
    private int idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni_pac")
    private int dniPac;

    public AdministrarMedicamentosPK() {
    }

    public AdministrarMedicamentosPK(int idMedicamento, int dniPac) {
        this.idMedicamento = idMedicamento;
        this.dniPac = dniPac;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getDniPac() {
        return dniPac;
    }

    public void setDniPac(int dniPac) {
        this.dniPac = dniPac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMedicamento;
        hash += (int) dniPac;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministrarMedicamentosPK)) {
            return false;
        }
        AdministrarMedicamentosPK other = (AdministrarMedicamentosPK) object;
        if (this.idMedicamento != other.idMedicamento) {
            return false;
        }
        if (this.dniPac != other.dniPac) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdministrarMedicamentosPK[ idMedicamento=" + idMedicamento + ", dniPac=" + dniPac + " ]";
    }
    
}
