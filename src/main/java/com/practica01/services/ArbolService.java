
package com.practica01.services;

import com.practica01.domain.Arbol;
import java.util.List;


public interface ArbolService {
    
    // se obtiene un list de objetos arbol que son los registros de la tabla arbol
    // pueden ser todos o solo los activos
    public List<Arbol> getArboles(boolean activos);
    
    // eliminar, actualizar, o agregar arboles
    
    // Se obtiene un Arbol, a partir del id de un arbol
    public Arbol getArbol(Arbol arbol);
    
    // Se inserta un nuevo arbol si el id del arbol esta vacío
    // Se actualiza un arbol si el id del arbol NO esta vacío
    public void save(Arbol arbol);
    
    // Se elimina el arbol que tiene el id pasado por parámetro
    public void delete(Arbol arbol);
    
}
