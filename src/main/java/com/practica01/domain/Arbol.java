
package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data 
@Entity 
@Table(name="arbol")
// clase para almacenar datos
public class Arbol implements Serializable { 
    
    private static final long serialVersionUID = 11; 
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idArbol; 
    private String nombreComun;
    private String tipoFlor;
    private int edad;
    private int altura;
    private String rutaImagen;
}

