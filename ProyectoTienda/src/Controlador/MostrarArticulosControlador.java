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
    private MostrarPeliculasVista vista3;

    public MostrarArticulosControlador(MostrarArticulosVista vista2) {
        this.vista = vista2;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VisualizarMod();
        if (evento.getActionCommand().equals(MostrarArticulosVista.MOSTRAR)) {
            try {
                if (vista.getJcombo().equals("Series")) {
                    VisualizarMod.SeriesToArray();
                    vista.cerrarVentana();
                    vista2 = new MostrarSeriesVista(Serie.getSerie());
                    MostrarSeriesControlador msc = new MostrarSeriesControlador(vista2);
                    vista2.setControlador(msc);
                } else if (vista.getJcombo().equals("Peliculas")) {
                    VisualizarMod.genArrayPeliculas();
                    vista.cerrarVentana();
                    vista3 = new MostrarPeliculasVista(Pelicula.getPeliculass());
                    MostrarPeliculasControlador msc = new MostrarPeliculasControlador(vista3);
                    vista3.setControlador(msc);
                }
                vista.cerrarVentana();

            } catch (SQLException ex) {
                Logger.getLogger(MostrarArticulosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evento.getActionCommand().equals(MostrarArticulosVista.FILTRAR)) {
            try {
                if (!vista.getTDato().equals("")) {
                    vista.cerrarVentana();
                    MostrarArticulosVista vista2 = new MostrarArticulosVista(VisualizarMod.FiltroToStringArticulo(vista.getFiltros(), vista.getTDato()));
                    MostrarArticulosControlador mvc = new MostrarArticulosControlador(vista2);
                    vista2.setControlador(mvc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MostrarVentasControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
