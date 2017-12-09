/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.BodegasDao;
import modelo.dao.ClienteDao;
import modelo.dao.ProductoDao;
import modelo.dao.TipoProductoDao;
import modelo.entidad.Bodegas;
import modelo.entidad.Cliente;
import modelo.entidad.Producto;
import modelo.entidad.Tipoproducto;

/**
 *
 * @author julio
 */
@ManagedBean(name="productoControl")
@ViewScoped
public class ProductoControl implements Serializable {

    
    /**
     * Creates a new instance of ProductoControl
     */
    //Listas
    private List<Producto> listaProducto;
    private Producto producto;
    private List<SelectItem> listaBodegas;
    private List<SelectItem> listaCliente;
    private List<SelectItem> listaTipoproducto;
            
    //variables
    
    @ManagedProperty("#{bodegas}")
    private Bodegas bodegas;
    @ManagedProperty("#{cliente}")
    private Cliente cliente;
        @ManagedProperty("#{tipo}")

    private Tipoproducto tipo;


    public List<SelectItem> getListaTipoproducto() {
        this.listaTipoproducto = new ArrayList<>();
       TipoProductoDao tipo = new TipoProductoDao();
        List<Tipoproducto> tp = tipo.listarTipoproductos();
        
        listaTipoproducto.clear();
        tp.stream().map((tproducto) -> new SelectItem(tproducto.getIdTipo())).forEachOrdered((tipoItem) -> {
            listaTipoproducto.add(tipoItem);
        });
        return listaTipoproducto;
    }

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

    public Tipoproducto getTipo() {
        return tipo;
    }

    public void setTipo(Tipoproducto tipo) {
        this.tipo = tipo;
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
        this.listaBodegas = new ArrayList<>();
        BodegasDao bodegasDao = new BodegasDao();
        List<Bodegas> b = bodegasDao.listarBodegas();
        listaBodegas.clear();
        b.stream().map((bodega) -> new SelectItem(bodega.getIdBodega())).forEachOrdered((bodegaItem) -> {
            listaBodegas.add(bodegaItem);
        });
        return listaBodegas; 
    }
    public List<SelectItem>getListaClientes(){
        this.listaCliente = new ArrayList<>();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> c = clienteDao.listarClientes();
        listaCliente.clear();
        c.stream().map((cliente1) -> new SelectItem(cliente1.getIdCliente()+" "+cliente1.getNombre())).forEachOrdered((clienteItem) -> {
            listaCliente.add(clienteItem);
        });
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
        limpiarProducto();
    }
    public void modificarProducto(){
        ProductoDao p = new ProductoDao();
        p.actualizar(producto);
    }
    
    
}
