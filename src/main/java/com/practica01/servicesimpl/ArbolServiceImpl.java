
package com.practica01.servicesimpl;

import com.practica01.dao.ArbolDao;
import com.practica01.domain.Arbol;
import com.practica01.services.ArbolService;
import com.practica01.services.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl 
        implements ArbolService {

    @Autowired 
    private ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }

    @Override
    public List<Arbol> getArboles(boolean activos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
