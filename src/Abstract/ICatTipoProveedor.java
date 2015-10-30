/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Cattipoproveedor;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface ICatTipoProveedor {

    void create(Cattipoproveedor cattipoproveedor);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Cattipoproveedor cattipoproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Cattipoproveedor findCattipoproveedor(Integer id);

    List<Cattipoproveedor> findCattipoproveedorEntities();

    List<Cattipoproveedor> findCattipoproveedorEntities(int maxResults, int firstResult);

    int getCattipoproveedorCount();
    
}
