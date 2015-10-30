/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Comestadodireccion;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IComEstadoDireccion {

    void create(Comestadodireccion comestadodireccion);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Comestadodireccion comestadodireccion) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Comestadodireccion findComestadodireccion(Integer id);

    List<Comestadodireccion> findComestadodireccionEntities();

    List<Comestadodireccion> findComestadodireccionEntities(int maxResults, int firstResult);

    int getComestadodireccionCount();
    
}
