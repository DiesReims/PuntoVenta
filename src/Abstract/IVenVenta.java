/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Venventa;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IVenVenta {

    void create(Venventa venventa);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Venventa venventa) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Venventa findVenventa(Integer id);

    List<Venventa> findVenventaEntities();

    List<Venventa> findVenventaEntities(int maxResults, int firstResult);

    int getVenventaCount();
    
}
