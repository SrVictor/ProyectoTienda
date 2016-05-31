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
public class ModificarArticulo extends PlantillaVista {

    private static String tipo;
    static JComboBox Jcombo;
    JFrame frame;
    JPanel topPanel, panelSerie, panelPelicula, panelBot, comboPanel;
    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";
    private static JButton btnAceptar;
    private static JButton btnCancelar;
    private JTextField Tnombre, Tproductora, Tclasificacion, Tgenero, Tstock, Tprecio;
    private JTextField TnombreDirector, Tpais, TfechaLanz, Tduracion;
    private JTextField TnCapitulos, TnTemporadas;
    private static JLabel Lnombre, Lproductora, Lclasificacion, Lgenero, Lstock, Lprecio;
    private static JLabel LnombreDirector, Lpais, LfechaLanz, Lduracion;
    private static JLabel LnCapitulos, LnTemporadas;
    private static JLabel LidArticulo;

    public ModificarArticulo(String articulo, JComboBox comboBox) {
        tipo = articulo;
        frame = new JFrame("Modificar Articulo");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelCombo(articulo, comboBox));
        frame.add(construyePanelTop());
        if (articulo.equals("Pelicula")) {
            frame.add(construyePanelPelicula());
        } else if (articulo.equals("Serie")) {
            frame.add(construyePanelSerie());
        }
        frame.add(construyePanelBot());
        frame.pack();// coloca los componentes
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setVisible(true);

    }

    JPanel construyePanelCombo(String articulo, JComboBox comboBox) {
        comboPanel = new JPanel();
        comboPanel.setLayout(new GridLayout(1, 2, 5, 5));
        LidArticulo = new JLabel("idArticulo: ");

        Jcombo = comboBox;

        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        Jcombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int idArticulo = (Integer) Jcombo.getSelectedItem();
                    Articulo articulo = VisualizarMod.genArticulo(idArticulo);
                    Tnombre.setText(articulo.getNombre());
                    Tproductora.setText(articulo.getProductora());
                    Tclasificacion.setText(articulo.getClasificacion());
                    Tgenero.setText(articulo.getGenero());
                    Tstock.setText(String.valueOf(articulo.getStock()));
                    Tprecio.setText(String.valueOf(articulo.getPrecio()));
                    if (tipo.equals("Serie")) {
                        System.out.println("a");
                        Serie serie = VisualizarMod.genSerie(idArticulo);
                        TnCapitulos.setText(String.valueOf(serie.getnCapitulos()));
                        TnTemporadas.setText(String.valueOf(serie.getnTemporadas()));
                    } else if (tipo.equals("Pelicula")) {
                        Pelicula pelicula = VisualizarMod.genPelicula(idArticulo);
                        TnombreDirector.setText(pelicula.getNombreDirector());
                        Tpais.setText(pelicula.getPais());
                        TfechaLanz.setText(pelicula.getFechaLanz());
                        Tduracion.setText(String.valueOf(pelicula.getDuracion()));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ModificarArticulo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        comboPanel.add(LidArticulo);
        comboPanel.add(Jcombo);
        return comboPanel;
    }

    JPanel construyePanelTop() {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 4, 5, 5));
        Lnombre = new JLabel("Nombre: ");
        Tnombre = new JTextField(20);
        Lproductora = new JLabel("Productora: ");
        Tproductora = new JTextField(20);
        Lclasificacion = new JLabel("Clasificacion: ");
        Tclasificacion = new JTextField(3);
        Lgenero = new JLabel("Genero: ");
        Tgenero = new JTextField(20);
        Lstock = new JLabel("Stock: ");
        Tstock = new JTextField(4);
        Lprecio = new JLabel("Precio: ");
        Tprecio = new JTextField(3);
        topPanel.add(Lnombre);
        topPanel.add(Tnombre);
        topPanel.add(Lproductora);
        topPanel.add(Tproductora);
        topPanel.add(Lclasificacion);
        topPanel.add(Tclasificacion);
        topPanel.add(Lgenero);
        topPanel.add(Tgenero);
        topPanel.add(Lstock);
        topPanel.add(Tstock);
        topPanel.add(Lprecio);
        topPanel.add(Tprecio);

        return topPanel;
    }

    JPanel construyePanelSerie() {
        panelSerie = new JPanel();
        panelSerie.setLayout(new GridLayout(1, 4, 5, 5));
        LnCapitulos = new JLabel("nCapitulos: ");
        TnCapitulos = new JTextField(4);
        LnTemporadas = new JLabel("nTemporadas:");
        TnTemporadas = new JTextField(2);
        panelSerie.add(LnCapitulos);
        panelSerie.add(TnCapitulos);
        panelSerie.add(LnTemporadas);
        panelSerie.add(TnTemporadas);

        return panelSerie;
    }

    JPanel construyePanelPelicula() {
        panelPelicula = new JPanel();
        panelPelicula.setLayout(new GridLayout(2, 4, 5, 5));
        LnombreDirector = new JLabel("Nombre Director: ");
        TnombreDirector = new JTextField(20);
        Lpais = new JLabel("Pais:");
        Tpais = new JTextField(20);
        LfechaLanz = new JLabel("Fecha (aaaa-mm-dd): ");
        TfechaLanz = new JTextField(10);
        Lduracion = new JLabel("Duracion:");
        Tduracion = new JTextField(3);
        panelPelicula.add(LnombreDirector);
        panelPelicula.add(TnombreDirector);
        panelPelicula.add(Lpais);
        panelPelicula.add(Tpais);
        panelPelicula.add(LfechaLanz);
        panelPelicula.add(TfechaLanz);
        panelPelicula.add(Lduracion);
        panelPelicula.add(Tduracion);

        return panelPelicula;
    }

    JPanel construyePanelBot() {
        panelBot = new JPanel();
        panelBot.setLayout(new GridLayout(1, 2, 5, 5));
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        panelBot.add(btnAceptar);
        panelBot.add(btnCancelar);

        return panelBot;
    }

    public static String getTipo() {
        return tipo;
    }

    public void setControlador(ModificarControlador escucharBoton) {
        btnAceptar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }

    public Serie generarSerie() {
        System.out.println("IDArticulo: " + Jcombo.getSelectedItem());
        return new Serie(Integer.valueOf(TnCapitulos.getText()), Integer.valueOf(TnTemporadas.getText()), (int) Jcombo.getSelectedItem(), Tnombre.getText(), Tproductora.getText(), Tclasificacion.getText(), Tgenero.getText(), Integer.valueOf(Tstock.getText()), Float.valueOf(Tprecio.getText()));
    }

    public Pelicula generarPelicula() {
        return new Pelicula(TnombreDirector.getText(), Tpais.getText(), TfechaLanz.getText(), Integer.valueOf(Tduracion.getText()), (int) Jcombo.getSelectedItem(), Tnombre.getText(), Tproductora.getText(), Tclasificacion.getText(), Tgenero.getText(), Integer.valueOf(Tstock.getText()), Float.valueOf(Tprecio.getText()));
    }

    public static int getJcombo() {
        return (Integer) Jcombo.getSelectedItem();
    }

    public void cerrarVentana() {
        frame.dispose();
    }
}
