/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.NonexistentEntityException;
import Model.Vendetalleventa;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IVenDetalleVenta {

    void create(Vendetalleventa vendetalleventa);

    void destroy(Integer id) throws NonexistentEntityException;

    void edit(Vendetalleventa vendetalleventa) throws NonexistentEntityException, Exception;

    Vendetalleventa findVendetalleventa(Integer id);

    List<Vendetalleventa> findVendetalleventaEntities();

    List<Vendetalleventa> findVendetalleventaEntities(int maxResults, int firstResult);

    int getVendetalleventaCount();
    
}
