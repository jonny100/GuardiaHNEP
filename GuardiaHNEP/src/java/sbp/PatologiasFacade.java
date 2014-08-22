/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.Patologias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JonnyW7
 */
@Stateless
public class PatologiasFacade extends AbstractFacade<Patologias> {
    @PersistenceContext(unitName = "GuardiaHNEPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatologiasFacade() {
        super(Patologias.class);
    }
    
}
