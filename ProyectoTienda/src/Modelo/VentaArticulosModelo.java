package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase modelo de la gestion de ventas de articulos.
 * @author Computer
 */
public class VentaArticulosModelo {

    private ResultSet rs = null;

    public VentaArticulosModelo() {
    }

    
    /**
     * Actualiza el stock en la base de datos.
     *
     * @param idArticulo
     * @param stock
     * @return true si es exitoso.
     */
    public boolean actualizarStock(int idArticulo, int stock) {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call modificarStockArticulo_IN(?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, idArticulo);
            cs.setInt(2, stock);
            cs.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Aumenta el stock de un articulo en la base de datos.
     *
     * @param idArticulo
     * @param stock
     * @return true si es exitoso.
     */
    public boolean aumentarStock(int idArticulo, int stock) {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call aumentarStock_IN(?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, idArticulo);
            cs.setInt(2, stock);
            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Genera una venta en la base de datos, es decir, introduce una fila en el
     * historial de ventas.
     *
     * @param venta
     * @return true si es exitoso.
     * @throws ParseException
     */
    public boolean genVenta(Venta venta) throws ParseException {
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = null;
        java.sql.Date fecha2 = null;

        fecha = ft.parse(venta.getFechaTransacción());
        fecha2 = new java.sql.Date(fecha.getTime());

        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call genVenta_IN(?,?,?,?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, venta.getIdArticulo());
            cs.setDate(2, fecha2);
            cs.setInt(3, venta.getCantidad());
            cs.setFloat(4, venta.getPrecio());
            cs.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Devuelve el stock del articulo a través del conocimiento del id.
     *
     * @param idArticulo
     * @return devuelve el stock del articulo.
     */
    public int getStock(int idArticulo) {
        try {
            Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            CallableStatement cs;
            cs = GenConexionMod.getConexion().prepareCall("{call getStock_OUT(?)}");
            //establecemos los valores de los parámetros.
            cs.setInt(1, idArticulo);
            rs = cs.executeQuery();

            rs.beforeFirst();
            rs.next();
            int stock = rs.getInt(1);
            rs.close();
            return stock;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    /**
     * Modifica el articulo en la base de datos y genera la venta.
     *
     * @param venta
     * @return true si es exitoso.
     * @throws ParseException
     */
    public boolean ventaArticulo(Venta venta) throws ParseException {
        if (venta.getStock() <= getStock(venta.getIdArticulo())) {
            actualizarStock(venta.getIdArticulo(), venta.getStock());
            genVenta(venta);
            return true;
        } else {
            return false;
        }
    }
}
