/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.NonexistentEntityException;
import Model.Peddetallepedidoproveedor;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IPedDetallePedido {

    void create(Peddetallepedidoproveedor peddetallepedidoproveedor);

    void destroy(Integer id) throws NonexistentEntityException;

    void edit(Peddetallepedidoproveedor peddetallepedidoproveedor) throws NonexistentEntityException, Exception;

    Peddetallepedidoproveedor findPeddetallepedidoproveedor(Integer id);

    List<Peddetallepedidoproveedor> findPeddetallepedidoproveedorEntities();

    List<Peddetallepedidoproveedor> findPeddetallepedidoproveedorEntities(int maxResults, int firstResult);

    int getPeddetallepedidoproveedorCount();
    
}
