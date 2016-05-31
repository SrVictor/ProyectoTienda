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
    private JComboBox filtros;
    private String precio;
    private JDateChooser dateChooser, dateChooser2;
    private JTable table;
    private JFrame frame;
    private static JLabel LprecioTotal, Lprecio;
    private JPanel panelTop, panelBot;
    private JButton btnActualizar, btnExportar, btnFiltrar;
    private JLabel LDesde, LHasta, LFiltro, LDato;
    private JTextField TFiltro, TDato;
    public static String ACEPTAR = "Aceptar";
    public static String EXPORTAR = "Exportar";
    public static String FILTRAR = "Filtrar";

    public MostrarVentasVista(String[][] venta) throws SQLException {
        float precioTotal = 0;
        for (int i = 0; i < venta.length; i++) {
            precioTotal += Float.valueOf(venta[i][4]);
        }
        precio = String.valueOf(precioTotal);
        frame = new JFrame("Mostrar Ventas");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(construyePanelTop());
        frame.add(construyePanelFrontal(venta));
        frame.add(construyePanelBot());
        frame.pack();
        frame.setSize(1500, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    JPanel construyePanelTop() throws SQLException {
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(2, 4, 0, 5)); //(Filas, Columnas, Espacio altura, Espacio Anchuta)
        LDesde = new JLabel("Desde (aaaa-MM-dd): ");
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(20, 20, 200, 20);

        LHasta = new JLabel("Hasta (aaaa-MM-dd): ");
        dateChooser2 = new JDateChooser();
        dateChooser2.setDateFormatString("yyyy-MM-dd");
        dateChooser2.setBounds(20, 20, 200, 20);

        LprecioTotal = new JLabel("Precio total: ");
        Lprecio = new JLabel(precio);
        btnActualizar = new JButton("Aceptar");
        btnActualizar.setActionCommand(ACEPTAR);
        btnExportar = new JButton("Exportar");
        btnExportar.setActionCommand(EXPORTAR);

        panelTop.add(LDesde);
        panelTop.add(dateChooser);
        panelTop.add(LHasta);
        panelTop.add(dateChooser2);
        panelTop.add(LprecioTotal);
        panelTop.add(Lprecio);
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
        // frame.getContentPane().add(scroll);

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

    public static void generarTabla(String[][] venta) throws SQLException {
        MostrarVentasVista frame = new MostrarVentasVista(venta);
    }

    public void setControlador(MostrarVentasControlador escucharBoton) {
        btnActualizar.addActionListener(escucharBoton);
        btnExportar.addActionListener(escucharBoton);
        btnFiltrar.addActionListener(escucharBoton);
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

    public static JLabel getLprecio() {
        return Lprecio;
    }

    public String getFiltros() {
        return (String) filtros.getSelectedItem();
    }

    public String getTDato() {
        return TDato.getText();
    }
    
    

}
