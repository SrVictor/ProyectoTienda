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

public class SeleccionArticuloControlador implements ActionListener {

    private SeleccionArticulo vistaSeleccion;
    private AltaArticulo vistaArticulo;
    private ModificarArticulo modificarArticulo;
    private static String menu;
    private static String seleccion;

    public SeleccionArticuloControlador(SeleccionArticulo vista) {
        this.vistaSeleccion = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(vistaSeleccion.SERIE)) {
            seleccion = "Serie";
            vistaSeleccion.cerrarVentana();
        } else if (evento.getActionCommand().equals(vistaSeleccion.PELICULA)) {
            seleccion = "Pelicula";
            vistaSeleccion.cerrarVentana();
        }

        if (menu.equals("Alta Articulo")) {
            vistaArticulo = new AltaArticulo(seleccion);
            AltaControlador ac = new AltaControlador(vistaArticulo);
            vistaArticulo.setControlador(ac);

        } else if (menu.equals("Modificar Articulo")) {
            try {
                if (seleccion.equals("Serie")) {
                    modificarArticulo = new ModificarArticulo(seleccion, Serie.rellenarComboBoxID());
                    ModificarControlador mc = new ModificarControlador(modificarArticulo);
                    modificarArticulo.setControlador(mc);
                } else if (seleccion.equals("Pelicula")) {
                    modificarArticulo = new ModificarArticulo(seleccion, Pelicula.rellenarComboBoxID());
                    ModificarControlador mc = new ModificarControlador(modificarArticulo);
                    modificarArticulo.setControlador(mc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SeleccionArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getSeleccion() {
        return seleccion;
    }

    public static void setMenu(String menu) {
        SeleccionArticuloControlador.menu = menu;
    }

}
