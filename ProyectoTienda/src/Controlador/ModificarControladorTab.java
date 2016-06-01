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
import Vista.ModificarArticulo;
import Vista.ModificarArticuloTab;
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
            modelo.modificarArticulo(vista.generarArticulo());
            vista.cerrarVentana();

        } else if (evento.getActionCommand().equals("Aceptar Serie")) {
            modelo.modificarSerie(vista.generarSerie());
            vista.cerrarVentana();

        }else if (evento.getActionCommand().equals("Aceptar Pelicula")) {
            try {
                modelo.modificarPelicula(vista.generarPelicula());
                vista.cerrarVentana();
            } catch (ParseException ex) {
                Logger.getLogger(ModificarControladorTab.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        else if (evento.getActionCommand().equals(AltaArticuloTab.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}