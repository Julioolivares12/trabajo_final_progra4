package modelo.entidad;
// Generated 20-nov-2017 17:28:13 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Bodegas generated by hbm2java
 */
public class Bodegas  implements java.io.Serializable {


     private Integer idBodega;
     private char estado;
     private BigDecimal alturaCmTotal;
     private BigDecimal anchoCmTotal;
     private BigDecimal largoCmTotal;
     private BigDecimal volumenTotal;
     private int numeroEstantes;
     private String descripcion;
     private BigDecimal precio;
     private BigDecimal volumenOcupado;
     private BigDecimal volumenDisponible;
     private Set<Producto> productos = new HashSet<Producto>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);
     private Set<Bodegasclientes> bodegasclienteses = new HashSet<Bodegasclientes>(0);

    public Bodegas() {
    }

	
    public Bodegas(char estado, BigDecimal alturaCmTotal, BigDecimal anchoCmTotal, BigDecimal largoCmTotal, BigDecimal volumenTotal, int numeroEstantes, String descripcion, BigDecimal precio, BigDecimal volumenOcupado, BigDecimal volumenDisponible) {
        this.estado = estado;
        this.alturaCmTotal = alturaCmTotal;
        this.anchoCmTotal = anchoCmTotal;
        this.largoCmTotal = largoCmTotal;
        this.volumenTotal = volumenTotal;
        this.numeroEstantes = numeroEstantes;
        this.descripcion = descripcion;
        this.precio = precio;
        this.volumenOcupado = volumenOcupado;
        this.volumenDisponible = volumenDisponible;
    }
    public Bodegas(char estado, BigDecimal alturaCmTotal, BigDecimal anchoCmTotal, BigDecimal largoCmTotal, BigDecimal volumenTotal, int numeroEstantes, String descripcion, BigDecimal precio, BigDecimal volumenOcupado, BigDecimal volumenDisponible, Set<Producto> productos, Set<Factura> facturas, Set<Bodegasclientes> bodegasclienteses) {
       this.estado = estado;
       this.alturaCmTotal = alturaCmTotal;
       this.anchoCmTotal = anchoCmTotal;
       this.largoCmTotal = largoCmTotal;
       this.volumenTotal = volumenTotal;
       this.numeroEstantes = numeroEstantes;
       this.descripcion = descripcion;
       this.precio = precio;
       this.volumenOcupado = volumenOcupado;
       this.volumenDisponible = volumenDisponible;
       this.productos = productos;
       this.facturas = facturas;
       this.bodegasclienteses = bodegasclienteses;
    }
   
    public Integer getIdBodega() {
        return this.idBodega;
    }
    
    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }
    public char getEstado() {
        return this.estado;
    }
    
    public void setEstado(char estado) {
        this.estado = estado;
    }
    public BigDecimal getAlturaCmTotal() {
        return this.alturaCmTotal;
    }
    
    public void setAlturaCmTotal(BigDecimal alturaCmTotal) {
        this.alturaCmTotal = alturaCmTotal;
    }
    public BigDecimal getAnchoCmTotal() {
        return this.anchoCmTotal;
    }
    
    public void setAnchoCmTotal(BigDecimal anchoCmTotal) {
        this.anchoCmTotal = anchoCmTotal;
    }
    public BigDecimal getLargoCmTotal() {
        return this.largoCmTotal;
    }
    
    public void setLargoCmTotal(BigDecimal largoCmTotal) {
        this.largoCmTotal = largoCmTotal;
    }
    public BigDecimal getVolumenTotal() {
        return this.volumenTotal;
    }
    
    public void setVolumenTotal(BigDecimal volumenTotal) {
        this.volumenTotal = volumenTotal;
    }
    public int getNumeroEstantes() {
        return this.numeroEstantes;
    }
    
    public void setNumeroEstantes(int numeroEstantes) {
        this.numeroEstantes = numeroEstantes;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public BigDecimal getVolumenOcupado() {
        return this.volumenOcupado;
    }
    
    public void setVolumenOcupado(BigDecimal volumenOcupado) {
        this.volumenOcupado = volumenOcupado;
    }
    public BigDecimal getVolumenDisponible() {
        return this.volumenDisponible;
    }
    
    public void setVolumenDisponible(BigDecimal volumenDisponible) {
        this.volumenDisponible = volumenDisponible;
    }
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
    public Set<Bodegasclientes> getBodegasclienteses() {
        return this.bodegasclienteses;
    }
    
    public void setBodegasclienteses(Set<Bodegasclientes> bodegasclienteses) {
        this.bodegasclienteses = bodegasclienteses;
    }




}


