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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "produto", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto")
    , @NamedQuery(name = "Produto.findByDesignacao1", query = "SELECT p FROM Produto p WHERE p.designacao1 = :designacao1")
    , @NamedQuery(name = "Produto.findByDesignacao2", query = "SELECT p FROM Produto p WHERE p.designacao2 = :designacao2")
    , @NamedQuery(name = "Produto.findByReferencia", query = "SELECT p FROM Produto p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "Produto.findByImangem", query = "SELECT p FROM Produto p WHERE p.imangem = :imangem")
    , @NamedQuery(name = "Produto.findByObservacao", query = "SELECT p FROM Produto p WHERE p.observacao = :observacao")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduto", nullable = false)
    private Integer idproduto;
    @Size(max = 45)
    @Column(name = "designacao1", length = 45)
    private String designacao1;
    @Size(max = 45)
    @Column(name = "designacao2", length = 45)
    private String designacao2;
    @Size(max = 45)
    @Column(name = "referencia", length = 45)
    private String referencia;
    @Size(max = 100)
    @Column(name = "imangem", length = 100)
    private String imangem;
    @Size(max = 450)
    @Column(name = "observacao", length = 450)
    private String observacao;
    @JoinColumn(name = "categoria_idcategoria", referencedColumnName = "idcategoria", nullable = false)
    @ManyToOne(optional = false)
    private Categoria categoriaIdcategoria;
    @JoinColumn(name = "unidade_idunidade", referencedColumnName = "idunidade", nullable = false)
    @ManyToOne(optional = false)
    private Unidade unidadeIdunidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoIdproduto")
    private List<Produtostock> produtostockList;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getDesignacao1() {
        return designacao1;
    }

    public void setDesignacao1(String designacao1) {
        this.designacao1 = designacao1;
    }

    public String getDesignacao2() {
        return designacao2;
    }

    public void setDesignacao2(String designacao2) {
        this.designacao2 = designacao2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getImangem() {
        return imangem;
    }

    public void setImangem(String imangem) {
        this.imangem = imangem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Categoria getCategoriaIdcategoria() {
        return categoriaIdcategoria;
    }

    public void setCategoriaIdcategoria(Categoria categoriaIdcategoria) {
        this.categoriaIdcategoria = categoriaIdcategoria;
    }

    public Unidade getUnidadeIdunidade() {
        return unidadeIdunidade;
    }

    public void setUnidadeIdunidade(Unidade unidadeIdunidade) {
        this.unidadeIdunidade = unidadeIdunidade;
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
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
