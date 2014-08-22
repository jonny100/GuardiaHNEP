/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCodIdCargo", query = "SELECT c FROM Cargo c WHERE c.codIdCargo = :codIdCargo"),
    @NamedQuery(name = "Cargo.findByNombreCargo", query = "SELECT c FROM Cargo c WHERE c.nombreCargo = :nombreCargo")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_id_cargo")
    private Integer codIdCargo;
    @Size(max = 20)
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    @JoinTable(name = "cargo_de_medicos", joinColumns = {
        @JoinColumn(name = "cargo_cod_id_cargo", referencedColumnName = "cod_id_cargo")}, inverseJoinColumns = {
        @JoinColumn(name = "medicos_matricula_med", referencedColumnName = "matricula_med")})
    @ManyToMany
    private Collection<Medicos> medicosCollection;

    public Cargo() {
    }

    public Cargo(Integer codIdCargo) {
        this.codIdCargo = codIdCargo;
    }

    public Integer getCodIdCargo() {
        return codIdCargo;
    }

    public void setCodIdCargo(Integer codIdCargo) {
        this.codIdCargo = codIdCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @XmlTransient
    public Collection<Medicos> getMedicosCollection() {
        return medicosCollection;
    }

    public void setMedicosCollection(Collection<Medicos> medicosCollection) {
        this.medicosCollection = medicosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdCargo != null ? codIdCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codIdCargo == null && other.codIdCargo != null) || (this.codIdCargo != null && !this.codIdCargo.equals(other.codIdCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cargo[ codIdCargo=" + codIdCargo + " ]";
    }
    
}
