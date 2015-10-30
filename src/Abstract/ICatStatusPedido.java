/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Catstatuspedido;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface ICatStatusPedido {

    void create(Catstatuspedido catstatuspedido);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Catstatuspedido catstatuspedido) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Catstatuspedido findCatstatuspedido(Integer id);

    List<Catstatuspedido> findCatstatuspedidoEntities();

    List<Catstatuspedido> findCatstatuspedidoEntities(int maxResults, int firstResult);

    int getCatstatuspedidoCount();
    
}
