package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controlador.*;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Alumno
 */
public class MostrarVentasVista extends PlantillaVista {

    JDateChooser dateChooser, dateChooser2;
    JTable table;
    JFrame frame;
    JPanel panelTop;
    JButton btnActualizar, btnExportar;
    JLabel LDesde, LHasta;
    String[][] articulos;
    public static String ACEPTAR = "Aceptar";
    public static String EXPORTAR = "Exportar";

    public MostrarVentasVista(String[][] venta) throws SQLException {
        frame = new JFrame("Mostrar Ventas");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop());
        frame.add(construyePanelFrontal(venta));
        frame.pack();
        frame.setSize(1500, 700);
        frame.setVisible(true);

    }

    JPanel construyePanelTop() throws SQLException {
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(4, 2, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)
        LDesde = new JLabel("Desde (aaaa-MM-dd): ");
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(20, 20, 200, 20);
        //frame.getContentPane().add(dateChooser);
        LHasta = new JLabel("Hasta (aaaa-MM-dd): ");
        dateChooser2 = new JDateChooser();
        dateChooser2.setDateFormatString("yyyy-MM-dd");
        dateChooser2.setBounds(20, 20, 200, 20);

        btnActualizar = new JButton("Aceptar");
        btnActualizar.setActionCommand(ACEPTAR);
        btnExportar = new JButton("Exportar");
        btnExportar.setActionCommand(EXPORTAR);

        panelTop.add(LDesde);
        panelTop.add(dateChooser);
        panelTop.add(LHasta);
        panelTop.add(dateChooser2);
        panelTop.add(btnActualizar);
        panelTop.add(btnExportar);

        return panelTop;
    }

    JScrollPane construyePanelFrontal(String[][] venta) throws SQLException {
        String[] columnNames = {"idVenta", "idArticulo", "fechaTransaccion", "cantidad", "precioTotal", "nombre", "productora", "clasificacion", "genero", "precio(Unidad)"};

        table = new JTable();
        // Creamos el modelo, la parte que contenrá los datos de la tabla
        DefaultTableModel model = new DefaultTableModel();
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(model);
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
        btnExportar.addActionListener(escucharBoton);
    }

    public String getDateChooser() {
        String formato = dateChooser.getDateFormatString();
        Date date = dateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return String.valueOf(sdf.format(date));
    }

    public String getDateChooser2() {
        String formato = dateChooser2.getDateFormatString();
        Date date = dateChooser2.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return String.valueOf(sdf.format(date));
    }

    public void cerrarVentana() {
        frame.dispose();
    }

}
