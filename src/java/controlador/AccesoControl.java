/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.entidad.Usuario;

/**
 *
 * @author carlos
 */
@ManagedBean
@ViewScoped
public class AccesoControl implements Serializable {
    public void verificarSesion(int privilegio){
        LoginControl objeto = new LoginControl();
        FacesMessage mensaje = null;
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if(user != null)
            {
                if(user.getPrivilegios().getIdPrivilegio()!=privilegio)
                {
                    context.getExternalContext().redirect("/Bodega");
                    objeto.cerrarSession();
                }else{
                    mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ ",user.getNombreUsuario() );
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                }
            }else{
                context.getExternalContext().redirect("/Bodega");
                objeto.cerrarSession();
            }
        }catch(Exception e){
        
        }
    }
}
