package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controlador.BajaArticuloControlador;
import Controlador.MostrarArticulosControlador;
import Modelo.Articulo;
import Modelo.VisualizarMod;
import static Vista.MostrarVentasVista.FILTRAR;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Alumno
 */
public class MostrarArticulosVista extends PlantillaVista {

    JTable table;
    private JComboBox Jcombo;
    private TableRowSorter<TableModel> modeloOrdenado;
    JFrame frame;
    JPanel panelTop;
    JButton btnActualizar, btnFiltrar;
    String[][] articulos;
    public static String FILTRAR = "Filtrar";
    public static String ACTUALIZAR = "Actualizar";
    public static String MOSTRAR = "Actualizar";

    public MostrarArticulosVista(String[][] articulo) throws SQLException {
        frame = new JFrame("Mostrar Articulos");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop());
        frame.add(construyePanelFrontal(articulo));
        frame.pack();
        frame.setVisible(true);

    }

    JPanel construyePanelTop() throws SQLException {
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(2, 2, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)

        Jcombo = new JComboBox();
        Jcombo.addItem("Series");
        Jcombo.addItem("Peliculas");

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setActionCommand("Actualizar");
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setActionCommand("Filtrar");
        panelTop.add(btnFiltrar);
        panelTop.add(Jcombo);
        panelTop.add(btnActualizar);

        return panelTop;
    }

    JScrollPane construyePanelFrontal(String[][] articulo) throws SQLException {
        String[] columnNames = {"idArticulo", "nombre", "productora", "clasificacion", "genero", "stock", "precio"};

        table = new JTable();
        // Creamos el modelo, la parte que contenrá los datos de la tabla
        DefaultTableModel model = new DefaultTableModel();
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(
                model);
        // Añadimos al modelo los datos que queremos que contenga la tabla
        model.setDataVector(articulo, columnNames);
        // Le decimos a la tabla que use el modelo de datos que hemos creado
        table.setModel(model);
        // Le decimos a la tabla que use la ordenación de filas que hemos
        // creado
        table.setRowSorter(sorter);

        table.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        System.out.print("Valor: ");
                        System.out.println(table.getValueAt(i, j).toString());
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        frame.getContentPane().add(scroll);
        return scroll;
    }

    JPanel construyePanelBot() throws SQLException {
        panelBot = new JPanel();
        panelBot.setLayout(new GridLayout(1, 5, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)
        LFiltro = new JLabel("Filtro: ");
        filtros = new JComboBox();
        filtros.addItem("idVenta");
        filtros.addItem("idArticulo");
        filtros.addItem("cantidad");
        filtros.addItem("precioTotal");
        LDato = new JLabel("Dato: ");
        TDato = new JTextField();
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setActionCommand(FILTRAR);
        panelBot.add(LFiltro);
        panelBot.add(filtros);
        panelBot.add(LDato);
        panelBot.add(TDato);
        panelBot.add(btnFiltrar);
        return panelBot;
    }

    public static void generarTabla(String[][] articulo) throws SQLException {
        MostrarArticulosVista frame = new MostrarArticulosVista(articulo);
    }

    public void setControlador(MostrarArticulosControlador escucharBoton) {
        btnFiltrar.addActionListener(escucharBoton);
        btnActualizar.addActionListener(escucharBoton);
    }

    public String getJcombo() {
        return (String) Jcombo.getSelectedItem();
    }

}
