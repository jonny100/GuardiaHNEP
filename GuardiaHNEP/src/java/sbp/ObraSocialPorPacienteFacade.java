/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.ObraSocialPorPaciente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JonnyW7
 */
@Stateless
public class ObraSocialPorPacienteFacade extends AbstractFacade<ObraSocialPorPaciente> {
    @PersistenceContext(unitName = "GuardiaHNEPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObraSocialPorPacienteFacade() {
        super(ObraSocialPorPaciente.class);
    }
    
}
