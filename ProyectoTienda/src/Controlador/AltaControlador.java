/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AltaBajaArticulo;
import Modelo.GenConexionMod;
import Vista.AltaArticulo;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.SeleccionArticulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AltaControlador implements ActionListener {

    private AltaArticulo vista;
    private AltaBajaArticulo modelo;
    private MenuPrincipal vista2;
    
    public AltaControlador(AltaArticulo vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(AltaArticulo.ACEPTAR)) {
            vista.cerrarVentana();

            modelo = new AltaBajaArticulo();
            if (SeleccionArticuloControlador.getSeleccion().equals("Serie")) {
                try {
                    modelo.altaSerie(vista.generarSerie());
                } catch (SQLException ex) {
                    Logger.getLogger(AltaControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (SeleccionArticuloControlador.getSeleccion().equals("Pelicula")) {
                try {
                    modelo.altaPelicula(vista.generarPelicula());
                } catch (SQLException ex) {
                    Logger.getLogger(AltaControlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AltaControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               vista.cerrarVentana();
                
                MenuControlador mc = new MenuControlador(vista2);
                vista2 = new MenuPrincipal();
                vista2.setControlador(mc);
                vista2.arranca();

        } else if (evento.getActionCommand().equals(AltaArticulo.CANCELAR)) {
        }

    }
}
