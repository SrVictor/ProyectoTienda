/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CrearUsuarioControlador;
import Controlador.UsuariosControlador;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David
 */
public class CrearUsuario extends PlantillaVista {

    private JComboBox JCombo;
    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";
    private static JLabel LUsuario, LContrasena, LCargo, LNombre;
    private JTextField TUsuario, TContrasena, TNombre;
    private static JButton btnAceptar;
    private static JButton btnCancelar;

    public CrearUsuario() {
        frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 5, 5));

        JCombo = new JComboBox();
        JCombo.addItem("Comercial");
        JCombo.addItem("Grente");

        LUsuario = new JLabel("Usuario: ");
        TUsuario = new JTextField(20);
        LContrasena = new JLabel("Contraseña: ");
        TContrasena = new JTextField(20);
        LCargo = new JLabel("Cargo: ");
        LNombre = new JLabel("Nombre: ");
        TNombre = new JTextField();
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        mainPanel.add(LUsuario);
        mainPanel.add(TUsuario);
        mainPanel.add(LContrasena);
        mainPanel.add(TContrasena);
        mainPanel.add(LCargo);
        mainPanel.add(JCombo);
        mainPanel.add(LNombre);
        mainPanel.add(TNombre);
        mainPanel.add(btnAceptar);
        mainPanel.add(btnCancelar);

        frame.add(mainPanel);
    }

    public String getTUsuario() {
        return TUsuario.getText();
    }

    public String getTContrasena() {

        return TContrasena.getText();
    }

    public String getJCombo() {
        return (String) JCombo.getSelectedItem();
    }

    public String getTNombre() {
        return TNombre.getText();
    }
    
    public void setControlador(CrearUsuarioControlador escucharBoton) {
        btnAceptar.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
    }

    public void arranca() {
        frame.pack();// coloca los componentes
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setVisible(true);
    }
    
    
}
