/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Computer
 */
public class VisualizarMod {

    public static void genArrayArticulos() throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Articulos ;");
        if (Articulo.getArticulos() != null) {
            Articulo.getArticulos().clear();
        }
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
        if (Serie.getSeries() != null) {
            Serie.getSeries().clear();
        }
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
            ///Venta venta = new Venta(rs.getInt(1), rs.getDate(3).toString(), rs.getInt(4), rs.getInt(5), rs.getInt(2), articulo.getNombre(), articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
            //Venta.anadirVenta(venta);
            System.out.println("SIN ACABARRRRRRRRRRRR--> MODELO>VISUALIZARMOD");
        }
    }

    public static Articulo genArticulo(int idArticulo) throws SQLException {
        System.out.println("idArticulo: " + idArticulo);
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Articulos WHERE idArticulo = " + idArticulo + " ;");
        rs.next();
        Articulo articulo = new Articulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getFloat(7));
        return articulo;
    }

    public static ArrayList<Integer> genIDArticulos() throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT idArticulo FROM Articulos ;");
        ArrayList<Integer> idArticulos = new ArrayList<>();
        while (rs.next()) {
            idArticulos.add(rs.getInt(1));
        }
        return idArticulos;
    }

    public static Serie genSerie(int idArticulo) throws SQLException {
        System.out.println("idArticulo: " + idArticulo);
        Serie serie = new Serie();
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM series WHERE idArticulo = " + idArticulo + " ;");
        rs.next();
        serie.setnCapitulos(rs.getInt(2));
        serie.setnTemporadas(rs.getInt(3));
        return serie;
    }

    public static Pelicula genPelicula(int idArticulo) throws SQLException {
        System.out.println("idArticulo: " + idArticulo);
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Articulos WHERE idArticulo = " + idArticulo + " ;");
        rs.next();
        Pelicula pelicula = new Pelicula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getFloat(7));

        rs = GenConexionMod.ejecutaQuery("SELECT * FROM series WHERE idArticulo = " + idArticulo + " ;");
        rs.next();
        pelicula.setNombreDirector(rs.getString(2));
        pelicula.setPais(rs.getString(3));
        pelicula.setFechaLanz(rs.getDate(4).toString());
        return pelicula;
    }

    public static void toArray() throws SQLException {
        genArrayArticulos();
        ArrayList<Articulo> articulos = Articulo.getArticulos();
        String[][] articulo = new String[articulos.size()][7];

        for (int i = 0; i < articulos.size(); i++) {
            articulo[i][0] = String.valueOf(articulos.get(i).getIdArticulo());
            System.out.println(articulo[i][0]);
            articulo[i][1] = articulos.get(i).getNombre();
            System.out.println(articulo[i][1]);
            articulo[i][2] = articulos.get(i).getProductora();
            articulo[i][3] = articulos.get(i).getClasificacion();
            articulo[i][4] = articulos.get(i).getGenero();
            articulo[i][5] = String.valueOf(articulos.get(i).getStock());
            articulo[i][6] = String.valueOf(articulos.get(i).getPrecio());

        }
        Articulo.setArticul(articulo);
    }
}
