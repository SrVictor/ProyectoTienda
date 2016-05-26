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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarControlador implements ActionListener {

    private ModificarArticulo vista;
    private ModificacionArticulosModelo modelo;

    public ModificarControlador(ModificarArticulo vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new ModificacionArticulosModelo();
        if (evento.getActionCommand().equals(BajaArticulo.ACEPTAR)) {
            if (ModificarArticulo.getTipo().equals("Serie")) {
                if (modelo.modificarSerie(vista.generarSerie())) {
                    vista.mostrarInfo("Se ha dado de modificado satisfactoriamente el articulo con id: " + ModificarArticulo.getJcombo());
                } else {
                    vista.mostrarInfo("Ha habido un error!");
                }
            } else if (ModificarArticulo.getTipo().equals("Pelicula")) {
                try {
                    if (modelo.modificarPelicula(vista.generarPelicula())) {
                        vista.mostrarInfo("Se ha dado de modificado satisfactoriamente el articulo con id: " + ModificarArticulo.getJcombo());
                    } else {
                        vista.mostrarInfo("Ha habido un error!");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ModificarControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            vista.cerrarVentana();

        } else if (evento.getActionCommand().equals(BajaArticulo.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
