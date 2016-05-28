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
import Vista.MostrarArticulosVista;

public class MenuControlador implements ActionListener {

    private MenuPrincipal vista;
    private SeleccionArticulo vistaSeleccion;
    private BajaArticulo vistaBaja;
    private RellenarStock vistaRellenar;
    private Vender vistaVender;
    private CrearUsuario vistaUsuario;
    private MostrarArticulosVista vistaArticulos;
    private MostrarVentasVista vistaVentas;

    public MenuControlador(MenuPrincipal vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(MenuPrincipal.CREARUSUARIO)) {
            vistaUsuario = new CrearUsuario();
            CrearUsuarioControlador cuc = new CrearUsuarioControlador(vistaUsuario);
            vistaUsuario.setControlador(cuc);
            vistaUsuario.arranca();
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
            try {
                vistaVender = new Vender(Articulo.rellenarComboBoxID());
                VenderControlador vc = new VenderControlador(vistaVender);
                vistaVender.setControlador(vc);
            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARARTICULOS)) {
            try {
                vistaArticulos = new MostrarArticulosVista(Articulo.getArticul());
                MostrarArticulosControlador vma = new MostrarArticulosControlador(vistaArticulos);
                vistaArticulos.setControlador(vma);

            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evento.getActionCommand().equals(MenuPrincipal.VISUALIZARVENTAS)) {
            try {
                vistaVentas = new MostrarVentasVista(Venta.getVent());
                MostrarVentasControlador mvc = new MostrarVentasControlador(vistaVentas);
                vistaVentas.setControlador(mvc);

            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
