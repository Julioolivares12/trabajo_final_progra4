/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modelo.dao.ClienteDao;
import modelo.entidad.Cliente;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class ClienteControl {

    private List<Cliente> listaClientes;
    private Cliente cliente;
     public ClienteControl() {
    }

    public List<Cliente> getListaClientes() {
        ClienteDao cd = new ClienteDao();
        listaClientes = cd.listarClientes();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void limpiarCliente() {
        cliente = new Cliente();
        cliente.setFechaUnion(new Date());
    }

   public void agregarCliente() {
        ClienteDao cd = new ClienteDao();
    /*    cliente.setUsuario(loginControl.getUsuario());
        */
        cd.agregar(cliente);
    }

    public void modificarCliente() {
        ClienteDao cd = new ClienteDao();
        cd.modificar(cliente);
        limpiarCliente();
    }

    public void eliminarCliente() {
        ClienteDao cd = new ClienteDao();
        cd.eliminar(cliente);
        limpiarCliente();
    }

    /*public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }*/

}
