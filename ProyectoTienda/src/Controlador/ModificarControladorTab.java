/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AltaBajaArticulo;
import Modelo.GenConexionMod;
import Modelo.ModificacionArticulosModelo;
import Vista.AltaArticuloTab;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.ModificarArticuloTab;
import Vista.PlantillaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarControladorTab implements ActionListener {

    private ModificarArticuloTab vista;
    private ModificacionArticulosModelo modelo;

    public ModificarControladorTab(ModificarArticuloTab vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new ModificacionArticulosModelo();
        if (evento.getActionCommand().equals("Modificar Articulo")) {
            if (modelo.modificarArticulo(vista.generarArticulo())) {
                PlantillaVista.mostrarInfo2("Se ha modificacdo correctamente el artículo!");
                vista.cerrarVentana();
                ModificarArticuloTab mat = new ModificarArticuloTab();
                ModificarControladorTab mct = new ModificarControladorTab(mat);
                mat.setControlador(mct);
            }

        } else if (evento.getActionCommand().equals("Modificar Serie")) {
            if (modelo.modificarSerie(vista.generarSerie())) {
                PlantillaVista.mostrarInfo2("Se ha modificacdo correctamente el artículo!");
                vista.cerrarVentana();
                ModificarArticuloTab mat = new ModificarArticuloTab();
                ModificarControladorTab mct = new ModificarControladorTab(mat);
                mat.setControlador(mct);
            }

        } else if (evento.getActionCommand().equals("Modificar Pelicula")) {
            try {
                if (modelo.modificarPelicula(vista.generarPelicula())) {
                    PlantillaVista.mostrarInfo2("Se ha modificacdo correctamente el artículo!");
                    vista.cerrarVentana();
                    ModificarArticuloTab mat = new ModificarArticuloTab();
                    ModificarControladorTab mct = new ModificarControladorTab(mat);
                    mat.setControlador(mct);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ModificarControladorTab.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getActionCommand().equals(AltaArticuloTab.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
