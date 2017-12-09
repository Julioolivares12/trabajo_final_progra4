/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidad.Tipopago;
import modelo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author julio
 */
public class TipoPagoDao {
     public List<Tipopago> listaTipopago(){
        List<Tipopago> lista=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String sql = "FROM Tipopago";
        try{
            lista = session.createQuery(sql).list();
            t.commit();
        }catch(Exception e){
            t.rollback();
        }
        return lista;
    }
    public void agregar(Tipopago producto){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
    }
    public void actualizar(Tipopago producto){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session != null)
                session.close();
        }
    }
    public void eleminar(Tipopago producto){
        Session session=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session!=null)
                session.close();
        }
    }
}
