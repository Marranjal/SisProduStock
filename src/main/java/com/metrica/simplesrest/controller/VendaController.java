/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.controller;

import com.metrica.simplesrest.entity.Cliente;
import com.metrica.simplesrest.entity.Itensvenda;
import com.metrica.simplesrest.entity.Mesa;
import com.metrica.simplesrest.entity.Mesatemp;
import com.metrica.simplesrest.entity.Pagamentoforma;
import com.metrica.simplesrest.entity.Produtostock;
import com.metrica.simplesrest.entity.Venda;
import com.metrica.simplesrest.session.CaixaFacade;
import com.metrica.simplesrest.session.ClienteFacade;
import com.metrica.simplesrest.session.MesaFacade;
import com.metrica.simplesrest.session.MesatempFacade;
import com.metrica.simplesrest.session.PagamentoformaFacade;
import com.metrica.simplesrest.session.ProdutostockFacade;
import com.metrica.simplesrest.util.ExecutarRelatorio;
import com.metrica.simplesrest.util.FacesUtil;
import com.metrica.simplesrest.util.PersisterVenda;
import com.metrica.simplesrest.util.TipoVenda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Teste
 */
@Named(value = "vendaController")
@ViewScoped
public class VendaController implements Serializable {

    @EJB
    private MesatempFacade mesatempFacade;

    @EJB
    private ClienteFacade clienteFacade;

    @EJB
    private CaixaFacade caixaFacade;

    @EJB
    private PagamentoformaFacade pagamentoformaFacade;

    @EJB
    private ProdutostockFacade produtostockFacade;

    @EJB
    private MesaFacade mesaFacade;

    /**
     * Creates a new instance of VendaController
     *
     */
    @Inject
    private PersisterVenda vendaPersist;

    private List<Mesa> listaDeMesas = new ArrayList<>();
    private List<Produtostock> listaDosProdutos = new ArrayList<>();
    private List<Itensvenda> listaDosItensVenda = new ArrayList<>();
    private List<Pagamentoforma> formasDePagamento = new ArrayList<>();
    private Produtostock novoProdutoVenda;
    private Pagamentoforma pagamentoForma;
    private Integer quantidade = 1;
    private Double totalGeral = 0.0;
    private Double precoUn = 0.0;
    private Double subTotal = 0.0;
    private Double valorRecebido = 0.0;
    private Double troco = 0.0;
    private boolean adicionaMesa = false;
    private String finalizarButtonlable = "Finalizar";
    private Mesa mesaNumero;
    private Mesa mesaSelecionada;
    private boolean desabilitaCheckBox = false;
    private TipoVenda tipoVenda = TipoVenda.VENDA_NORMAL;
    private boolean imprimirRecibo = false;
    private Cliente novoCliente;

    public VendaController() {
        mesaNumero = new Mesa();
        mesaNumero.setNumeroMesa("Seleciona a Mesa");
        novoProdutoVenda = new Produtostock();
    }

    public Cliente getNovoCliente() {
        return novoCliente;
    }

    public void setNovoCliente(Cliente novoCliente) {
        this.novoCliente = novoCliente;
    }

    public boolean isImprimirRecibo() {
        return imprimirRecibo;
    }

    public void setImprimirRecibo(boolean imprimirRecibo) {
        this.imprimirRecibo = imprimirRecibo;
    }

    public boolean isDesabilitaCheckBox() {
        return desabilitaCheckBox;
    }

    public void setDesabilitaCheckBox(boolean desabilitaCheckBox) {
        this.desabilitaCheckBox = desabilitaCheckBox;
    }

    public List<Mesa> getListaDeMesas() {
        carregarMesa();
        return listaDeMesas;
    }

    public Mesa getMesaSelecionada() {
        return mesaSelecionada;
    }

    public void setMesaSelecionada(Mesa mesaSelecionada) {
        this.mesaSelecionada = mesaSelecionada;
    }

    private void carregarMesa() {
        listaDeMesas = mesaFacade.findAll();
    }

    public Mesa getMesaNumero() {
        return mesaNumero;
    }

    public void setMesaNumero(Mesa mesaNumero) {
        this.mesaNumero = mesaNumero;
    }

    public String getFinalizarButtonlable() {
        return finalizarButtonlable;
    }

