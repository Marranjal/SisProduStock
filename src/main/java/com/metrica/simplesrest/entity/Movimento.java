/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teste
 */
@Entity
@Table(name = "movimento", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m")
    , @NamedQuery(name = "Movimento.findByIdmovimento", query = "SELECT m FROM Movimento m WHERE m.idmovimento = :idmovimento")
    , @NamedQuery(name = "Movimento.findByDataHoraMov", query = "SELECT m FROM Movimento m WHERE m.dataHoraMov = :dataHoraMov")
    , @NamedQuery(name = "Movimento.findByTipoMovimento", query = "SELECT m FROM Movimento m WHERE m.tipoMovimento = :tipoMovimento")
    , @NamedQuery(name = "Movimento.findBySaldoInicial", query = "SELECT m FROM Movimento m WHERE m.saldoInicial = :saldoInicial")
    , @NamedQuery(name = "Movimento.findBySaldoFinal", query = "SELECT m FROM Movimento m WHERE m.saldoFinal = :saldoFinal")
    , @NamedQuery(name = "Movimento.findByOperador", query = "SELECT m FROM Movimento m WHERE m.operador = :operador")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimento", nullable = false)
    private Integer idmovimento;
    @Column(name = "dataHoraMov")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraMov;
    @Size(max = 45)
    @Column(name = "tipoMovimento", length = 45)
    private String tipoMovimento;
    @Column(name = "saldoInicial")
    private Integer saldoInicial;
    @Column(name = "saldoFinal")
    private Integer saldoFinal;
    @Size(max = 45)
    @Column(name = "operador", length = 45)
    private String operador;
    @JoinColumn(name = "produtoStock_idprodutoStock", referencedColumnName = "idprodutoStock")
    @ManyToOne
    private Produtostock produtoStockidprodutoStock;
    @JoinColumn(name = "venda_idvenda", referencedColumnName = "idvenda")
    @ManyToOne
    private Venda vendaIdvenda;

    public Movimento() {
    }

    public Movimento(Integer idmovimento) {
        this.idmovimento = idmovimento;
    }

    public Integer getIdmovimento() {
        return idmovimento;
    }

    public void setIdmovimento(Integer idmovimento) {
        this.idmovimento = idmovimento;
    }

    public Date getDataHoraMov() {
        return dataHoraMov;
    }

    public void setDataHoraMov(Date dataHoraMov) {
        this.dataHoraMov = dataHoraMov;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Integer getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Integer saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Integer getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Integer saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
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
        hash += (idmovimento != null ? idmovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.idmovimento == null && other.idmovimento != null) || (this.idmovimento != null && !this.idmovimento.equals(other.idmovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Movimento[ idmovimento=" + idmovimento + " ]";
    }
    
}
