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
@Table(name = "unidade", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u")
    , @NamedQuery(name = "Unidade.findByIdunidade", query = "SELECT u FROM Unidade u WHERE u.idunidade = :idunidade")
    , @NamedQuery(name = "Unidade.findByDesignacaoUni", query = "SELECT u FROM Unidade u WHERE u.designacaoUni = :designacaoUni")})
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidade", nullable = false)
    private Integer idunidade;
    @Size(max = 45)
    @Column(name = "designacaoUni", length = 45)
    private String designacaoUni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeIdunidade")
    private List<Produto> produtoList;

    public Unidade() {
    }

    public Unidade(Integer idunidade) {
        this.idunidade = idunidade;
    }

    public Integer getIdunidade() {
        return idunidade;
    }

    public void setIdunidade(Integer idunidade) {
        this.idunidade = idunidade;
    }

    public String getDesignacaoUni() {
        return designacaoUni;
    }

    public void setDesignacaoUni(String designacaoUni) {
        this.designacaoUni = designacaoUni;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidade != null ? idunidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.idunidade == null && other.idunidade != null) || (this.idunidade != null && !this.idunidade.equals(other.idunidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Unidade[ idunidade=" + idunidade + " ]";
    }
    
}