    public void setFinalizarButtonlable(String finalizarButtonlable) {
        this.finalizarButtonlable = finalizarButtonlable;
    }

    public boolean isAdicionaMesa() {
        alteraButtonLable();
        return adicionaMesa;
    }

    public void setAdicionaMesa(boolean adicionaMesa) {
        this.adicionaMesa = adicionaMesa;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public List<Pagamentoforma> getFormasDePagamento() {
        carregarFormasDePagamento();
        return formasDePagamento;
    }

    public Pagamentoforma getPagamentoForma() {
        return pagamentoForma;
    }

    public void setPagamentoForma(Pagamentoforma pagamentoForma) {
        this.pagamentoForma = pagamentoForma;
    }

    public Double getPrecoUn() {
        return precoUn;
    }

    public void setPrecoUn(Double precoUn) {
        this.precoUn = precoUn;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(Double totalGeral) {
        this.totalGeral = totalGeral;
    }

    public List<Itensvenda> getListaDosItensVenda() {
        return listaDosItensVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produtostock getNovoProdutoVenda() {
        return novoProdutoVenda;
    }

    public void setNovoProdutoVenda(Produtostock novoProdutoVenda) {
        precoUn = novoProdutoVenda.getPrecoVenda();
        this.novoProdutoVenda = novoProdutoVenda;
    }

    public List<Produtostock> getListaDosProdutos() {
        if (listaDosProdutos.isEmpty()) {
            carregarProdutos();
        }
        return listaDosProdutos;
    }

    private void carregarProdutos() {
        listaDosProdutos = produtostockFacade.findAll();
    }

    private void carregarFormasDePagamento() {
        formasDePagamento = pagamentoformaFacade.findAll();
        pagamentoForma = formasDePagamento.get(0);
    }

    public void adicionarProdutoVenda() {
        Itensvenda item = new Itensvenda();
        item.setProdutoStockidprodutoStock(novoProdutoVenda);
        item.setQuantidade(quantidade);
        item.setTotal(novoProdutoVenda.getPrecoVenda() * quantidade);
        listaDosItensVenda.add(item);
        totalGeral += item.getTotal();
        novoProdutoVenda = null;
        quantidade = 1;
        precoUn = 0.0;
    }

    public void cancelarVenda() {
        listaDosItensVenda.clear();
        novoProdutoVenda = new Produtostock();
        totalGeral = 0.0;
        precoUn = 0.0;
        valorRecebido = 0.0;
        desabilitaCheckBox = false;
        tipoVenda = TipoVenda.VENDA_NORMAL;
    }

    private void processarTroco() {
        troco = valorRecebido - totalGeral;
    }

    private void alteraButtonLable() {
        finalizarButtonlable = adicionaMesa ? "Adicionar à Mesa" : "Finalizar";
    }

    //METODO PARA ALTERNAR AS DIALOGS
    public String mostrarDialog() {
        return adicionaMesa ? "PF('addProdMesaDialog').show()" : "PF('finalizarDialog').show()";
    }

    //Desabilita o botão concluir caso não seja selecionada o numero da mesa
    public boolean ativaConcluirAddMesa() {
        if (null != mesaNumero.getIdmesa()) {
            return false;
        } else {
            return true;
        }
    }

    public void mesaNaoSelecionadaMessege() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
        /*
        if (mesaNumero != null && !mesaNumero.isEmpty()) {
           
        } else {
//            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18n("mesaNaoSelecionada"),
//                    FacesUtil.getMensagemI18n("selecionaMesa"));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
            return null;
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
        return "PF('finalizarDialog').hide()";
        }  */
    }

//  Este Metodo Desatica o botão concluir enquanto o valor recebido for inferior que o da venda, e controla o troco 
    public boolean ativarVenda() {
        boolean destiva = true;
        if (valorRecebido >= totalGeral) {
            destiva = false;
        }

        return destiva;
    }

    public void prepararFinalizacao() {
        novoCliente = clienteFacade.find(1);
    }

    public String concluirVenda() {
        vendaPersist.salvarVenda(prepararVenda(), listaDosItensVenda);

        switch (tipoVenda) {
            case VENDA_POR_MESA:
                limparContaMesa();
                break;
        }

        processarTroco();
        cancelarVenda();
        return null;
    }

    private Venda prepararVenda() {
        Venda novaVenda = new Venda();
        novaVenda.setDataHoraVenda(new Date());
        novaVenda.setPagamentoFormaidpagamentoForma(pagamentoForma);
        novaVenda.setValorRecebido(valorRecebido);
        novaVenda.setValorTotal(totalGeral);
        novaVenda.setCaixaIdcaixa(caixaFacade.find(1));
        novaVenda.setClienteIdcliente(novoCliente);
        return novaVenda;
    }

    public void excluirProduto(Itensvenda item) {
        listaDosItensVenda.remove(item);
        totalGeral -= item.getTotal();
    }

    //METODO QUE ADICIONA OS PRODUTOS A MESA SELECIONADA
    public String adicionarProdutosMesa() {
        /* VERSÃO JAVA 8
                    for (Itensvenda produto : listaDosItensVenda) {
                Mesatemp mesaTemp = new Mesatemp();
                mesaTemp.setMesaIdmesa(mesaNumero);
                mesaTemp.setProdutoStockidprodutoStock(produto.getProdutoStockidprodutoStock());
                mesaTemp.setQuantidade(produto.getQuantidade());
                mesatempFacade.create(mesaTemp);

                mesaNumero.setContaMesa(mesaNumero.getContaMesa() + (produto.getProdutoStockidprodutoStock().getPrecoVenda() * produto.getQuantidade()));
                mesaFacade.edit(mesaNumero);
            }
         */
        try {
            listaDosItensVenda.forEach(produto -> {
                Mesatemp mesaTemp = new Mesatemp();
                mesaTemp.setMesaIdmesa(mesaNumero);
                mesaTemp.setProdutoStockidprodutoStock(produto.getProdutoStockidprodutoStock());
                mesaTemp.setQuantidade(produto.getQuantidade());
                mesatempFacade.create(mesaTemp);

                mesaNumero.setContaMesa(mesaNumero.getContaMesa() + (produto.getProdutoStockidprodutoStock().getPrecoVenda() * produto.getQuantidade()));
                mesaFacade.edit(mesaNumero);
            });

            adicionaMesa = false;
            listaDeMesas.clear();
            cancelarVenda();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"), FacesUtil.getMensagemI18n("produtoAdiconadoAMesa")
                    + mesaNumero.getNumeroMesa()));
            mesaNumero = null;
            carregarMesa();
        } catch (Exception e) {

        }

        return null;
    }

