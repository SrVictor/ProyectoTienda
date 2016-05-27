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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearUsuarioControlador implements ActionListener {

    private CrearUsuario vista;
    private GenConexionMod modelo;

    public CrearUsuarioControlador(CrearUsuario vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equals(CrearUsuario.ACEPTAR)) {
            try {
                modelo = new GenConexionMod();
                if (modelo.crearUsuario(vista.getTUsuario(), vista.getTContrasena(), vista.getJCombo(), vista.getTNombre())) {
                    vista.mostrarInfo("Se ha creado el usuario satisfactoriamente: " + vista.getTUsuario());
                } else {
                    vista.mostrarInfo("Ha habido un error!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CrearUsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.cerrarVentana();

        } else if (evento.getActionCommand().equals(Vender.CANCELAR)) {
            vista.cerrarVentana();
        }

    }
}
