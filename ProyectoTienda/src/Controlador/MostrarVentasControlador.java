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

public class MostrarVentasControlador implements ActionListener {

    private MostrarVentasVista vista;
    private VisualizarMod modelo;

    public MostrarVentasControlador(MostrarVentasVista vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new VisualizarMod();
        if (evento.getActionCommand().equals(MostrarVentasVista.ACEPTAR)) {
            try {
                VisualizarMod.genArrayVentas(vista.getDateChooser(), vista.getDateChooser2());
                vista.cerrarVentana();
                MostrarVentasVista vista2 = new MostrarVentasVista(Venta.getVentass());
                MostrarVentasControlador mvc = new MostrarVentasControlador(vista2);
                vista2.setControlador(mvc);
            } catch (SQLException ex) {
                Logger.getLogger(MostrarVentasControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getActionCommand().equals(MostrarVentasVista.EXPORTAR)) {
            VentanaSeleccionarXML vsf = new VentanaSeleccionarXML();
        } else if (evento.getActionCommand().equals(MostrarVentasVista.FILTRAR)) {
            try {
                if (!vista.getTDato().equals("")){
                MostrarVentasVista vista2 = new MostrarVentasVista(VisualizarMod.FiltroToStringVenta(vista.getFiltros(), vista.getTDato()));
                MostrarVentasControlador mvc = new MostrarVentasControlador(vista2);
                vista2.setControlador(mvc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MostrarVentasControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
