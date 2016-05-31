/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VenderControlador implements ActionListener {

    private Vender vista;
    private VentaArticulosModelo modelo;

    public VenderControlador(Vender vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VentaArticulosModelo();
        if (evento.getActionCommand().equals(Vender.ACEPTAR)) {
            if (Vender.getTCantidad() <= Vender.getLStockD() && Vender.getTCantidad() != 0) {
                try {
                    Vender.getLPrecioTotalD().setText(String.valueOf(Float.valueOf(Vender.getLPrecioD().getText()) * Vender.getTCantidad()));
                    if (modelo.ventaArticulo(Vender.genVenta())) {
                        vista.mostrarInfo("Se ha vendido satisfactoriamente al articulo con id: " + Vender.getJcombo());
                        Vender vistaVender = new Vender(Articulo.rellenarComboBoxID());
                        VenderControlador vc = new VenderControlador(vistaVender);
                        vistaVender.setControlador(vc);
                        vista.cerrarVentana();
                    } else {
                        vista.mostrarInfo("Ha habido un error!");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(VenderControlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VenderControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                vista.cerrarVentana();
            }
        } else if (evento.getActionCommand().equals(Vender.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
