/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AltaBajaArticulo;
import Modelo.GenConexionMod;
import Vista.AltaArticuloTab;
import Vista.Login;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AltaControladorTab implements ActionListener {

    private AltaArticuloTab vista;
    private AltaBajaArticulo modelo;
    private MenuPrincipal vista2;
    
    public AltaControladorTab(AltaArticuloTab vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new AltaBajaArticulo();
        if (evento.getActionCommand().equals("Aceptar Articulo")) {
            try {
                modelo.altaArticulo(vista.generarArticulo());
                vista.cerrarVentana();
            } catch (SQLException ex) {
                Logger.getLogger(AltaControladorTab.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getActionCommand().equals("Aceptar Serie")) {
            try {
                modelo.altaSerie(vista.generarSerie());
                vista.cerrarVentana();
            } catch (SQLException ex) {
                Logger.getLogger(AltaControladorTab.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else if (evento.getActionCommand().equals("Aceptar Pelicula")) {
            try {
                modelo.altaPelicula(vista.generarPelicula());
                vista.cerrarVentana();
            } catch (SQLException ex) {
                Logger.getLogger(AltaControladorTab.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(AltaControladorTab.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        else if (evento.getActionCommand().equals(AltaArticuloTab.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}