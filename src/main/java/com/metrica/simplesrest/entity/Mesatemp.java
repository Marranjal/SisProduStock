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
@Table(name = "mesatemp", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesatemp.findAll", query = "SELECT m FROM Mesatemp m")
    , @NamedQuery(name = "Mesatemp.findByIdmesaTemp", query = "SELECT m FROM Mesatemp m WHERE m.idmesaTemp = :idmesaTemp")})
public class Mesatemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmesaTemp")
    private Integer idmesaTemp;
    @JoinColumn(name = "mesa_idmesa", referencedColumnName = "idmesa")
    @ManyToOne(optional = false)
    private Mesa mesaIdmesa;
    @JoinColumn(name = "produtoStock_idprodutoStock", referencedColumnName = "idprodutoStock")
    @ManyToOne(optional = false)
    private Produtostock produtoStockidprodutoStock;
    @Column(name = "quantidade")
    private Integer quantidade;

    public Mesatemp() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Mesatemp(Integer idmesaTemp) {
        this.idmesaTemp = idmesaTemp;
    }

    public Integer getIdmesaTemp() {
        return idmesaTemp;
    }

    public void setIdmesaTemp(Integer idmesaTemp) {
        this.idmesaTemp = idmesaTemp;
    }

    public Mesa getMesaIdmesa() {
        return mesaIdmesa;
    }

    public void setMesaIdmesa(Mesa mesaIdmesa) {
        this.mesaIdmesa = mesaIdmesa;
    }

    public Produtostock getProdutoStockidprodutoStock() {
        return produtoStockidprodutoStock;
    }

    public void setProdutoStockidprodutoStock(Produtostock produtoStockidprodutoStock) {
        this.produtoStockidprodutoStock = produtoStockidprodutoStock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmesaTemp != null ? idmesaTemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesatemp)) {
            return false;
        }
        Mesatemp other = (Mesatemp) object;
        if ((this.idmesaTemp == null && other.idmesaTemp != null) || (this.idmesaTemp != null && !this.idmesaTemp.equals(other.idmesaTemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Mesatemp[ idmesaTemp=" + idmesaTemp + " ]";
    }
    
}
