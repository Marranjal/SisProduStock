/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.session;

import com.metrica.simplesrest.entity.Caixa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teste
 */
@Stateless
public class CaixaFacade extends AbstractFacade<Caixa> {

    @PersistenceContext(unitName = "com.metrica_SimplesRest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaixaFacade() {
        super(Caixa.class);
    }
    
}
