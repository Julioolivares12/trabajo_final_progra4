package modelo.entidad;
// Generated 20-nov-2017 17:28:13 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


    
     private Integer idProducto;
     private Bodegas bodegas;
     private Cliente cliente;
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

    public Producto() {
        
     
        cliente = new Cliente();
        tipoproducto = new Tipoproducto();
        bodegas = new Bodegas();   
    }

	
    public Producto(Bodegas bodegas, Cliente cliente, Tipoproducto tipoproducto, String nombre, String descripcion, BigDecimal alturaCm, BigDecimal anchoCm, BigDecimal largoCm, BigDecimal volumen, BigDecimal pesoLibras, int stock) {
        this.bodegas = bodegas;
        this.cliente = cliente;
        this.tipoproducto = tipoproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alturaCm = alturaCm;
        this.anchoCm = anchoCm;
        this.largoCm = largoCm;
        this.volumen = volumen;
        this.pesoLibras = pesoLibras;
        this.stock = stock;
    }
    public Producto(Bodegas bodegas, Cliente cliente, Tipoproducto tipoproducto, String nombre, String descripcion, BigDecimal alturaCm, BigDecimal anchoCm, BigDecimal largoCm, BigDecimal volumen, BigDecimal pesoLibras, int stock, Set<Registrosalida> registrosalidas, Set<Registroentradas> registroentradases) {
       this.bodegas = bodegas;
       this.cliente = cliente;
       this.tipoproducto = tipoproducto;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.alturaCm = alturaCm;
       this.anchoCm = anchoCm;
       this.largoCm = largoCm;
       this.volumen = volumen;
       this.pesoLibras = pesoLibras;
       this.stock = stock;
       this.registrosalidas = registrosalidas;
       this.registroentradases = registroentradases;
    }

    public Integer getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public Bodegas getBodegas() {
        return this.bodegas;
    }
    
    public void setBodegas(Bodegas bodegas) {
        this.bodegas = bodegas;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Tipoproducto getTipoproducto() {
        return this.tipoproducto;
    }
    
    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getAlturaCm() {
        return this.alturaCm;
    }
    
    public void setAlturaCm(BigDecimal alturaCm) {
        this.alturaCm = alturaCm;
    }
    public BigDecimal getAnchoCm() {
        return this.anchoCm;
    }
    
    public void setAnchoCm(BigDecimal anchoCm) {
        this.anchoCm = anchoCm;
    }
    public BigDecimal getLargoCm() {
        return this.largoCm;
    }
    
    public void setLargoCm(BigDecimal largoCm) {
        this.largoCm = largoCm;
    }
    public BigDecimal getVolumen() {
        return this.volumen;
    }
    
    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
    }
    public BigDecimal getPesoLibras() {
        return this.pesoLibras;
    }
    
    public void setPesoLibras(BigDecimal pesoLibras) {
        this.pesoLibras = pesoLibras;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Set<Registrosalida> getRegistrosalidas() {
        return this.registrosalidas;
    }
    
    public void setRegistrosalidas(Set<Registrosalida> registrosalidas) {
        this.registrosalidas = registrosalidas;
    }
    public Set<Registroentradas> getRegistroentradases() {
        return this.registroentradases;
    }
    
    public void setRegistroentradases(Set<Registroentradas> registroentradases) {
        this.registroentradases = registroentradases;
    }




}


