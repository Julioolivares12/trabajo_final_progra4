/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidad.Producto;
import modelo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author julio
 */
public class ProductoDao {
     public List<Producto> listaProducto(){
        List<Producto> lista=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String sql = "FROM Producto";
        try{
            lista = session.createQuery(sql).list();
            t.commit();
        }catch(Exception e){
            t.rollback();
        }
        return lista;
    }
    public void agregar(Producto producto){
        
    }
}
