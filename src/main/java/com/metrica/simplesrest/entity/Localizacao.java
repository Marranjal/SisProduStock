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
@Table(name = "localizacao", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacao.findAll", query = "SELECT l FROM Localizacao l")
    , @NamedQuery(name = "Localizacao.findByIdlocalizacao", query = "SELECT l FROM Localizacao l WHERE l.idlocalizacao = :idlocalizacao")
    , @NamedQuery(name = "Localizacao.findByDesignacaoLocal", query = "SELECT l FROM Localizacao l WHERE l.designacaoLocal = :designacaoLocal")})
public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocalizacao", nullable = false)
    private Integer idlocalizacao;
    @Size(max = 45)
    @Column(name = "designacaoLocal", length = 45)
    private String designacaoLocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localizacaoIdlocalizacao")
    private List<Produtostock> produtostockList;

    public Localizacao() {
    }

    public Localizacao(Integer idlocalizacao) {
        this.idlocalizacao = idlocalizacao;
    }

    public Integer getIdlocalizacao() {
        return idlocalizacao;
    }

    public void setIdlocalizacao(Integer idlocalizacao) {
        this.idlocalizacao = idlocalizacao;
    }

    public String getDesignacaoLocal() {
        return designacaoLocal;
    }

    public void setDesignacaoLocal(String designacaoLocal) {
        this.designacaoLocal = designacaoLocal;
    }

    @XmlTransient
    public List<Produtostock> getProdutostockList() {
        return produtostockList;
    }

    public void setProdutostockList(List<Produtostock> produtostockList) {
        this.produtostockList = produtostockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalizacao != null ? idlocalizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacao)) {
            return false;
        }
        Localizacao other = (Localizacao) object;
        if ((this.idlocalizacao == null && other.idlocalizacao != null) || (this.idlocalizacao != null && !this.idlocalizacao.equals(other.idlocalizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Localizacao[ idlocalizacao=" + idlocalizacao + " ]";
    }
    
}
