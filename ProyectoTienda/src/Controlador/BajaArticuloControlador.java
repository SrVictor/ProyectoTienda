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

public class BajaArticuloControlador implements ActionListener {

    private BajaArticulo vista;
    private AltaBajaArticulo modelo;

    public BajaArticuloControlador(BajaArticulo vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new AltaBajaArticulo();
        if (evento.getActionCommand().equals(BajaArticulo.ACEPTAR)) {
            if (modelo.bajaArticulo(BajaArticulo.getJcombo())) {
                vista.mostrarInfo("Se ha dado de baja satisfactoriamente al articulo con id: " + BajaArticulo.getJcombo());
            } else {
                vista.mostrarInfo("Ha habido un error!");
            }
            vista.cerrarVentana();

        } else if (evento.getActionCommand().equals(BajaArticulo.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
