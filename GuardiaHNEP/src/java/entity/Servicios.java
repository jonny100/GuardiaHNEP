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
@Table(name = "servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByCodIdServ", query = "SELECT s FROM Servicios s WHERE s.codIdServ = :codIdServ"),
    @NamedQuery(name = "Servicios.findByNombreServ", query = "SELECT s FROM Servicios s WHERE s.nombreServ = :nombreServ")})
public class Servicios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_id_serv")
    private Integer codIdServ;
    @Size(max = 20)
    @Column(name = "nombre_serv")
    private String nombreServ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "derivacion")
    private Collection<HistClinica> histClinicaCollection;

    public Servicios() {
    }

    public Servicios(Integer codIdServ) {
        this.codIdServ = codIdServ;
    }

    public Integer getCodIdServ() {
        return codIdServ;
    }

    public void setCodIdServ(Integer codIdServ) {
        this.codIdServ = codIdServ;
    }

    public String getNombreServ() {
        return nombreServ;
    }

    public void setNombreServ(String nombreServ) {
        this.nombreServ = nombreServ;
    }

    @XmlTransient
    public Collection<HistClinica> getHistClinicaCollection() {
        return histClinicaCollection;
    }

    public void setHistClinicaCollection(Collection<HistClinica> histClinicaCollection) {
        this.histClinicaCollection = histClinicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdServ != null ? codIdServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.codIdServ == null && other.codIdServ != null) || (this.codIdServ != null && !this.codIdServ.equals(other.codIdServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Servicios[ codIdServ=" + codIdServ + " ]";
    }
    
}
