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
import modelo.dao.BodegasDao;
import modelo.dao.BodegasclientesDao;
import modelo.dao.ClienteDao;
import modelo.entidad.Bodegas;
import modelo.entidad.Bodegasclientes;
import modelo.entidad.Cliente;
/**
 *
 * @author Mcortez
 */

@ManagedBean
@ViewScoped
public class BodegasclientesControl {
    
    private List<Bodegasclientes> listaBodegasclientes;
    private Bodegasclientes bodegasclientes;
    private List<SelectItem> listaBodegas;
    private List<SelectItem> listaClientes;

     public BodegasclientesControl() {
        bodegasclientes = new Bodegasclientes();
    }

    public List<Bodegasclientes> getListaBodegasclientes() {
        BodegasclientesDao rd = new BodegasclientesDao();
        listaBodegasclientes = rd.listarBodegasclientes();
        return listaBodegasclientes;
    }

    public void setListaBodegasclientes(List<Bodegasclientes> listaBodegasclientes) {
        this.listaBodegasclientes = listaBodegasclientes;
    }

    public Bodegasclientes getBodegasclientes() {
        return bodegasclientes;
    }

    public void setBodegasclientes(Bodegasclientes bodegasclientes) {
        this.bodegasclientes = bodegasclientes;
    }

    public List<SelectItem> getListaBodegas() {
        this.listaClientes = new ArrayList<SelectItem>();
        BodegasDao cd = new BodegasDao();
        List<Bodegas> clientes = cd.listarBodegas();
        listaBodegasclientes.clear();
        for (Bodegas cliente : clientes) {
            SelectItem clienteItem = new SelectItem(cliente.getIdBodega());
            listaClientes.add(clienteItem);
        }
        return listaBodegas;
    }

    public void setListaBodegas(List<SelectItem> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }

    public List<SelectItem> getListaClientes() {
        this.listaClientes = new ArrayList<SelectItem>();
        ClienteDao cd = new ClienteDao();
        List<Cliente> clientes = cd.listarClientes();
        listaBodegasclientes.clear();
        for (Cliente cliente : clientes) {
            SelectItem clienteItem = new SelectItem(cliente.getNombre());
            listaClientes.add(clienteItem);
        }
        return listaClientes;
    }

    public void setListaClientes(List<SelectItem> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public void limpiarBodegasclientes() {
        bodegasclientes = new Bodegasclientes();
    }

    public void agregarBodegasclientes() {
        BodegasclientesDao rd = new BodegasclientesDao();     
        rd.agregar(bodegasclientes);
    }

    public void modificarBodegasclientes() {
        BodegasclientesDao rd = new BodegasclientesDao();
        rd.modificar(bodegasclientes);
        limpiarBodegasclientes();
    }

    public void eliminarBodegasclientes() {
        BodegasclientesDao rd = new BodegasclientesDao();
        rd.eliminar(bodegasclientes);
        limpiarBodegasclientes();
    }

}
