/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.NonexistentEntityException;
import Model.Cattipopago;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface ICatTipoPago {

    void create(Cattipopago cattipopago);

    void destroy(Integer id) throws NonexistentEntityException;

    void edit(Cattipopago cattipopago) throws NonexistentEntityException, Exception;

    Cattipopago findCattipopago(Integer id);

    List<Cattipopago> findCattipopagoEntities();

    List<Cattipopago> findCattipopagoEntities(int maxResults, int firstResult);

    int getCattipopagoCount();
    
}
