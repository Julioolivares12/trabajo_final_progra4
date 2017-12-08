/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
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
    private List<SelectItem> listaBodegas;
    private List<SelectItem> listaCliente;
    private Producto producto;
    private Bodegas bodegas;
    private Cliente cliente;

    public Bodegas getBodegas() {
        return bodegas;
    }

    public void setBodegas(Bodegas bodegas) {
        this.bodegas = bodegas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ProductoControl() {
       producto = new Producto();
    }
    public List<Producto>getListaProducto(){
        ProductoDao p = new ProductoDao();
        listaProducto = p.listaProducto();
        return listaProducto;
    }
    public List<SelectItem>getListaBodegas(){
        this.listaBodegas = new ArrayList<SelectItem>();
        BodegasDao bodegasDao = new BodegasDao();
        List<Bodegas> b = bodegasDao.listarBodegas();
        listaBodegas.clear();
        for(Bodegas bodega : b)
        {
            SelectItem bodegaItem = new SelectItem(bodega.getIdBodega());
            listaBodegas.add(bodegaItem);
        }
        return listaBodegas; 
    }
    public List<SelectItem>getListaClientes(){
        this.listaCliente = new ArrayList<SelectItem>();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> c = clienteDao.listarClientes();
        listaCliente.clear();
        for(Cliente cliente1 : c){
            SelectItem clienteItem = new SelectItem(cliente1.getIdCliente()+" "+cliente1.getNombre());
            listaCliente.add(clienteItem);
        }
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
