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
    private BigDecimal vt,al,an,la,vo,vd; 
    private char estado;
    
    
   // private BigDecimal al; //altura
   // private BigDecimal an; //anchi
   // private BigDecimal la; //largo 
    //vd=disponible
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
      al=bodegas.getAlturaCmTotal();
      an= bodegas.getAnchoCmTotal();
      la=bodegas.getLargoCmTotal();
      vt= (al.multiply(an)).multiply(la);
      vo = vt.subtract(vt);   
      estado='D';
      bodegas.setVolumenTotal(vt);
      bodegas.setVolumenDisponible(vt);
      bodegas.setVolumenOcupado(vo);
      bodegas.setEstado(estado);
        rd.agregar(bodegas);
    }

    public void modificarBodegas() {
        BodegasDao rd = new BodegasDao();
        
      al=bodegas.getAlturaCmTotal();
      an= bodegas.getAnchoCmTotal();
      la=bodegas.getLargoCmTotal();
      vt= (al.multiply(an)).multiply(la);
      vd= vt.subtract(bodegas.getVolumenOcupado());
      
      bodegas.setVolumenTotal(vt);
      bodegas.setVolumenDisponible(vd);

        rd.modificar(bodegas);
        limpiarBodegas();
    }

    public void eliminarBodegas() {
        BodegasDao rd = new BodegasDao();
        rd.eliminar(bodegas);
        limpiarBodegas();
    }

}
