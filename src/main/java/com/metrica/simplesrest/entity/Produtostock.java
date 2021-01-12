/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Teste
 */
@Entity
@Table(name = "produtostock", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtostock.findAll", query = "SELECT p FROM Produtostock p")
    , @NamedQuery(name = "Produtostock.findByIdprodutoStock", query = "SELECT p FROM Produtostock p WHERE p.idprodutoStock = :idprodutoStock")
    , @NamedQuery(name = "Produtostock.findByQuantidade", query = "SELECT p FROM Produtostock p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Produtostock.findByPrecoCusto", query = "SELECT p FROM Produtostock p WHERE p.precoCusto = :precoCusto")
    , @NamedQuery(name = "Produtostock.findByPrecoVenda", query = "SELECT p FROM Produtostock p WHERE p.precoVenda = :precoVenda")})
public class Produtostock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprodutoStock", nullable = false)
    private Integer idprodutoStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precoCusto", precision = 22)
    private Double precoCusto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precoVenda", nullable = false)
    private double precoVenda;
    @JoinColumn(name = "localizacao_idlocalizacao", referencedColumnName = "idlocalizacao", nullable = false)
    @ManyToOne(optional = false)
    private Localizacao localizacaoIdlocalizacao;
    @JoinColumn(name = "produto_idproduto", referencedColumnName = "idproduto", nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoIdproduto;
    @JoinColumn(name = "tipoStocagem_idtipoStocagem", referencedColumnName = "idtipoStocagem", nullable = false)
    @ManyToOne(optional = false)
    private Tipostocagem tipoStocagemidtipoStocagem;
    @OneToMany(mappedBy = "produtoStockidprodutoStock")
    private List<Movimento> movimentoList;

    public Produtostock() {
    }

    public Produtostock(Integer idprodutoStock) {
        this.idprodutoStock = idprodutoStock;
    }

    public Produtostock(Integer idprodutoStock, int quantidade, double precoVenda) {
        this.idprodutoStock = idprodutoStock;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public Integer getIdprodutoStock() {
        return idprodutoStock;
    }

    public void setIdprodutoStock(Integer idprodutoStock) {
        this.idprodutoStock = idprodutoStock;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Localizacao getLocalizacaoIdlocalizacao() {
        return localizacaoIdlocalizacao;
    }

    public void setLocalizacaoIdlocalizacao(Localizacao localizacaoIdlocalizacao) {
        this.localizacaoIdlocalizacao = localizacaoIdlocalizacao;
    }

    public Produto getProdutoIdproduto() {
        return produtoIdproduto;
    }

    public void setProdutoIdproduto(Produto produtoIdproduto) {
        this.produtoIdproduto = produtoIdproduto;
    }

    public Tipostocagem getTipoStocagemidtipoStocagem() {
        return tipoStocagemidtipoStocagem;
    }

    public void setTipoStocagemidtipoStocagem(Tipostocagem tipoStocagemidtipoStocagem) {
        this.tipoStocagemidtipoStocagem = tipoStocagemidtipoStocagem;
    }

    @XmlTransient
    public List<Movimento> getMovimentoList() {
        return movimentoList;
    }

    public void setMovimentoList(List<Movimento> movimentoList) {
        this.movimentoList = movimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprodutoStock != null ? idprodutoStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtostock)) {
            return false;
        }
        Produtostock other = (Produtostock) object;
        if ((this.idprodutoStock == null && other.idprodutoStock != null) || (this.idprodutoStock != null && !this.idprodutoStock.equals(other.idprodutoStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Produtostock[ idprodutoStock=" + idprodutoStock + " ]";
    }
    
}
