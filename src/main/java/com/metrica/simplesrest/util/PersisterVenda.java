/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.util;

import com.metrica.simplesrest.entity.Itensvenda;
import com.metrica.simplesrest.entity.Venda;
import com.metrica.simplesrest.session.ItensvendaFacade;
import com.metrica.simplesrest.session.VendaFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Teste
 */
@Named
@RequestScoped
public class PersisterVenda implements Serializable {

    @EJB
    private ItensvendaFacade itensvendaFacade;

    @EJB
    private VendaFacade vendaFacade;

    public void salvarVenda(Venda venda, List<Itensvenda> itens) {
        try {
            venda = vendaFacade.create(venda);

            for (Itensvenda iten : itens) {
                iten.setVendaIdvenda(venda);
                itensvendaFacade.create(iten);
            }
            
        } catch (Exception e) {
        }
    }

    private void salvarItens() {

    }

}
