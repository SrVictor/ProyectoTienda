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
public class MostrarVentasVista extends PlantillaVista {

    JTable table;
    JFrame frame;
    JPanel panelTop;
    JButton btnActualizar;
    String[][] articulos;
    public static String ACTUALIZAR = "Actualizar";

    public MostrarVentasVista(String[][] venta) throws SQLException {
        frame = new JFrame("Mostrar Ventas");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop());
        frame.add(construyePanelFrontal(venta));
        frame.pack();
        frame.setVisible(true);

    }

    JPanel construyePanelTop() throws SQLException {
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(2, 2, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)

 

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setActionCommand(ACTUALIZAR);

        panelTop.add(btnActualizar);

        return panelTop;
    }
    
    JScrollPane construyePanelFrontal(String[][] venta) throws SQLException {
        String[] columnNames = {"idVenta", "idArticulo", "fechaTransaccion", "cantidad", "precioTotal","nombre","productora","clasificacion","genero","precio(Unidad)"};

        table = new JTable();
        // Creamos el modelo, la parte que contenrá los datos de la tabla
        DefaultTableModel model = new DefaultTableModel();
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(
                model);
        // Añadimos al modelo los datos que queremos que contenga la tabla
        model.setDataVector(venta, columnNames);
        // Le decimos a la tabla que use el modelo de datos que hemos creado
        table.setModel(model);
        // Le decimos a la tabla que use la ordenación de filas que hemos
        // creado
        table.setRowSorter(sorter);
        JScrollPane scroll = new JScrollPane(table);
        frame.getContentPane().add(scroll);

        return scroll;
    }

    public static void generarTabla(String[][] venta) throws SQLException {
        MostrarVentasVista frame = new MostrarVentasVista(venta);
    }

    public void setControlador(MostrarVentasControlador escucharBoton) {
        btnActualizar.addActionListener(escucharBoton);
    }

}
