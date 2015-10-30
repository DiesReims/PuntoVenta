/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.NonexistentEntityException;
import Model.Pedpagospedidoproveedor;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IPedPagosPedidoProveedor {

    void create(Pedpagospedidoproveedor pedpagospedidoproveedor);

    void destroy(Integer id) throws NonexistentEntityException;

    void edit(Pedpagospedidoproveedor pedpagospedidoproveedor) throws NonexistentEntityException, Exception;

    Pedpagospedidoproveedor findPedpagospedidoproveedor(Integer id);

    List<Pedpagospedidoproveedor> findPedpagospedidoproveedorEntities();

    List<Pedpagospedidoproveedor> findPedpagospedidoproveedorEntities(int maxResults, int firstResult);

    int getPedpagospedidoproveedorCount();
    
}
