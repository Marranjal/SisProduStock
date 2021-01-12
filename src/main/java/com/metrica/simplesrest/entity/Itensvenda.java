/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teste
 */
@Entity
@Table(name = "itensvenda", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itensvenda.findAll", query = "SELECT i FROM Itensvenda i")
    , @NamedQuery(name = "Itensvenda.findByIditensVenda", query = "SELECT i FROM Itensvenda i WHERE i.iditensVenda = :iditensVenda")
    , @NamedQuery(name = "Itensvenda.findByQuantidade", query = "SELECT i FROM Itensvenda i WHERE i.quantidade = :quantidade")
    , @NamedQuery(name = "Itensvenda.findByTotal", query = "SELECT i FROM Itensvenda i WHERE i.total = :total")})
public class Itensvenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditensVenda")
    private Integer iditensVenda;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "produtoStock_idprodutoStock", referencedColumnName = "idprodutoStock")
    @ManyToOne(optional = false)
    private Produtostock produtoStockidprodutoStock;
    @JoinColumn(name = "venda_idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda vendaIdvenda;

    public Itensvenda() {
    }

    public Itensvenda(Integer iditensVenda) {
        this.iditensVenda = iditensVenda;
    }

    public Integer getIditensVenda() {
        return iditensVenda;
    }

    public void setIditensVenda(Integer iditensVenda) {
        this.iditensVenda = iditensVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Produtostock getProdutoStockidprodutoStock() {
        return produtoStockidprodutoStock;
    }

    public void setProdutoStockidprodutoStock(Produtostock produtoStockidprodutoStock) {
        this.produtoStockidprodutoStock = produtoStockidprodutoStock;
    }

    public Venda getVendaIdvenda() {
        return vendaIdvenda;
    }

    public void setVendaIdvenda(Venda vendaIdvenda) {
        this.vendaIdvenda = vendaIdvenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditensVenda != null ? iditensVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itensvenda)) {
            return false;
        }
        Itensvenda other = (Itensvenda) object;
        if ((this.iditensVenda == null && other.iditensVenda != null) || (this.iditensVenda != null && !this.iditensVenda.equals(other.iditensVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Itensvenda[ iditensVenda=" + iditensVenda + " ]";
    }
    
}
