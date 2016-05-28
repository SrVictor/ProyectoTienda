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
public class MostrarSeriesVista extends PlantillaVista {

    JTable table;
    private static JComboBox Jcombo;
    JFrame frame;
    JPanel panelTop;
    JButton btnActualizar, btnFiltrar;
    String[][] articulos;
    public static String FILTRAR = "Filtrar";
    public static String ACTUALIZAR = "Actualizar";
    
    
    public MostrarSeriesVista(String[][] serie) throws SQLException {
        frame = new JFrame("Mostrar Series");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop());
        frame.add(construyePanelFrontal(serie));
        frame.pack();
        frame.setSize(1920, 1050);
        frame.setVisible(true);

    }

    JPanel construyePanelTop() throws SQLException {
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(2, 2, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)

        
        Jcombo = new JComboBox();
        Jcombo.addItem("Articulos");
        Jcombo.addItem("Peliculas");

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setActionCommand(ACTUALIZAR);
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setActionCommand(FILTRAR);
        panelTop.add(btnFiltrar);
        panelTop.add(Jcombo);
        panelTop.add(btnActualizar);

        return panelTop;
    }

    JScrollPane construyePanelFrontal(String[][] serie) throws SQLException {
        String[] columnNames = {"idArticulo", "nombre", "productora", "clasificacion", "genero", "stock", "precio","nCapitulos","nTemporadas"};

        table = new JTable();
        // Creamos el modelo, la parte que contenrá los datos de la tabla
        DefaultTableModel model = new DefaultTableModel();
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(
                model);
        // Añadimos al modelo los datos que queremos que contenga la tabla
        model.setDataVector(serie, columnNames);
        // Le decimos a la tabla que use el modelo de datos que hemos creado
        table.setModel(model);
        // Le decimos a la tabla que use la ordenación de filas que hemos
        // creado
        table.setRowSorter(sorter);
        JScrollPane scroll = new JScrollPane(table);
        frame.getContentPane().add(scroll);

        return scroll;
    }

    public static void generarTabla(String[][] articulo) throws SQLException {
        MostrarSeriesVista frame = new MostrarSeriesVista(articulo);
    }

    public void setControlador(MostrarSeriesControlador escucharBoton) {
        btnFiltrar.addActionListener(escucharBoton);
        btnActualizar.addActionListener(escucharBoton);
    }

    public static String getJcombo() {
        return (String) Jcombo.getSelectedItem();
    }
    
    
    
    
}
