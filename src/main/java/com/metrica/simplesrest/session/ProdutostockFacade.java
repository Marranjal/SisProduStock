/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.session;

import com.metrica.simplesrest.entity.Produtostock;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teste
 */
@Stateless
public class ProdutostockFacade extends AbstractFacade<Produtostock> {

    @PersistenceContext(unitName = "com.metrica_SimplesRest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutostockFacade() {
        super(Produtostock.class);
    }
    
}
