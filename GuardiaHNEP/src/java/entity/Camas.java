/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JonnyW7
 */
@Entity
@Table(name = "camas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camas.findAll", query = "SELECT c FROM Camas c"),
    @NamedQuery(name = "Camas.findByNumCama", query = "SELECT c FROM Camas c WHERE c.numCama = :numCama"),
    @NamedQuery(name = "Camas.findByEstado", query = "SELECT c FROM Camas c WHERE c.estado = :estado")})
public class Camas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cama")
    private Integer numCama;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "internacion_transitoria_num_intern", referencedColumnName = "num_intern")
    @ManyToOne(optional = false)
    private InternacionTransitoria internacionTransitoriaNumIntern;

    public Camas() {
    }

    public Camas(Integer numCama) {
        this.numCama = numCama;
    }

    public Integer getNumCama() {
        return numCama;
    }

    public void setNumCama(Integer numCama) {
        this.numCama = numCama;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public InternacionTransitoria getInternacionTransitoriaNumIntern() {
        return internacionTransitoriaNumIntern;
    }

    public void setInternacionTransitoriaNumIntern(InternacionTransitoria internacionTransitoriaNumIntern) {
        this.internacionTransitoriaNumIntern = internacionTransitoriaNumIntern;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCama != null ? numCama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camas)) {
            return false;
        }
        Camas other = (Camas) object;
        if ((this.numCama == null && other.numCama != null) || (this.numCama != null && !this.numCama.equals(other.numCama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Camas[ numCama=" + numCama + " ]";
    }
    
}
