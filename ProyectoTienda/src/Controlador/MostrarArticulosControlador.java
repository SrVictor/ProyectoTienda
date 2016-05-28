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

public class MostrarArticulosControlador implements ActionListener {

    private MostrarArticulosVista vista;
    private VisualizarMod modelo;
    private MostrarSeriesVista vista2;

    public MostrarArticulosControlador(MostrarArticulosVista vista2) {
        this.vista = vista2;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VisualizarMod();
        System.out.println("EEEEEEEEEEEEEEEEEEEEEE");
        if (evento.getActionCommand().equals(MostrarArticulosVista.FILTRAR)) {
            try {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                if (vista.getJcombo().equals("Series")) {
                    System.out.println("OOOOOOOOOOOOOOOOOOOO");
                    VisualizarMod.SeriesToArray();
                    vista.cerrarVentana();
                    vista2 = new MostrarSeriesVista(Serie.getSerie());
                    MostrarSeriesControlador msc = new MostrarSeriesControlador(vista2);
                    vista2.setControlador(msc);
                    
                }

                vista.cerrarVentana();

            } catch (SQLException ex) {
                Logger.getLogger(MostrarArticulosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evento.getActionCommand().equals(BajaArticulo.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
