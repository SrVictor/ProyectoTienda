/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author David
 */
public class BajaArticulo extends PlantillaVista {

    private static JComboBox Jcombo;
    JFrame frame;
    JPanel topPanel;
    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";
    private static JButton btnAceptar;
    private static JButton btnCancelar;
    private static JLabel Lnombre, LnombreD, LidArticulo;

    public BajaArticulo(JComboBox comboBox) throws SQLException {
        frame = new JFrame("Baja Articulo");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop(comboBox));
        frame.pack();// coloca los componentes
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setVisible(true);
    }

    JPanel construyePanelTop(JComboBox comboBox) throws SQLException {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2, 5, 5));

        Jcombo = comboBox;

        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        Jcombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idArticulo = (Integer) Jcombo.getSelectedItem();
                try {
                    Articulo articulo = VisualizarMod.genArticulo(idArticulo);
                    LnombreD.setText(articulo.getNombre());

                } catch (SQLException ex) {
                    Logger.getLogger(BajaArticulo.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        LidArticulo = new JLabel("idArticulo: ");
        Lnombre = new JLabel("Nombre: ");
        LnombreD = new JLabel("");

        topPanel.add(LidArticulo);
        topPanel.add(Jcombo);
        topPanel.add(Lnombre);
        topPanel.add(LnombreD);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        topPanel.add(btnAceptar);
        topPanel.add(btnCancelar);

        return topPanel;
    }

    public void setControlador(BajaArticuloControlador escucharBoton) {
        btnAceptar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }

    public static int getJcombo() {
        return (Integer) Jcombo.getSelectedItem();
    }

          public void cerrarVentana() {
        frame.dispose();
    }
}
