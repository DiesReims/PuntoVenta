package Control.Interface;

import java.util.ArrayList;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public interface IOperaciones {

    public Boolean Agregar(Object _o);

    public Boolean Delete(Object _o);
    
    public Boolean Modificar(Object _o);

    public Object ConsultaEspecifica(Object _o);

    public ArrayList<Object> ConsultaGeneral(Object _o);
    
    public ArrayList<Object> ConsultaBuscar(Object _o);
    
    public ArrayList<Object> ConsultaNoCatalogo(Object _o);

}
