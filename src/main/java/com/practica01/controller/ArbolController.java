
package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.services.ArbolService;
import com.practica01.servicesimpl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arbol") 
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    
    
    @GetMapping ("/listado") // ruta
    public String listado(Model model) {
        
        var lista=arbolService.getArboles(false);
        
        model.addAttribute("arboles", lista); 
        model.addAttribute("totalArboles", lista.size()); 
        
        return "/arbol/listado"; // archivo html
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getIdArbol()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

   /* @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArboles(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    } */
    
}
