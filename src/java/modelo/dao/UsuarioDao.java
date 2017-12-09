/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.entidad.Usuario;
import modelo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class UsuarioDao{
    public Usuario login(Usuario user)
    {
        Usuario usuario = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta;
        try{
            consulta = "FROM Usuario u where u.usuario =:user and u.passwords=:pass";
            Query query = sesion.createQuery(consulta);
            query.setParameter("user",user.getUsuario());
            query.setParameter("pass",user.getPasswords());
            usuario = (Usuario) query.uniqueResult();
        }catch(Exception e){
            FacesMessage mensaje = null;
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "",""+e+"");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return usuario;
    }
    public void CrearCuenta(Usuario usuario){
        
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tr = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        }
        catch(Exception ex){
            if(tr!=null)
                tr.rollback();
            ex.getMessage();
        }
        
    }
}
