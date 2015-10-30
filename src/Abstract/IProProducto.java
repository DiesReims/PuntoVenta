/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.NonexistentEntityException;
import Model.Proproducto;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IProProducto {

    void create(Proproducto proproducto);

    void destroy(Integer id) throws NonexistentEntityException;

    void edit(Proproducto proproducto) throws NonexistentEntityException, Exception;

    Proproducto findProproducto(Integer id);

    List<Proproducto> findProproductoEntities();

    List<Proproducto> findProproductoEntities(int maxResults, int firstResult);

    int getProproductoCount();
    
}
