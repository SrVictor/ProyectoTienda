/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import Modelo.GenConexionMod;
import Vista.AltaArticulo;
import Vista.BajaArticulo;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.SeleccionArticulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuControlador implements ActionListener {

    private MenuPrincipal vista;
    private SeleccionArticulo vistaSeleccion;
    private BajaArticulo vistaBaja;

    public MenuControlador(MenuPrincipal vista) {
        System.out.println("1");
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(MenuPrincipal.CREARUSUARIO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.ALTAARTICULO)) {

            SeleccionArticuloControlador.setMenu("Alta Articulo");
            vistaSeleccion = new SeleccionArticulo();
            SeleccionArticuloControlador sac = new SeleccionArticuloControlador(vistaSeleccion);
            vistaSeleccion.setControlador(sac);
            vistaSeleccion.arranca();

        } else if (evento.getActionCommand().equals(MenuPrincipal.BAJAPARTICULO)) {
            try {
                vistaBaja = new BajaArticulo(Articulo.rellenarComboBoxID());
                BajaArticuloControlador bac = new BajaArticuloControlador(vistaBaja);
                vistaBaja.setControlador(bac);
            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getActionCommand().equals(MenuPrincipal.MODIFICARARTICULO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.IMPORTARARTICULOS)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.RELLENARSTOCK)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VENDERARTICULO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARARTICULOS)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARVENTAS)) {
        }

    }
}
