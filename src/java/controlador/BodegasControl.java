/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.BodegasDao;
import modelo.entidad.Bodegas;
/**
 *
 * @author Mcortez
 */

@ManagedBean
@ViewScoped
public class BodegasControl {
    
    private List<Bodegas> listaBodegas;
    private Bodegas bodegas;
    
     public BodegasControl() {
        bodegas = new Bodegas();
    }

    public List<Bodegas> getListaBodegas() {
        BodegasDao rd = new BodegasDao();
        listaBodegas = rd.listarBodegas();
        return listaBodegas;
    }

    public void setListaBodegas(List<Bodegas> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }

    public Bodegas getBodegas() {
        return bodegas;
    }

    public void setBodegas(Bodegas bodegas) {
        this.bodegas = bodegas;
    }

    public void limpiarBodegas() {
        bodegas = new Bodegas();
    }

    public void agregarBodegas() {
        BodegasDao rd = new BodegasDao();
       // bodegas.setUsuario(loginControl.getUsuario());
        rd.agregar(bodegas);
    }

    public void modificarBodegas() {
        BodegasDao rd = new BodegasDao();
        rd.modificar(bodegas);
        limpiarBodegas();
    }

    public void eliminarBodegas() {
        BodegasDao rd = new BodegasDao();
        rd.eliminar(bodegas);
        limpiarBodegas();
    }

}
