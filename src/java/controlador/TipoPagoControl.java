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
import modelo.dao.TipoPagoDao;
import modelo.entidad.Tipopago;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class TipoPagoControl {

    private List<Tipopago> listaTipoPago;
    private Tipopago tipoPago;
     public TipoPagoControl() {
    }

    public List<Tipopago> getListaTipoPago() {
        TipoPagoDao cd = new TipoPagoDao();
        listaTipoPago = cd.listaTipopago();
        return listaTipoPago;
    }

    public void setListaTipoPago(List<Tipopago> listaTipoPago) {
        this.listaTipoPago = listaTipoPago;
    }

    public Tipopago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Tipopago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void limpiarTipoPago() {
        tipoPago = new Tipopago();
      
    }

   public void agregarTipoPago() {
        TipoPagoDao cd = new TipoPagoDao();
    /*    cliente.setUsuario(loginControl.getUsuario());
        */
        cd.agregar(tipoPago);
    }

    public void modificarTipoPago() {
        TipoPagoDao cd = new TipoPagoDao();
        cd.modificar(tipoPago);
        limpiarTipoPago();
    }

    public void eliminarTipoPago() {
        TipoPagoDao cd = new TipoPagoDao();
        cd.eliminar(tipoPago);
        limpiarTipoPago();
    }

    /*public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }*/

}
