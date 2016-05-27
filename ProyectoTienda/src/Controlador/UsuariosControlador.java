/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.GenConexionMod;
import Vista.Login;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosControlador implements ActionListener {

    private Login vista;
    private GenConexionMod modelo;
    private MenuPrincipal vista2;

    public UsuariosControlador(Login vista, GenConexionMod modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(Login.ACEPTAR)) {
            modelo.abrirConexion();
            try {
                if (modelo.logear(vista.getTNombre(), vista.getTContrasena())) {
                    vista.mostrarInfo("Se ha conectado satisfactoriamente");
                    vista.cerrarVentana();
                    
                    MenuControlador mc = new MenuControlador(vista2);
                    vista2 = new MenuPrincipal();
                    vista2.setControlador(mc);
                    vista2.arranca();
                } else {
                    vista.mostrarInfo("No se a podido establecer conexión, comprueba los datos.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evento.getActionCommand().equals(Login.CANCELAR)) {
            vista.cerrar();
        }

    }
}
