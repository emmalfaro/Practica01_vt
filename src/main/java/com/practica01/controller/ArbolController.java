
package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.services.ArbolService;
import com.practica01.servicesimpl.FirebaseStorageServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/arbol")
@Slf4j
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado") // ruta
    public String listado(Model model) {
        var lista = arbolService.getArboles(false);

        log.info("Total de arboles retornados: {}", lista.size());
        model.addAttribute("arboles", lista);
        model.addAttribute("content", "arboles/listado");

        return "/layout/plantilla"; // archivo html
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol) {
        log.info("Arbol enviado: {}", arbol);
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        if (arbol.getIdArbol() != null)
            log.info("Arbol para actualizar: {}", arbol.getIdArbol());
        var arbolFound = arbolService.getArbol(arbol);

        log.info("Arbol encontrado en DB: {}", arbolFound);
        
        model.addAttribute("content", "arboles/modifica");
        model.addAttribute("arbol", arbolFound);

        return "/layout/plantilla";
    }

}
