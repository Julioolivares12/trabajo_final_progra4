/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.TipoProductoDao;
import modelo.entidad.Tipoproducto;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class TipoProductoControl {

    private List<Tipoproducto> listaTipoProductos;
    private Tipoproducto TipoProducto;
    public TipoProductoControl() {
        TipoProducto = new Tipoproducto();
    }

    public List<Tipoproducto> getListaTipoProductos() {
        TipoProductoDao cd = new TipoProductoDao();
        listaTipoProductos = cd.listarTipoproductos();
        return listaTipoProductos;
    }

    public void setListaTipoProductos(List<Tipoproducto> listaTipoProductos) {
        this.listaTipoProductos = listaTipoProductos;
    }

    public Tipoproducto getTipoProducto() {
        return TipoProducto;
    }

    public void setTipoProducto(Tipoproducto TipoProducto) {
        this.TipoProducto = TipoProducto;
    }

    public void limpiarTipoProducto() {
        TipoProducto = new Tipoproducto();
    }

   public void agregarTipoProducto() {
        TipoProductoDao cd = new TipoProductoDao();
    /*    TipoProducto.setUsuario(loginControl.getUsuario());
        */
        System.out.println(TipoProducto.getTipo());
        cd.agregar(TipoProducto);
        limpiarTipoProducto();
    }

    public void modificarTipoProducto() {
        TipoProductoDao cd = new TipoProductoDao();
        cd.modificar(TipoProducto);
        limpiarTipoProducto();
    }

    public void eliminarTipoProducto() {
        TipoProductoDao cd = new TipoProductoDao();
        cd.eliminar(TipoProducto);
        limpiarTipoProducto();
    }

    /*public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }*/

}
