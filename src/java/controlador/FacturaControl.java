/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.FacturaDao;
import modelo.entidad.Factura;
/**
 *
 * @author Mcortez
 */

@ManagedBean
@ViewScoped
public class FacturaControl {
    
    private List<Factura> listaFactura;
    private Factura factura;
     public FacturaControl() {
        factura = new Factura();
    }

    public List<Factura> getListaFactura() {
        FacturaDao rd = new FacturaDao();
        listaFactura = rd.listarFactura();
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void limpiarFactura() {
        factura = new Factura();
    }

    public void agregarFactura() {
        FacturaDao rd = new FacturaDao();   
        rd.agregar(factura);
    }

    public void modificarFactura() {
        FacturaDao rd = new FacturaDao();
        rd.modificar(factura);
        limpiarFactura();
    }

    public void eliminarFactura() {
        FacturaDao rd = new FacturaDao();
        rd.eliminar(factura);
        limpiarFactura();
    }

}
