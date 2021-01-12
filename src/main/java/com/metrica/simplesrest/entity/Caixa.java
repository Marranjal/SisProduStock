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
@Table(name = "caixa", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findByIdcaixa", query = "SELECT c FROM Caixa c WHERE c.idcaixa = :idcaixa")
    , @NamedQuery(name = "Caixa.findByNomeCaixa", query = "SELECT c FROM Caixa c WHERE c.nomeCaixa = :nomeCaixa")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcaixa", nullable = false)
    private Integer idcaixa;
    @Size(max = 45)
    @Column(name = "nomeCaixa", length = 45)
    private String nomeCaixa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixaIdcaixa")
    private List<Venda> vendaList;

    public Caixa() {
    }

    public Caixa(Integer idcaixa) {
        this.idcaixa = idcaixa;
    }

    public Integer getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(Integer idcaixa) {
        this.idcaixa = idcaixa;
    }

    public String getNomeCaixa() {
        return nomeCaixa;
    }

    public void setNomeCaixa(String nomeCaixa) {
        this.nomeCaixa = nomeCaixa;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaixa != null ? idcaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.idcaixa == null && other.idcaixa != null) || (this.idcaixa != null && !this.idcaixa.equals(other.idcaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Caixa[ idcaixa=" + idcaixa + " ]";
    }
    
}
