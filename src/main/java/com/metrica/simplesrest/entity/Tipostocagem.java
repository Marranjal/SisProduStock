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
@Table(name = "tipostocagem", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipostocagem.findAll", query = "SELECT t FROM Tipostocagem t")
    , @NamedQuery(name = "Tipostocagem.findByIdtipoStocagem", query = "SELECT t FROM Tipostocagem t WHERE t.idtipoStocagem = :idtipoStocagem")
    , @NamedQuery(name = "Tipostocagem.findByDescricaoTipoStock", query = "SELECT t FROM Tipostocagem t WHERE t.descricaoTipoStock = :descricaoTipoStock")})
public class Tipostocagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoStocagem", nullable = false)
    private Integer idtipoStocagem;
    @Size(max = 45)
    @Column(name = "descricaoTipoStock", length = 45)
    private String descricaoTipoStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoStocagemidtipoStocagem")
    private List<Produtostock> produtostockList;

    public Tipostocagem() {
    }

    public Tipostocagem(Integer idtipoStocagem) {
        this.idtipoStocagem = idtipoStocagem;
    }

    public Integer getIdtipoStocagem() {
        return idtipoStocagem;
    }

    public void setIdtipoStocagem(Integer idtipoStocagem) {
        this.idtipoStocagem = idtipoStocagem;
    }

    public String getDescricaoTipoStock() {
        return descricaoTipoStock;
    }

    public void setDescricaoTipoStock(String descricaoTipoStock) {
        this.descricaoTipoStock = descricaoTipoStock;
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
        hash += (idtipoStocagem != null ? idtipoStocagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipostocagem)) {
            return false;
        }
        Tipostocagem other = (Tipostocagem) object;
        if ((this.idtipoStocagem == null && other.idtipoStocagem != null) || (this.idtipoStocagem != null && !this.idtipoStocagem.equals(other.idtipoStocagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Tipostocagem[ idtipoStocagem=" + idtipoStocagem + " ]";
    }
    
}
