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

public class MostrarSeriesControlador implements ActionListener {

    private MostrarSeriesVista vista;
    private VisualizarMod modelo;
    private MostrarArticulosVista vista2;
    private MostrarPeliculasVista vista3;

    public MostrarSeriesControlador(MostrarSeriesVista vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VisualizarMod();
        if (evento.getActionCommand().equals(MostrarSeriesVista.MOSTRAR)) {
            try {
                if (vista.getJcombo().equals("Articulos")) {
                    VisualizarMod.ArticulosToArray();
                    vista.cerrarVentana();
                    vista2 = new MostrarArticulosVista(Articulo.getArticul());
                    MostrarArticulosControlador msc = new MostrarArticulosControlador(vista2);
                    vista2.setControlador(msc);
                } else if (vista.getJcombo().equals("Peliculas")) {
                    VisualizarMod.genArrayPeliculas();
                    vista.cerrarVentana();
                    vista3 = new MostrarPeliculasVista(Pelicula.getPeliculass());
                    MostrarPeliculasControlador msc = new MostrarPeliculasControlador(vista3);
                    vista3.setControlador(msc);
                }

            } catch (SQLException ex) {
                Logger.getLogger(MostrarSeriesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.cerrarVentana();
        } else if (evento.getActionCommand().equals(MostrarArticulosVista.FILTRAR)) {
            try {
                if (!vista.getTDato().equals("")) {
                    vista.cerrarVentana();
                    MostrarSeriesVista vista2 = new MostrarSeriesVista(VisualizarMod.FiltroToStringSerie(vista.getFiltros(), vista.getTDato()));
                    MostrarSeriesControlador mvc = new MostrarSeriesControlador(vista2);
                    vista2.setControlador(mvc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MostrarVentasControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
