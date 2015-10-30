/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstract;

import Concrete.exceptions.IllegalOrphanException;
import Concrete.exceptions.NonexistentEntityException;
import Model.Comdatocontacto;
import java.util.List;

/**
 *
 * @author Dies
 */
public interface IComDatoContacto {

    void create(Comdatocontacto comdatocontacto);

    void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Comdatocontacto comdatocontacto) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Comdatocontacto findComdatocontacto(Integer id);

    List<Comdatocontacto> findComdatocontactoEntities();

    List<Comdatocontacto> findComdatocontactoEntities(int maxResults, int firstResult);

    int getComdatocontactoCount();
    
}
