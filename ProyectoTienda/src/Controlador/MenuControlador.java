/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.GenConexionMod;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.SeleccionArticulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuControlador implements ActionListener {

    private MenuPrincipal vista;

    public MenuControlador(MenuPrincipal vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(MenuPrincipal.CREARUSUARIO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.ALTAARTICULO)) {
            SeleccionArticulo sac = new SeleccionArticulo();
            vista.cerrarVentana();
            sac.getSeleccion();
        } else if (evento.getActionCommand().equals(MenuPrincipal.BAJAPARTICULO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.MODIFICARARTICULO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.IMPORTARARTICULOS)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VENDERARTICULO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARARTICULOS)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARVENTAS)) {
        }

    }
}
