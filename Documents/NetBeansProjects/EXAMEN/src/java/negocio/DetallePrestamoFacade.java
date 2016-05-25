/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.DetallePrestamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp1
 */
@Stateless
public class DetallePrestamoFacade extends AbstractFacade<DetallePrestamo> {

    @PersistenceContext(unitName = "EXAMENPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePrestamoFacade() {
        super(DetallePrestamo.class);
    }
    
}
