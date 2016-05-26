package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Clase modelo de la gestión de alta y baja de artículos.
 *
 * @author Computer
 */
public class AltaBajaArticulo {

    private ResultSet rs = null;

    /**
     * Constructor básico de la clase modelo de acciones de articulos
     */
    public AltaBajaArticulo() {
    }

    /**
     * Da de alta a un articulo en la base de datos.
     *
     * @param articulo
     * @return true si es exitoso.
     * @throws SQLException
     */
    public boolean altaArticulo(Articulo articulo) throws SQLException {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call altaArticulo_IN(?,?,?,?,?,?)}");
            //establecemos los valores de los parámetros.
            cs.setString(1, articulo.getNombre());
            cs.setString(2, articulo.getProductora());
            cs.setString(3, articulo.getClasificacion());
            cs.setString(4, articulo.getGenero());
            cs.setInt(5, articulo.getStock());
            cs.setFloat(6, articulo.getPrecio());
            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    /**
     * Da de alta a una pelicula en la base de datos.
     *
     * @param pelicula
     * @return true si es exitoso.
     * @throws SQLException
     * @throws ParseException
     */
    public boolean altaPelicula(Pelicula pelicula) throws SQLException, ParseException {
        altaArticulo(pelicula);
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = null;
        java.sql.Date fecha2 = null;

        fecha = ft.parse(pelicula.getFechaLanz());
        fecha2 = new java.sql.Date(fecha.getTime());

        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call altaPelicula_IN(?,?,?,?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, Articulo.getIdArticulo(pelicula.getNombre()));
            cs.setString(2, pelicula.getNombreDirector());
            cs.setString(3, pelicula.getPais());
            cs.setDate(4, fecha2);
            cs.setInt(5, pelicula.getDuracion());
            cs.execute();
            System.out.println("Correcto");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Da de alta a una serie en la base de datos.
     *
     * @param serie
     * @return true si es exitoso.
     * @throws SQLException
     */
    public boolean altaSerie(Serie serie) throws SQLException {
        altaArticulo(serie);
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call altaSerie_IN(?,?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, Articulo.getIdArticulo(serie.getNombre()));
            cs.setInt(2, serie.getnCapitulos());
            cs.setInt(3, serie.getnTemporadas());
            cs.execute();
            System.out.println("Correcto");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Da de baja a un articulo en la base de datos.
     *
     * @param idArticulo
     * @return return true si es exitoso.
     */
    public boolean bajaArticulo(int idArticulo) {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call bajaArticulo_IN(?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, idArticulo);
            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean altaArticulos(ArrayList<Articulo> articulos) throws SQLException {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;

            for (int i = 0; i < articulos.size(); i++) {
                cs = GenConexionMod.getConexion().prepareCall("{call altaArticulo_IN(?,?,?,?,?,?)}");
                //establecemos los valores de los parámetros.
                cs.setString(1, articulos.get(i).getNombre());
                cs.setString(2, articulos.get(i).getProductora());
                cs.setString(3, articulos.get(i).getClasificacion());
                cs.setString(4, articulos.get(i).getGenero());
                cs.setInt(5, articulos.get(i).getStock());
                cs.setFloat(6, articulos.get(i).getPrecio());
                cs.execute();
                System.out.println("Correcto");
            }
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

}
