/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.controller;

import com.metrica.simplesrest.entity.Mesa;
import com.metrica.simplesrest.session.MesaFacade;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Teste
 */
@Named(value = "vendaPorMesaController")
@ViewScoped
public class VendaPorMesaController implements Serializable {

    @EJB
    private MesaFacade mesaFacade;

    /**
     * Creates a new instance of VendaPorMesaController
     */
    private List<Mesa> listaDeMesas = new ArrayList<>();
    private Mesa mesaSelecionada;
    
    public VendaPorMesaController() {
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
    
    private void carregarMesa(){
        listaDeMesas = mesaFacade.findAll();
                
        List<String> lista = new ArrayList<>();
        lista.add("Luanda");
        lista.add("Cabinda");
        lista.add("Benguela");
        
        lista.forEach(item -> System.out.println(item));
    }
    
}
