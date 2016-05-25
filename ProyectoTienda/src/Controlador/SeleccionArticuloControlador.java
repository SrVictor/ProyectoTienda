/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.GenConexionMod;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.SeleccionArticulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionArticuloControlador implements ActionListener {

    private SeleccionArticulo vista;

    public SeleccionArticuloControlador(SeleccionArticulo vista) {
        this.vista = vista;

    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(vista.SERIE)) {
            vista.setSeleccion("Serie");
            vista.cerrarVentana();
        } else if (evento.getActionCommand().equals(vista.PELICULA)) {
            vista.setSeleccion("Pelicula");
            vista.cerrarVentana();
        }

    }
}
