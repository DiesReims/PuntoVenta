/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Cattipoproducto;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface ICatTipoProducto {

    void create(Cattipoproducto cattipoproducto);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Cattipoproducto cattipoproducto) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Cattipoproducto findCattipoproducto(Integer id);

    List<Cattipoproducto> findCattipoproductoEntities();

    List<Cattipoproducto> findCattipoproductoEntities(int maxResults, int firstResult);

    int getCattipoproductoCount();
    
}
