package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controlador.*;
import Modelo.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Alumno
 */
public class MostrarExportacion extends PlantillaVista {

    private JTable table;
    private JFrame frame;
    private JPanel panelTop;
    private JButton btnCancelar;
    private String[][] articulos;
    public static final String CANCELAR = "Cancelar";

    public MostrarExportacion(String[][] archivo) throws SQLException {
        frame = new JFrame("Exportar Datos");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop());
        frame.add(construyePanelFrontal(archivo));
        frame.pack();
        frame.setVisible(true);

    }

    JPanel construyePanelTop() throws SQLException {
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(1, 2, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)


        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);

        panelTop.add(btnCancelar);

        return panelTop;
    }

    JScrollPane construyePanelFrontal(String[][] archivo) throws SQLException {
        String[] columnNames = {"nombre", "productora", "clasificacion", "genero", "stock", "precio"};

        table = new JTable();
        // Creamos el modelo, la parte que contenrá los datos de la tabla
        DefaultTableModel model = new DefaultTableModel();
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(
                model);
        // Añadimos al modelo los datos que queremos que contenga la tabla
        model.setDataVector(archivo, columnNames);
        // Le decimos a la tabla que use el modelo de datos que hemos creado
        table.setModel(model);
        // Le decimos a la tabla que use la ordenación de filas que hemos
        // creado
        table.setRowSorter(sorter);
        JScrollPane scroll = new JScrollPane(table);
        frame.getContentPane().add(scroll);

        return scroll;
    }

    public void setControlador(ControlarExportacion escucharBoton) {
        btnCancelar.addActionListener(escucharBoton);
    }

}
