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
@Table(name = "medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findByCodIdMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.codIdMedicamento = :codIdMedicamento"),
    @NamedQuery(name = "Medicamentos.findByNombreMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.nombreMedicamento = :nombreMedicamento"),
    @NamedQuery(name = "Medicamentos.findByStockMedicamentos", query = "SELECT m FROM Medicamentos m WHERE m.stockMedicamentos = :stockMedicamentos"),
    @NamedQuery(name = "Medicamentos.findByPresentacionTipo", query = "SELECT m FROM Medicamentos m WHERE m.presentacionTipo = :presentacionTipo")})
public class Medicamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_id_medicamento")
    private Integer codIdMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_medicamento")
    private String nombreMedicamento;
    @Column(name = "stock_medicamentos")
    private Integer stockMedicamentos;
    @Size(max = 20)
    @Column(name = "presentacion_tipo")
    private String presentacionTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentos")
    private Collection<AdministrarMedicamentos> administrarMedicamentosCollection;

    public Medicamentos() {
    }

    public Medicamentos(Integer codIdMedicamento) {
        this.codIdMedicamento = codIdMedicamento;
    }

    public Medicamentos(Integer codIdMedicamento, String nombreMedicamento) {
        this.codIdMedicamento = codIdMedicamento;
        this.nombreMedicamento = nombreMedicamento;
    }

    public Integer getCodIdMedicamento() {
        return codIdMedicamento;
    }

    public void setCodIdMedicamento(Integer codIdMedicamento) {
        this.codIdMedicamento = codIdMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public Integer getStockMedicamentos() {
        return stockMedicamentos;
    }

    public void setStockMedicamentos(Integer stockMedicamentos) {
        this.stockMedicamentos = stockMedicamentos;
    }

    public String getPresentacionTipo() {
        return presentacionTipo;
    }

    public void setPresentacionTipo(String presentacionTipo) {
        this.presentacionTipo = presentacionTipo;
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
        hash += (codIdMedicamento != null ? codIdMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.codIdMedicamento == null && other.codIdMedicamento != null) || (this.codIdMedicamento != null && !this.codIdMedicamento.equals(other.codIdMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Medicamentos[ codIdMedicamento=" + codIdMedicamento + " ]";
    }
    
}
