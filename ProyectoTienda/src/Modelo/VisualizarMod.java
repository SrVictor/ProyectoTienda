/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author Computer
 */
public class VisualizarMod {

    public static void genArrayArticulos() throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Articulos ;");
        ResultSetMetaData metaDatos = rs.getMetaData();
        Articulo.getArticulos().clear();
        while (rs.next()) {
            Articulo articulo = new Articulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
            Articulo.anadirArticulo(articulo);
        }
    }

    public static void genArrayPeliculas() throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Peliculas ;");
        Pelicula.getPeliculas().clear();
        while (rs.next()) {
            Articulo articulo = genArticulo(rs.getInt(1));
            Pelicula pelicula = new Pelicula(rs.getString(2), rs.getString(3), rs.getDate(4).toString(), rs.getInt(5), rs.getInt(1), articulo.getNombre(), articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
            Pelicula.anadirPelicula(pelicula);
        }
    }

    public static void genArraySeries() throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Series ;");
        Serie.getSeries().clear();
        while (rs.next()) {
            Articulo articulo = genArticulo(rs.getInt(1));
            Serie serie = new Serie(rs.getInt(2), rs.getInt(3), rs.getInt(1), articulo.getNombre(), articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
            Serie.anadirSerie(serie);
        }
    }

    public static void genArrayVentas() throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Ventas ;");
        Venta.getVentas().clear();
        while (rs.next()) {
            Articulo articulo = genArticulo(rs.getInt(1));
            Venta venta = new Venta(rs.getInt(1), rs.getDate(3).toString(), rs.getInt(4), rs.getInt(5),rs.getInt(2),articulo.getNombre(),articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
            Venta.anadirVenta(venta);
        }
    }

    public static Articulo genArticulo(int idArticulo) throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Articulos WHERE idArticulo = " + idArticulo + " ;");
        Articulo articulo = new Articulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
        return articulo;
    }
}