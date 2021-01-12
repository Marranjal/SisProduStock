/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Teste
 */
@Entity
@Table(name = "mesa", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m")
    , @NamedQuery(name = "Mesa.findByIdmesa", query = "SELECT m FROM Mesa m WHERE m.idmesa = :idmesa")
    , @NamedQuery(name = "Mesa.findByNumeroMesa", query = "SELECT m FROM Mesa m WHERE m.numeroMesa = :numeroMesa")
    , @NamedQuery(name = "Mesa.findByEstadoMesa", query = "SELECT m FROM Mesa m WHERE m.estadoMesa = :estadoMesa")})
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmesa")
    private Integer idmesa;
    @Size(max = 45)
    @Column(name = "numeroMesa")
    private String numeroMesa;
    @Size(max = 45)
    @Column(name = "estadoMesa")
    private String estadoMesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesaIdmesa", fetch = FetchType.EAGER)
    private List<Mesatemp> mesatempList;
    @Column(name = "contaMesa")
    private Double contaMesa;

    public Mesa() {
    }

    public Double getContaMesa() {
        return contaMesa;
    }

    public void setContaMesa(Double contaMesa) {
        this.contaMesa = contaMesa;
    }

    public Mesa(Integer idmesa) {
        this.idmesa = idmesa;
    }

    public Integer getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(Integer idmesa) {
        this.idmesa = idmesa;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    @XmlTransient
    public List<Mesatemp> getMesatempList() {
        return mesatempList;
    }

    @XmlTransient
    public String imagemMesa() {
        return contaMesa.equals(0.0) ? "restIconGray.png" : "restIcon.png";
    }

    public void setMesatempList(List<Mesatemp> mesatempList) {
        this.mesatempList = mesatempList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmesa != null ? idmesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.idmesa == null && other.idmesa != null) || (this.idmesa != null && !this.idmesa.equals(other.idmesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getIdmesa());
    }

}