    //METODO QUE FECHA A CONTA DA MESA
    public void fecharContaMesa() {
        //CASO ESTEJA UMA OPERAÇÃO DE VENDA POR MESA, NÃO EXECUTA NADA
        switch (tipoVenda) {

            case VENDA_NORMAL:

                tipoVenda = TipoVenda.VENDA_POR_MESA;

                try {
                    mesaSelecionada.getMesatempList().forEach(itensMesa -> {
                        Itensvenda itemvenda = new Itensvenda();
                        itemvenda.setProdutoStockidprodutoStock(itensMesa.getProdutoStockidprodutoStock());
                        itemvenda.setQuantidade(itensMesa.getQuantidade());
                        itemvenda.setTotal(itensMesa.getProdutoStockidprodutoStock().getPrecoVenda() * itensMesa.getQuantidade());

                        totalGeral += itemvenda.getTotal();

                        listaDosItensVenda.add(itemvenda);
                    });

                    desabilitaCheckBox = true;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            default:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, FacesUtil.getMensagemI18n("atencao"), FacesUtil.getMensagemI18n("terminaConta")
                ));
                break;

        }

    }

    private void limparContaMesa() {
        mesaSelecionada.getMesatempList().forEach(mesa -> mesatempFacade.remove(mesa));
        mesaSelecionada.setContaMesa(0.0);
        mesaFacade.edit(mesaSelecionada);
        desabilitaCheckBox = false;
        tipoVenda = TipoVenda.VENDA_NORMAL;
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"), FacesUtil.getMensagemI18n("produtoAdiconadoAMesa")
                    + mesaNumero.getNumeroMesa()));
    }

    public String testeImpressao() {
        imprimirRecibo();
        return null;
    }

    private void imprimirRecibo() {
        try {
            ExecutarRelatorio executor = new ExecutarRelatorio("/WEB-INF/Relatorios/reciboVenda.jasper", new HashMap(), "Recibo.pdf");
            executor.ImprimirRelatorio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
