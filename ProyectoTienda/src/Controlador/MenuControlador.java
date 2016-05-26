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

public class MenuControlador implements ActionListener {

    private MenuPrincipal vista;
    private SeleccionArticulo vistaSeleccion;
    private BajaArticulo vistaBaja;
    private RellenarStock vistaRellenar;

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
            SeleccionArticuloControlador.setMenu("Modificar Articulo");
            vistaSeleccion = new SeleccionArticulo();
            SeleccionArticuloControlador sac = new SeleccionArticuloControlador(vistaSeleccion);
            vistaSeleccion.setControlador(sac);
            vistaSeleccion.arranca();
        } else if (evento.getActionCommand().equals(MenuPrincipal.IMPORTARARTICULOS)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.RELLENARSTOCK)) {
            try {
                vistaRellenar = new RellenarStock(Articulo.rellenarComboBoxID());
                RellenarStockControlador rsc = new RellenarStockControlador(vistaRellenar);
                vistaRellenar.setControlador(rsc);
            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getActionCommand().equals(MenuPrincipal.VENDERARTICULO)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARARTICULOS)) {
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARVENTAS)) {
        }

    }
}
