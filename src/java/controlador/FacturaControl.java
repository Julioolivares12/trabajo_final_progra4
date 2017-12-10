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
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.BodegasDao;
import modelo.dao.ClienteDao;
import modelo.dao.FacturaDao;
import modelo.dao.TipoPagoDao;
import modelo.entidad.Bodegas;
import modelo.entidad.Cliente;
import modelo.entidad.Factura;
import modelo.entidad.Tipopago;

/**
 *
 * @author julio
 */
@ManagedBean
@ViewScoped
public class FacturaControl {

    
    /**
     * Creates a new instance of FacturaControl
     */
    //Listas
    private List<Factura> listaFactura;
    private List<SelectItem> listaBodegas;
    private List<SelectItem> listaCliente;
    private List<SelectItem> listaTipoPago;

    public List<SelectItem> getListaCliente() {
        this.listaCliente = new ArrayList<SelectItem>();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> c = clienteDao.listarClientes();
        listaCliente.clear();
        for(Cliente cliente1 : c){
            SelectItem clienteItem = new SelectItem(cliente1.getNombre());
            listaCliente.add(clienteItem);
        }
        return listaCliente;
    }

    public void setListaCliente(List<SelectItem> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Tipopago getTipopago() {
        return tipopago;
    }

    public void setTipopago(Tipopago tipopago) {
        this.tipopago = tipopago;
    }
    
    //variables
    private Factura factura;
    private Bodegas bodegas;
    private Cliente cliente;
    private Tipopago tipopago;
    private String estado;

    public FacturaControl() {
       factura = new Factura();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public List<Factura>getListaFactura(){
        FacturaDao p = new FacturaDao();
        listaFactura = p.listaFactura();
        return listaFactura;
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

    public List<SelectItem> getListaTipopago() {
        this.listaTipoPago = new ArrayList<SelectItem>();
        TipoPagoDao clienteDao = new TipoPagoDao();
        List<Tipopago> c = clienteDao.listaTipopago();
        listaTipoPago.clear();
        for(Tipopago cliente1 : c){
            SelectItem clienteItem = new SelectItem(cliente1.getTipoPago());
            listaTipoPago.add(clienteItem);
        }
        return listaTipoPago;
    }

    public void setListaTipopago(List<SelectItem> listaTipoPago) {
        this.listaTipoPago = listaTipoPago;
    }

     public void setListaFactura(List<Factura>listaFactura){
        this.listaFactura = listaFactura;
    }
    public void setFactura(Factura factura){
        this.factura=factura;
    }
    public Factura getFactura(){
        return this.factura;
    }
    public void limpiarFactura(){
        factura = new Factura();
    }
    public void agregarFactura(){
        FacturaDao p = new FacturaDao();
        correr();
        p.agregar(factura);
    }
    public void correr()
    {
        factura.setBodegas(bodegas);
        factura.setCliente(cliente);
        factura.setTipopago(tipopago);
        factura.setEstado(estado);
    }
    public void modificarFactura(){
        FacturaDao p = new FacturaDao();
        p.actualizar(factura);
    }
    
    
}
