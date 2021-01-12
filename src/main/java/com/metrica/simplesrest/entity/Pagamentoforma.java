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
@Table(name = "pagamentoforma", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamentoforma.findAll", query = "SELECT p FROM Pagamentoforma p")
    , @NamedQuery(name = "Pagamentoforma.findByIdpagamentoForma", query = "SELECT p FROM Pagamentoforma p WHERE p.idpagamentoForma = :idpagamentoForma")
    , @NamedQuery(name = "Pagamentoforma.findByDesignacaoForma", query = "SELECT p FROM Pagamentoforma p WHERE p.designacaoForma = :designacaoForma")})
public class Pagamentoforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpagamentoForma", nullable = false)
    private Integer idpagamentoForma;
    @Size(max = 45)
    @Column(name = "designacaoForma", length = 45)
    private String designacaoForma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamentoFormaidpagamentoForma")
    private List<Venda> vendaList;

    public Pagamentoforma() {
    }

    public Pagamentoforma(Integer idpagamentoForma) {
        this.idpagamentoForma = idpagamentoForma;
    }

    public Integer getIdpagamentoForma() {
        return idpagamentoForma;
    }

    public void setIdpagamentoForma(Integer idpagamentoForma) {
        this.idpagamentoForma = idpagamentoForma;
    }

    public String getDesignacaoForma() {
        return designacaoForma;
    }

    public void setDesignacaoForma(String designacaoForma) {
        this.designacaoForma = designacaoForma;
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
        hash += (idpagamentoForma != null ? idpagamentoForma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamentoforma)) {
            return false;
        }
        Pagamentoforma other = (Pagamentoforma) object;
        if ((this.idpagamentoForma == null && other.idpagamentoForma != null) || (this.idpagamentoForma != null && !this.idpagamentoForma.equals(other.idpagamentoForma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Pagamentoforma[ idpagamentoForma=" + idpagamentoForma + " ]";
    }
    
}
