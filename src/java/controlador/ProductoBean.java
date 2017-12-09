/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import modelo.entidad.Registroentradas;
import modelo.entidad.Registrosalida;
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
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the tipoproducto
     */
    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    /**
     * @param tipoproducto the tipoproducto to set
     */
    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the alturaCm
     */
    public BigDecimal getAlturaCm() {
        return alturaCm;
    }

    /**
     * @param alturaCm the alturaCm to set
     */
    public void setAlturaCm(BigDecimal alturaCm) {
        this.alturaCm = alturaCm;
    }

    /**
     * @return the anchoCm
     */
    public BigDecimal getAnchoCm() {
        return anchoCm;
    }

    /**
     * @param anchoCm the anchoCm to set
     */
    public void setAnchoCm(BigDecimal anchoCm) {
        this.anchoCm = anchoCm;
    }

    /**
     * @return the largoCm
     */
    public BigDecimal getLargoCm() {
        return largoCm;
    }

    /**
     * @param largoCm the largoCm to set
     */
    public void setLargoCm(BigDecimal largoCm) {
        this.largoCm = largoCm;
    }

    /**
     * @return the volumen
     */
    public BigDecimal getVolumen() {
        return volumen;
    }

    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
    }

    /**
     * @return the pesoLibras
     */
    public BigDecimal getPesoLibras() {
        return pesoLibras;
    }

    /**
     * @param pesoLibras the pesoLibras to set
     */
    public void setPesoLibras(BigDecimal pesoLibras) {
        this.pesoLibras = pesoLibras;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the registrosalidas
     */
    public Set<Registrosalida> getRegistrosalidas() {
        return registrosalidas;
    }

    /**
     * @param registrosalidas the registrosalidas to set
     */
    public void setRegistrosalidas(Set<Registrosalida> registrosalidas) {
        this.registrosalidas = registrosalidas;
    }

    /**
     * @return the registroentradases
     */
    public Set<Registroentradas> getRegistroentradases() {
        return registroentradases;
    }

    /**
     * @param registroentradases the registroentradases to set
     */
    public void setRegistroentradases(Set<Registroentradas> registroentradases) {
        this.registroentradases = registroentradases;
    }

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
    
     private Integer idProducto;
     
     private Tipoproducto tipoproducto;
     private String nombre;
     private String descripcion;
     private BigDecimal alturaCm;
     private BigDecimal anchoCm;
     private BigDecimal largoCm;
     private BigDecimal volumen;
     private BigDecimal pesoLibras;
     private int stock;
     private Set<Registrosalida> registrosalidas = new HashSet<>(0);
     private Set<Registroentradas> registroentradases = new HashSet<>(0);

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
        
        System.out.println(producto.getNombre() );
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
  this.producto = new Producto();
}
    
}
    

    

