/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Proproveedor;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IProProveedor {

    void create(Proproveedor proproveedor);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Proproveedor proproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Proproveedor findProproveedor(Integer id);

    List<Proproveedor> findProproveedorEntities();

    List<Proproveedor> findProproveedorEntities(int maxResults, int firstResult);

    int getProproveedorCount();
    
}
