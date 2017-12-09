/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
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
//@Named(value = "productoBean")
@ViewScoped
@Named("productoBean")
public class ProductoBean implements Serializable{

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
       
    }
    
    private Producto producto;
    private List<Producto> listaProducto;
    private List<SelectItem> listaBodegas;
     private Bodegas bodegas;
    private List<SelectItem> listaCliente;
    private Cliente cliente;
    private List<SelectItem> listaTipoproducto;
    private Tipoproducto tipo;

    //metodos set y get
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProducto() {
        ProductoDao dao = new ProductoDao();
        this.listaProducto = dao.listaProducto();
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<SelectItem> getListaBodegas() {
        this.listaBodegas = new ArrayList<>();
        BodegasDao dao = new BodegasDao();
        List<Bodegas> bode = dao.listarBodegas();
        for(Bodegas b : bode){
            SelectItem bodegaItem = new SelectItem(b.getIdBodega());
            listaBodegas.add(bodegaItem);
        }
        return listaBodegas;
    }

    public void setListaBodegas(List<SelectItem> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }

    public Bodegas getBodegas() {
        return bodegas;
    }

    public void setBodegas(Bodegas bodegas) {
        this.bodegas = bodegas;
    }

    public List<SelectItem> getListaCliente() {
        ClienteDao dao = new ClienteDao();
        this.listaCliente = new ArrayList<>();
        List<Cliente> clientes = dao.listarClientes();
        for(Cliente c : clientes){
            SelectItem clienteItem = new SelectItem(c.getIdCliente()+""+c.getNombre());
            listaCliente.add(clienteItem);
        }
        return listaCliente;
    }

    public void setListaCliente(List<SelectItem> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<SelectItem> getListaTipoproducto() {
        this.listaTipoproducto = new ArrayList<>();
        TipoProductoDao dao = new TipoProductoDao();
        List<Tipoproducto> tipoP = dao.listarTipoproductos();
        for(Tipoproducto t : tipoP){
            SelectItem tipoItem = new SelectItem(t.getIdTipo());
            listaTipoproducto.add(tipoItem);
        }
        return listaTipoproducto;
    }

    public void setListaTipoproducto(List<SelectItem> listaTipoproducto) {
        this.listaTipoproducto = listaTipoproducto;
    }

    public Tipoproducto getTipo() {
        return tipo;
    }

    public void setTipo(Tipoproducto tipo) {
        this.tipo = tipo;
    }
    
    // metodos CRUD
    public void guardar(){
        ProductoDao dao;
        dao = new ProductoDao();
        dao.agregar(producto);
    }
    public void actualizar(){
       ProductoDao dao = new ProductoDao();
       dao.actualizar(producto);
    }
    public void limpiarProducto(){
        Producto producto;
        producto = new Producto();
    }
    @PostConstruct
public void init() {
   producto = new Producto();
}
    
}
    

    

