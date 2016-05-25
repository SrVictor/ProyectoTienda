/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.UsuariosControlador;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David
 */
public class SeleccionArticulo extends PlantillaVista {

    public static final String SERIE = "Serie";
    public static final String PELICULA = "Pelicula";
    private static JButton btnSerie;
    private static JButton btnPelicula;
    private String seleccion;

    public SeleccionArticulo() {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(3, 2, 5, 5));

        btnSerie = new JButton("Serie");
        btnSerie.setActionCommand("Serie");
        btnPelicula = new JButton("Pelicula");
        btnPelicula.setActionCommand("Pelicula");
        mainPanel.add(btnSerie);
        mainPanel.add(btnPelicula);

        this.add(mainPanel);
    }

    public void setControlador(UsuariosControlador escucharBoton) {
        btnSerie.addActionListener(escucharBoton);
        btnPelicula.addActionListener(escucharBoton);
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    
    
}
