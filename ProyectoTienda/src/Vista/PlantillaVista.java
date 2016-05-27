/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class PlantillaVista {

    JFrame frame = new JFrame();
    static JFrame fram2 = new JFrame();

    public PlantillaVista() {

    }

    public void mostrarInfo(String mensajeError) {
        JOptionPane.showMessageDialog(frame, mensajeError);
    }

    public static void mostrarInfo2(String mensajeError) {
        JOptionPane.showMessageDialog(fram2, mensajeError);
    }

    public void setControlador() {

    }

    public void cerrar() {
        System.exit(0);
    }

    public void cerrarVentana() {
        frame.dispose();
    }

    public void arranca() {
        frame.pack();// coloca los componentes
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setVisible(true);
    }
}
