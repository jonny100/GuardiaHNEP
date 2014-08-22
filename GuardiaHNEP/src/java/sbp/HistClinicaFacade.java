/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.HistClinica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JonnyW7
 */
@Stateless
public class HistClinicaFacade extends AbstractFacade<HistClinica> {
    @PersistenceContext(unitName = "GuardiaHNEPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistClinicaFacade() {
        super(HistClinica.class);
    }
    
}
