/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author 
 */
//@Named(value = "reporteControl")
//@Dependent
@ManagedBean
@ViewScoped

public class ReporProductosControl implements Serializable {

    JasperPrint jasperPrint;
    HttpServletResponse httpServletResponse = null;
    private String nombre;
   
    

    /**
     * Creates a new instance of ReporteControl
     */
    public ReporProductosControl() {
    }

    public void generarReporte() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bodegas", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println("Error de conexion: " + ex.getMessage());
        }

        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportPath = sc.getRealPath("vistas/administrador/reportes/reporteProductos.jasper");

        String logoPath = sc.getRealPath("vistas/administrador/reportes/3.png");

        

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre );
        

        parametros.put("logo", logoPath);
        
        try {
            jasperPrint = JasperFillManager.fillReport(reportPath, parametros, con);
        } catch (JRException ex) {
            Logger.getLogger(ReporProductosControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "inline; filename=productos.pdf");
        ServletOutputStream servletOutputStream;
        try {
            servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        } catch (IOException | JRException ex) {
            Logger.getLogger(ReporProductosControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
     
}
