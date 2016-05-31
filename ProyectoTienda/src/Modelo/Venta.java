package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Computer
 */
public class Venta extends Articulo {

    private int idVenta;
    private String fechaTransaccion;
    private int cantidad;
    private float precioTotal;
    private static ArrayList<Venta> ventas;
    private static String[][] vent;

    public Venta(int idVenta, String fechaTransaccion, int cantidad, float precioTotal, int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
        this.idVenta = idVenta;
        this.fechaTransaccion = fechaTransaccion;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public Venta(int cantidad, float precioTotal, int idArticulo, int stock) {
        super(idArticulo, stock);
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public static ArrayList<Venta> getVentas() throws SQLException {
        return ventas;
    }

    public static void setVentas(ArrayList<Venta> ventas) {
        Venta.ventas = ventas;
    }

    public static void anadirVenta(Venta venta) {
        if (ventas == null) {
            ventas = new ArrayList<>();
        }
        ventas.add(venta);
    }

    public static String[][] getVent() throws SQLException {
        VisualizarMod.VentasToArray();
        return vent;
    }

    public static String[][] getVentass() throws SQLException {
        VisualizarMod.VentasToArray(ventas);
        return vent;
    }

    public static void setVent(String[][] venta) {
        Venta.vent = venta;
    }
}
