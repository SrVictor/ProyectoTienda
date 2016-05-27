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
public class Vender extends PlantillaVista {

    private static JComboBox Jcombo;
    JFrame frame;
    JPanel topPanel;
    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";
    private static JButton btnAceptar;
    private static JButton btnCancelar;
    private static JButton btnPrecioTotal;
    private static JLabel Lnombre, LnombreD, LidArticulo, LStock, LStockD, LCantidad, LPrecio, LPrecioD, LPrecioTotalD;
    private static JTextField TCantidad;

    public Vender(JComboBox comboBox) throws SQLException {
        frame = new JFrame("Vender Articulo");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop(comboBox));
        frame.pack();// coloca los componentes
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setVisible(true);
    }

    JPanel construyePanelTop(JComboBox comboBox) throws SQLException {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(7, 2, 5, 5));

        Jcombo = comboBox;

        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        Jcombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idArticulo = (Integer) Jcombo.getSelectedItem();
                try {
                    Articulo articulo = VisualizarMod.genArticulo(idArticulo);
                    LnombreD.setText(articulo.getNombre());
                    LStockD.setText(String.valueOf(articulo.getStock()));
                    LPrecioD.setText(String.valueOf(articulo.getPrecio()));

                } catch (SQLException ex) {
                    Logger.getLogger(Vender.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        LidArticulo = new JLabel("idArticulo: ");
        Lnombre = new JLabel("Nombre: ");
        LnombreD = new JLabel();
        LStock = new JLabel("Stock: ");
        LStockD = new JLabel();
        LCantidad = new JLabel("Cantidad");
        TCantidad = new JTextField();
        LPrecio = new JLabel("Precio: ");
        LPrecioD = new JLabel();
        btnPrecioTotal = new JButton("Precio Total: ");
        LPrecioTotalD = new JLabel();

        topPanel.add(LidArticulo);
        topPanel.add(Jcombo);
        topPanel.add(Lnombre);
        topPanel.add(LnombreD);
        topPanel.add(LStock);
        topPanel.add(LStockD);
        topPanel.add(LPrecio);
        topPanel.add(LPrecioD);
        topPanel.add(LCantidad);
        topPanel.add(TCantidad);
        topPanel.add(btnPrecioTotal);
        topPanel.add(LPrecioTotalD);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        topPanel.add(btnAceptar);
        topPanel.add(btnCancelar);

        btnPrecioTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TCantidad.getText().equals("")) {
                    Vender.mostrarInfo2("No se ha introducido la cantidad.");
                } else {
                    LPrecioTotalD.setText(String.valueOf(Float.valueOf(LPrecioD.getText()) * Integer.valueOf(TCantidad.getText())));
                }
            }
        });

        return topPanel;
    }

    public void setControlador(VenderControlador escucharBoton) {
        btnAceptar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }

    public static int getJcombo() {
        return (Integer) Jcombo.getSelectedItem();
    }

    public static int getTCantidad() {
        if (TCantidad.getText().equals("")) {
            return 0;
        }
        return Integer.valueOf(TCantidad.getText());
    }

    public static Venta genVenta() {
        System.out.println("Stock" + LStockD.getText());
        return new Venta(Integer.valueOf(TCantidad.getText()), Float.valueOf(LPrecioTotalD.getText()), (int) Jcombo.getSelectedItem(), Integer.valueOf(LStockD.getText()));
    }

    public static JLabel getLPrecioTotalD() {
        return LPrecioTotalD;
    }

    public static JLabel getLPrecioD() {
        return LPrecioD;
    }

    public static int getLStockD() {
        if (LStockD.getText().equals("")) {
            return 0;
        }
        return Integer.valueOf(LStockD.getText());
    }

}
