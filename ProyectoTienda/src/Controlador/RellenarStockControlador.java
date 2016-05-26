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

public class RellenarStockControlador implements ActionListener {

    private RellenarStock vista;
    private VentaArticulosModelo modelo;

    public RellenarStockControlador(RellenarStock vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VentaArticulosModelo();
        if (evento.getActionCommand().equals(RellenarStock.ACEPTAR)) {
            if (modelo.aumentarStock(RellenarStock.getJcombo(),RellenarStock.getTCantidad())) {
                vista.mostrarInfo("Se ha rellenado satisfactoriamente al articulo con id: " + RellenarStock.getJcombo());
            } else {
                vista.mostrarInfo("Ha habido un error!");
            }
            vista.cerrarVentana();

        } else if (evento.getActionCommand().equals(BajaArticulo.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
