/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.GuardiasDiarias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JonnyW7
 */
@Stateless
public class GuardiasDiariasFacade extends AbstractFacade<GuardiasDiarias> {
    @PersistenceContext(unitName = "GuardiaHNEPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuardiasDiariasFacade() {
        super(GuardiasDiarias.class);
    }
    
}
