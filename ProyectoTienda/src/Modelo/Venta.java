package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

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
    private String fechaTransacción;
    private int cantidad;
    private float precioTotal;
    private static ArrayList<Venta> ventas;

    public Venta(int idVenta, String fechaTransición, int cantidad, float precioTotal, int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
        this.idVenta = idVenta;
        this.fechaTransacción = fechaTransición;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getFechaTransacción() {
        return fechaTransacción;
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
        VisualizarMod.genArrayVentas();
        return ventas;
    }

    public static void setVentas(ArrayList<Venta> ventas) {
        Venta.ventas = ventas;
    }

    public static void anadirVenta(Venta venta) {
        ventas.add(venta);
    }

}
