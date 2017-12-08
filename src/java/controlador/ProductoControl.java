/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import modelo.dao.BodegasDao;
import modelo.dao.ClienteDao;
import modelo.dao.ProductoDao;
import modelo.entidad.Bodegas;
import modelo.entidad.Cliente;
import modelo.entidad.Producto;

/**
 *
 * @author julio
 */
@ManagedBean
@ViewScoped
public class ProductoControl {

    /**
     * Creates a new instance of ProductoControl
     */
    private List<Producto> listaProducto;
    private List<Bodegas> listaBodegas;
    private List<Cliente> listaCliente;
    private Producto producto;
    private Cliente cliente;
    private Bodegas bodega;
    public ProductoControl() {
       producto = new Producto();
    }
    public List<Producto>getListaProducto(){
        ProductoDao p = new ProductoDao();
        listaProducto = p.listaProducto();
        return listaProducto;
    }
    public List<Bodegas>getListaBodegas(){
        BodegasDao bodegasDao = new BodegasDao();
        listaBodegas = bodegasDao.listarBodegas();
        return listaBodegas; 
    }
    public List<Cliente>getListaClientes(){
        ClienteDao cliente = new ClienteDao();
        listaCliente = cliente.listarClientes();
        return listaCliente;
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
