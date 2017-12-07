/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import modelo.dao.ProductoDao;
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
        producto = new Producto();
    }
    public List<Producto>getListaProducto(){
        ProductoDao p = new ProductoDao();
        listaProducto = p.listaProducto();
        return listaProducto;
    }
    public void setListaProducto(List<Producto>listaProducto){
        this.listaProducto = listaProducto;
    }
    public void setProducto(Producto producto){
        this.producto=producto;
    }
    public Producto getProducto(){
        return this.producto;
    }
    public void limpiarProducto(){
        producto = new Producto();
    }
    public void agregarProducto(){
        ProductoDao p = new ProductoDao();
        p.agregar(producto);
    }
    public void modificarProducto(){
        ProductoDao p = new ProductoDao();
        p.actualizar(producto);
    }
}
