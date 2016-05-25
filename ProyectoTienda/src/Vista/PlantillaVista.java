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
public class PlantillaVista extends JFrame {

    public PlantillaVista(){
        
    }


    public void mostrarInfo(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError);
    }

    public void setControlador() {

    }

    public void cerrar(){
        System.exit(0);
    }
    
    public void cerrarVentana(){
        this.dispose();
    }

    public void arranca() {
        pack();// coloca los componentes
        setLocationRelativeTo(null);// centra la ventana en la pantalla
        setVisible(true);}
    }