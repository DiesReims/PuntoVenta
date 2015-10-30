/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Procatstatusproveedor;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IProCatStatusProveedor {

    void create(Procatstatusproveedor procatstatusproveedor);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Procatstatusproveedor procatstatusproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Procatstatusproveedor findProcatstatusproveedor(Integer id);

    List<Procatstatusproveedor> findProcatstatusproveedorEntities();

    List<Procatstatusproveedor> findProcatstatusproveedorEntities(int maxResults, int firstResult);

    int getProcatstatusproveedorCount();
    
}
