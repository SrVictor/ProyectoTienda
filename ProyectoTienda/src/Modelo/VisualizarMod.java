/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if (Pelicula.getPeliculas() != null) {
            Pelicula.getPeliculas().clear();
        }
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
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM historialventas ;");
        System.out.println("genArrayVentas()");
        if (Venta.getVentas() != null) {
            Venta.getVentas().clear();
        }
        while (rs.next()) {
            Articulo articulo = genArticulo(rs.getInt(2));
            Venta venta = new Venta(rs.getInt(1), rs.getDate(3).toString(), rs.getInt(4), rs.getFloat(5), rs.getInt(2), articulo.getNombre(), articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
            Venta.anadirVenta(venta);
        }
    }

    public static void genArrayVentas(String fecha11, String fecha22) throws SQLException {
        try {
            if (Venta.getVentas() != null) {
                Venta.getVentas().clear();
            }
            System.out.println("Fecha 1: " + fecha11);
            System.out.println("Fecha 2: " + fecha22);
            System.out.println("genaRRAYVentaS(fecha1,fecha2)");
            DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha = null;
            java.sql.Date fecha1 = null;
            fecha = ft.parse(fecha11);
            fecha1 = new java.sql.Date(fecha.getTime());

            fecha = null;
            java.sql.Date fecha2 = null;
            fecha = ft.parse(fecha22);
            fecha2 = new java.sql.Date(fecha.getTime());

            System.out.println("Fecha 1: " + fecha1);
            System.out.println("Fecha 2: " + fecha2);

            String sentenciaSQL = "SELECT * FROM `historialventas` WHERE fechaTransaccion > \"" + fecha1 + "\" AND fechaTransaccion < \"" + fecha2 + "\";";
            ResultSet rs = GenConexionMod.ejecutaQuery(sentenciaSQL);

            while (rs.next()) {
                Articulo articulo = genArticulo(rs.getInt(2));
                Venta venta = new Venta(rs.getInt(1), rs.getDate(3).toString(), rs.getInt(4), rs.getFloat(5), rs.getInt(2), articulo.getNombre(), articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
                Venta.anadirVenta(venta);
            }
        } catch (ParseException ex) {
            Logger.getLogger(VisualizarMod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Articulo genArticulo(int idArticulo) throws SQLException {
        System.out.println("genArticulo()");
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
        System.out.println("genSerie(idArticulo)");
        System.out.println("idArticulo: " + idArticulo);
        Serie serie = new Serie();
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM series WHERE idArticulo = " + idArticulo + " ;");
        rs.next();
        serie.setnCapitulos(rs.getInt(2));
        serie.setnTemporadas(rs.getInt(3));
        return serie;
    }

    public static Pelicula genPelicula(int idArticulo) throws SQLException {
        System.out.println("genPelicula(idArticulo)");
        System.out.println("idArticulo: " + idArticulo);
        Pelicula pelicula = new Pelicula();

        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM peliculas WHERE idArticulo = " + idArticulo + " ;");
        rs.next();
        pelicula.setNombreDirector(rs.getString(2));
        pelicula.setPais(rs.getString(3));
        System.out.println("fecha: " + rs.getDate(4).toString());
        pelicula.setFechaLanz(rs.getDate(4).toString());
        pelicula.setDuracion(rs.getInt(5));
        return pelicula;
    }

    public static void ArticulosToArray() throws SQLException {
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

    public static void SeriesToArray() throws SQLException {
        genArraySeries();
        ArrayList<Serie> series = Serie.getSeries();
        String[][] serie = new String[series.size()][9];

        for (int i = 0; i < series.size(); i++) {
            serie[i][0] = String.valueOf(series.get(i).getIdArticulo());
            System.out.println("IdArticulo: " + series.get(i).getIdArticulo());
            serie[i][1] = series.get(i).getNombre();
            System.out.println("Nombre: " + series.get(i).getNombre());
            serie[i][2] = series.get(i).getProductora();
            serie[i][3] = series.get(i).getClasificacion();
            serie[i][4] = series.get(i).getGenero();
            serie[i][5] = String.valueOf(series.get(i).getStock());
            serie[i][6] = String.valueOf(series.get(i).getPrecio());
            serie[i][7] = String.valueOf(series.get(i).getnCapitulos());
            serie[i][8] = String.valueOf(series.get(i).getnTemporadas());

        }
        Serie.setSerie(serie);
    }

    public static void PeliculasToArray() throws SQLException {
        genArrayPeliculas();
        ArrayList<Pelicula> peliculas = Pelicula.getPeliculas();
        String[][] pelicula = new String[peliculas.size()][11];

        for (int i = 0; i < peliculas.size(); i++) {
            pelicula[i][0] = String.valueOf(peliculas.get(i).getIdArticulo());
            pelicula[i][1] = peliculas.get(i).getNombre();
            pelicula[i][2] = peliculas.get(i).getProductora();
            pelicula[i][3] = peliculas.get(i).getClasificacion();
            pelicula[i][4] = peliculas.get(i).getGenero();
            pelicula[i][5] = String.valueOf(peliculas.get(i).getStock());
            pelicula[i][6] = String.valueOf(peliculas.get(i).getPrecio());
            pelicula[i][7] = String.valueOf(peliculas.get(i).getNombreDirector());
            pelicula[i][8] = String.valueOf(peliculas.get(i).getPais());
            pelicula[i][9] = String.valueOf(peliculas.get(i).getFechaLanz());
            pelicula[i][10] = String.valueOf(peliculas.get(i).getDuracion());
        }
        Pelicula.setPeliculass(pelicula);
    }

    public static void VentasToArray() throws SQLException {
        System.out.println("VentasToArray()");
        genArrayVentas();
        ArrayList<Venta> ventas = Venta.getVentas();
        String[][] venta = new String[ventas.size()][10];

        for (int i = 0; i < ventas.size(); i++) {
            venta[i][0] = String.valueOf(ventas.get(i).getIdVenta());
            venta[i][1] = String.valueOf(ventas.get(i).getIdArticulo());
            System.out.println("VentasArray IdArticulo: " + ventas.get(i).getIdArticulo());
            venta[i][2] = ventas.get(i).getFechaTransaccion();
            venta[i][3] = String.valueOf(ventas.get(i).getCantidad());
            venta[i][4] = String.valueOf(ventas.get(i).getPrecioTotal());
            venta[i][5] = ventas.get(i).getNombre();
            System.out.println("Nombre: " + ventas.get(i).getNombre());
            venta[i][6] = ventas.get(i).getProductora();
            venta[i][7] = ventas.get(i).getClasificacion();
            venta[i][8] = ventas.get(i).getGenero();
            venta[i][9] = String.valueOf(ventas.get(i).getPrecio());

        }
        Venta.setVent(venta);
    }

    public static void VentasToArray(ArrayList<Venta> ventas) throws SQLException {
        System.out.println("VentasToArray()");
        String[][] venta = new String[ventas.size()][10];

        for (int i = 0; i < ventas.size(); i++) {
            venta[i][0] = String.valueOf(ventas.get(i).getIdVenta());
            venta[i][1] = String.valueOf(ventas.get(i).getIdArticulo());
            System.out.println("VentasArray IdArticulo: " + ventas.get(i).getIdArticulo());
            venta[i][2] = ventas.get(i).getFechaTransaccion();
            venta[i][3] = String.valueOf(ventas.get(i).getCantidad());
            venta[i][4] = String.valueOf(ventas.get(i).getPrecioTotal());
            venta[i][5] = ventas.get(i).getNombre();
            System.out.println("Nombre: " + ventas.get(i).getNombre());
            venta[i][6] = ventas.get(i).getProductora();
            venta[i][7] = ventas.get(i).getClasificacion();
            venta[i][8] = ventas.get(i).getGenero();
            venta[i][9] = String.valueOf(ventas.get(i).getPrecio());

        }
        Venta.setVent(venta);
    }

    public static ArrayList<Venta> genFiltroVentas(String filtro, String dato) throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM historialventas WHERE " + filtro + " = \"" + dato + "\";");
        ArrayList<Venta> ventas = new ArrayList<>();
        while (rs.next()) {
            Articulo articulo = genArticulo(rs.getInt(2));
            Venta venta = new Venta(rs.getInt(1), rs.getDate(3).toString(), rs.getInt(4), rs.getFloat(5), rs.getInt(2), articulo.getNombre(), articulo.getProductora(), articulo.getClasificacion(), articulo.getGenero(), articulo.getStock(), articulo.getPrecio());
            ventas.add(venta);
        }
        return ventas;
    }

    public static String[][] FiltroToStringVenta(String filtro, String dato) throws SQLException {
        System.out.println("FiltroToString()");

        ArrayList<Venta> ventas = genFiltroVentas(filtro, dato);
        String[][] venta = new String[ventas.size()][10];

        for (int i = 0; i < ventas.size(); i++) {
            venta[i][0] = String.valueOf(ventas.get(i).getIdVenta());
            venta[i][1] = String.valueOf(ventas.get(i).getIdArticulo());
            venta[i][2] = ventas.get(i).getFechaTransaccion();
            venta[i][3] = String.valueOf(ventas.get(i).getCantidad());
            venta[i][4] = String.valueOf(ventas.get(i).getPrecioTotal());
            venta[i][5] = ventas.get(i).getNombre();
            venta[i][6] = ventas.get(i).getProductora();
            venta[i][7] = ventas.get(i).getClasificacion();
            venta[i][8] = ventas.get(i).getGenero();
            venta[i][9] = String.valueOf(ventas.get(i).getPrecio());
        }
        return venta;
    }

    public static ArrayList<Articulo> genFiltroArticulos(String filtro, String dato) throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Articulos WHERE " + filtro + " = \"" + dato + "\";");
        ArrayList<Articulo> articulos = new ArrayList<>();
        while (rs.next()) {
            Articulo articulo = genArticulo(rs.getInt(1));
            articulos.add(articulo);
        }
        return articulos;
    }

    public static String[][] FiltroToStringArticulo(String filtro, String dato) throws SQLException {

        ArrayList<Articulo> articulos = genFiltroArticulos(filtro, dato);
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
        return articulo;
    }

    public static Serie genFiltroSeries(String idArticulo) throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT nCapitulos,nTemporadas FROM Series WHERE idArticulo = \"" + idArticulo + "\";");
        Serie serie = new Serie();
        while (rs.next()) {
            serie = new Serie(rs.getInt(1), rs.getInt(2));
        }
        return serie;
    }

    public static String[][] FiltroToStringSerie(String filtro, String dato) throws SQLException {
        ArrayList<Articulo> articulos = genFiltroArticulos(filtro, dato);
        String[][] serie = new String[articulos.size()][9];

        for (int i = 0; i < articulos.size(); i++) {
            serie[i][0] = String.valueOf(articulos.get(i).getIdArticulo());
            System.out.println("IdArticulo: " + articulos.get(i).getIdArticulo());
            serie[i][1] = articulos.get(i).getNombre();
            System.out.println("Nombre: " + articulos.get(i).getNombre());
            serie[i][2] = articulos.get(i).getProductora();
            serie[i][3] = articulos.get(i).getClasificacion();
            serie[i][4] = articulos.get(i).getGenero();
            serie[i][5] = String.valueOf(articulos.get(i).getStock());
            serie[i][6] = String.valueOf(articulos.get(i).getPrecio());
            Serie serie1 = genFiltroSeries(serie[i][0]);
            serie[i][7] = String.valueOf(serie1.getnCapitulos());
            serie[i][8] = String.valueOf(serie1.getnTemporadas());

        }
        return serie;
    }

    public static Pelicula genFiltroPeliculas(String idArticulo) throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM Series WHERE idArticulo = \"" + idArticulo + "\";");
        Pelicula pelicula = new Pelicula();
        while (rs.next()) {
            pelicula.setNombreDirector(rs.getString(2));
            pelicula.setPais(rs.getString(3));
            pelicula.setFechaLanz(rs.getDate(4).toString());
            pelicula.setDuracion(rs.getInt(5));
        }
        return pelicula;
    }

    public static String[][] FiltroToStringPelicula(String filtro, String dato) throws SQLException {
        ArrayList<Articulo> articulos = genFiltroArticulos(filtro, dato);
        String[][] pelicula = new String[articulos.size()][11];

        for (int i = 0; i < articulos.size(); i++) {
            pelicula[i][0] = String.valueOf(articulos.get(i).getIdArticulo());
            System.out.println("IdArticulo: " + articulos.get(i).getIdArticulo());
            pelicula[i][1] = articulos.get(i).getNombre();
            System.out.println("Nombre: " + articulos.get(i).getNombre());
            pelicula[i][2] = articulos.get(i).getProductora();
            pelicula[i][3] = articulos.get(i).getClasificacion();
            pelicula[i][4] = articulos.get(i).getGenero();
            pelicula[i][5] = String.valueOf(articulos.get(i).getStock());
            pelicula[i][6] = String.valueOf(articulos.get(i).getPrecio());
            Pelicula pelicula1 = genFiltroPeliculas(pelicula[i][0]);
            pelicula[i][7] = pelicula1.getNombreDirector();
            pelicula[i][8] = pelicula1.getPais();
            pelicula[i][9] = pelicula1.getFechaLanz();
            pelicula[i][10] = String.valueOf(pelicula1.getDuracion());
        }
        return pelicula;
    }

}
