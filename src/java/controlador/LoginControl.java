/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDao;
import modelo.entidad.Usuario;

/**
 *
 * @author carlos
 */
@ManagedBean
@SessionScoped
public class LoginControl implements Serializable {
    private Usuario user;
    public LoginControl() {
       this.user = new Usuario();
    }
    public void setUser(Usuario user) {
        this.user = user;
    }
    public Usuario getUser() {
        return user;
    }
    public String login(){
        FacesMessage mensaje = null;
        UsuarioDao dao = new UsuarioDao();
        user = dao.login(user);
        if(user != null)
        {
            //se crea la variable de sesion
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",user);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ ", this.user.getUsuario());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            if(user.getPrivilegios().getIdPrivilegio()==1)
            {
                if(user.getEstado()=='2')
                {
                    return "/vistas/usuarios/Inactivo.xhtml?faces-redirect=true";
                }else{
                    return "/vistas/administrador/index.xhtml?faces-redirect=true";
                }
            }
            else if(user.getPrivilegios().getIdPrivilegio()==2)
            {
                if(user.getEstado()=='2')
                {
                    return "/vistas/usuarios/Inactivo.xhtml?faces-redirect=true";
                }else{
                    return "/vistas/usuarios/index.xhtml?faces-redirect=true";
                }
            }
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Acceso", "Usuario o Clave incorrecta");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            user = new Usuario();
        }
        return null;
    }
    public String cerrarSession() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "/login?faces-redirect=true";
    }
    
}
