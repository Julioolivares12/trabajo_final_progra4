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
import modelo.entidad.Bodegas;
import modelo.entidad.Cliente;
import modelo.entidad.Factura;

/**
 *
 * @author julio
 */
@ManagedBean
@ViewScoped
public class FacturaControl implements Serializable {

    
    /**
     * Creates a new instance of FacturaControl
     */
    //Listas
    private List<Factura> listaFactura;
    private List<SelectItem> listaBodegas;
    private List<SelectItem> listaCliente;

    
    //variables
    private Factura factura;
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
    public FacturaControl() {
       factura = new Factura();
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
    public List<SelectItem>getListaClientes(){
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
        p.agregar(factura);
    }
    public void modificarFactura(){
        FacturaDao p = new FacturaDao();
        p.actualizar(factura);
    }
    
    
}
