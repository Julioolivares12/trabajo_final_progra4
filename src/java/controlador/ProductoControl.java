/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import modelo.entidad.Producto;

/**
 *
 * @author julio
 */
@ManagedBean
@ViewScoped
public class ProductoControl {

    private List<Producto> listaProducto;
    private Producto producto;
    /**
     * Creates a new instance of ProductoControl
     */
    public ProductoControl() {
    }
    
    
}
