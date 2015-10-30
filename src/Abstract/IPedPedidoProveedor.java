/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Pedpedidoproveedor;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IPedPedidoProveedor {

    void create(Pedpedidoproveedor pedpedidoproveedor);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Pedpedidoproveedor pedpedidoproveedor) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Pedpedidoproveedor findPedpedidoproveedor(Integer id);

    List<Pedpedidoproveedor> findPedpedidoproveedorEntities();

    List<Pedpedidoproveedor> findPedpedidoproveedorEntities(int maxResults, int firstResult);

    int getPedpedidoproveedorCount();
    
}
