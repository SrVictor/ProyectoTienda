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
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostrarVentasControlador implements ActionListener {

    private MostrarVentasVista vista;
    private VisualizarMod modelo;
    
    public MostrarVentasControlador(MostrarVentasVista vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VisualizarMod();
       if (evento.getActionCommand().equals(MostrarVentasVista.ACTUALIZAR)) {
            vista.cerrarVentana();
        }

    }
}
