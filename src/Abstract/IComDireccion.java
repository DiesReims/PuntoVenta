/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.NonexistentEntityException;
import Model.Comdireccion;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IComDireccion {

    void create(Comdireccion comdireccion);

    void destroy(Integer id) throws NonexistentEntityException;

    void edit(Comdireccion comdireccion) throws NonexistentEntityException, Exception;

    Comdireccion findComdireccion(Integer id);

    List<Comdireccion> findComdireccionEntities();

    List<Comdireccion> findComdireccionEntities(int maxResults, int firstResult);

    int getComdireccionCount();
    
}
