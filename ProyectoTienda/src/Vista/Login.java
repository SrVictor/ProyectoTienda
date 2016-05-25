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
public class Login extends PlantillaVista {

    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";
    private static JLabel LNombre;
    private static JLabel LContrasena;
    private JTextField TNombre;
    private JTextField TContrasena;
    private static JButton btnAceptar;
    private static JButton btnCancelar;

    public Login() {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(3, 2, 5, 5));

        LNombre = new JLabel("Usuario");
        LContrasena = new JLabel("Contraseña");
        TNombre = new JTextField(20);
        TContrasena = new JTextField(20);
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        mainPanel.add(LNombre);
        mainPanel.add(TNombre);
        mainPanel.add(LContrasena);
        mainPanel.add(TContrasena);
        mainPanel.add(btnAceptar);
        mainPanel.add(btnCancelar);

        this.add(mainPanel);
    }

    public String getTNombre() {
        return TNombre.getText();
    }

    public String getTContrasena() {
        return TContrasena.getText();
    }


    public void setControlador(UsuariosControlador escucharBoton) {
        btnAceptar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }


    public void arranca() {
        pack();// coloca los componentes
        setLocationRelativeTo(null);// centra la ventana en la pantalla
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    }
