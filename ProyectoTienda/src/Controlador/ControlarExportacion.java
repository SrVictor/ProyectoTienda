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

public class ControlarExportacion implements ActionListener {

    private MostrarExportacion vista;
    private GestionFicheros modelo;

    public ControlarExportacion(MostrarExportacion vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent evento) {
        modelo = new GestionFicheros();
        if (evento.getActionCommand().equals(MostrarExportacion.CANCELAR)) {
            vista.cerrarVentana();}
    }
}
