/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase modelo de gestion de la modificación de artículos.
 * @author Computer
 */
public class ModificacionArticulosModelo {
    private ResultSet rs = null;

    public ModificacionArticulosModelo() {
    }
    
    /**
     * Modifica el articulo en la base de datos.
     * @param articulo
     * @return true si es exitoso.
     */
    public boolean modificarArticulo(Articulo articulo) {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call modificarArticulo_IN(?,?,?,?,?,?)}");
            //establecemos los valores de los parámetros.     
            cs.setString(1, articulo.getNombre());
            cs.setString(2, articulo.getProductora());
            cs.setString(3, articulo.getClasificacion());
            cs.setString(4, articulo.getGenero());
            cs.setInt(5, articulo.getStock());
            cs.setInt(6, articulo.getIdArticulo());
            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Modifica la pelicula en la base de datos.
     * @param pelicula
     * @return true si es exitoso.
     * @throws ParseException 
     */
    public boolean modificarPelicula(Pelicula pelicula) throws ParseException {
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = null;
        java.sql.Date fecha2 = null;

        fecha = ft.parse(pelicula.getFechaLanz());
        fecha2 = new java.sql.Date(fecha.getTime());

        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call modificarPelicula_IN(?,?,?,?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, Articulo.getIdArticulo(pelicula.getNombre()));
            cs.setString(2, pelicula.getNombreDirector());
            cs.setString(3, pelicula.getPais());
            cs.setDate(4, fecha2);
            cs.setInt(5, pelicula.getDuracion());
            cs.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    /**
     * Modifica la serie en la base de datos.
     * @param serie
     * @return true si es exitoso. 
     */
    public boolean modificarSerie(Serie serie) {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call modificarSerie_IN(?,?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, Articulo.getIdArticulo(serie.getNombre()));
            cs.setInt(2, serie.getnCapitulos());
            cs.setInt(3, serie.getnTemporadas());
            cs.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    
    
    
    
    
    
}
