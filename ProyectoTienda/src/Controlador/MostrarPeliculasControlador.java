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

public class MostrarPeliculasControlador implements ActionListener {

    private MostrarPeliculasVista vista;
    private VisualizarMod modelo;
    private MostrarArticulosVista vista2;
    private MostrarSeriesVista vista3;

    public MostrarPeliculasControlador(MostrarPeliculasVista vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VisualizarMod();
        if (evento.getActionCommand().equals(MostrarPeliculasVista.MOSTRAR)) {
            try {
                if (vista.getJcombo().equals("Articulos")) {
                    VisualizarMod.ArticulosToArray();
                    vista.cerrarVentana();
                    vista2 = new MostrarArticulosVista(Articulo.getArticul());
                    MostrarArticulosControlador msc = new MostrarArticulosControlador(vista2);
                    vista2.setControlador(msc);
                } else if (vista.getJcombo().equals("Series")) {
                    VisualizarMod.SeriesToArray();
                    vista.cerrarVentana();
                    vista3 = new MostrarSeriesVista(Serie.getSerie());
                    MostrarSeriesControlador msc = new MostrarSeriesControlador(vista3);
                    vista3.setControlador(msc);
                }

            } catch (SQLException ex) {
                Logger.getLogger(MostrarPeliculasControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.cerrarVentana();
        } else if (evento.getActionCommand().equals(MostrarArticulosVista.FILTRAR)) {
            try {
                if (!vista.getTDato().equals("")) {
                    vista.cerrarVentana();
                    MostrarPeliculasVista vista2 = new MostrarPeliculasVista(VisualizarMod.FiltroToStringPelicula(vista.getFiltros(), vista.getTDato()));
                    MostrarPeliculasControlador mvc = new MostrarPeliculasControlador(vista2);
                    vista2.setControlador(mvc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MostrarVentasControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
