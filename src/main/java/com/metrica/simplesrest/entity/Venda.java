/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Teste
 */
@Entity
@Table(name = "venda", catalog = "restbd00", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")
    , @NamedQuery(name = "Venda.findByIdvenda", query = "SELECT v FROM Venda v WHERE v.idvenda = :idvenda")
    , @NamedQuery(name = "Venda.findByDataHoraVenda", query = "SELECT v FROM Venda v WHERE v.dataHoraVenda = :dataHoraVenda")
    , @NamedQuery(name = "Venda.findByValorTotal", query = "SELECT v FROM Venda v WHERE v.valorTotal = :valorTotal")
    , @NamedQuery(name = "Venda.findByValorRecebido", query = "SELECT v FROM Venda v WHERE v.valorRecebido = :valorRecebido")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvenda", nullable = false)
    private Integer idvenda;
    @Column(name = "dataHoraVenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraVenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorTotal", precision = 22)
    private Double valorTotal;
    @Column(name = "valorRecebido", precision = 22)
    private Double valorRecebido;
    @JoinColumn(name = "caixa_idcaixa", referencedColumnName = "idcaixa", nullable = false)
    @ManyToOne(optional = false)
    private Caixa caixaIdcaixa;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;
    @JoinColumn(name = "pagamentoForma_idpagamentoForma", referencedColumnName = "idpagamentoForma", nullable = false)
    @ManyToOne(optional = false)
    private Pagamentoforma pagamentoFormaidpagamentoForma;
    @OneToMany(mappedBy = "vendaIdvenda")
    private List<Movimento> movimentoList;

    public Venda() {
    }

    public Venda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Date getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(Date dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public Caixa getCaixaIdcaixa() {
        return caixaIdcaixa;
    }

    public void setCaixaIdcaixa(Caixa caixaIdcaixa) {
        this.caixaIdcaixa = caixaIdcaixa;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    public Pagamentoforma getPagamentoFormaidpagamentoForma() {
        return pagamentoFormaidpagamentoForma;
    }

    public void setPagamentoFormaidpagamentoForma(Pagamentoforma pagamentoFormaidpagamentoForma) {
        this.pagamentoFormaidpagamentoForma = pagamentoFormaidpagamentoForma;
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
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metrica.simplesrest.entity.Venda[ idvenda=" + idvenda + " ]";
    }
    
}
