/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author David
 */
public class MenuPrincipal extends PlantillaVista {

    public static final String ALTAARTICULO = "Alta Articulo";
    public static final String BAJAPARTICULO = "Baja Articulo";
    public static final String MODIFICARARTICULO = "Modificar Articulo";
    public static final String RELLENARSTOCK = "Rellenar Stock";
    public static final String VENDERARTICULO = "Vender Articulo";
    public static final String IMPORTARARTICULOS = "Importar Articulos";
    public static final String VISUALIZARARTICULOS = "Visualizar Articulos";
    public static final String VISUALIZARVENTAS = "Visualizar Ventas";
    public static final String CREARUSUARIO = "Crear Usuario";
    private static JButton btnAltaArticulo;
    private static JButton btnBajaArticulo;
    private static JButton btnModificarArticulo;
    private static JButton btnRellenarStock;
    private static JButton btnVenderArticulo;
    private static JButton btnImportarArticulos;
    private static JButton btnVisualizarArticulos;
    private static JButton btnVisualizarVentas;
    private static JButton btnCrearUsuario;

    public MenuPrincipal() {
        JPanel mainPanel = new JPanel();
        frame = new JFrame();
        btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setActionCommand("Crear Usuario");
        btnAltaArticulo = new JButton("Alta Articulo");
        btnAltaArticulo.setActionCommand("Alta Articulo");
        btnBajaArticulo = new JButton("Baja Articulo");
        btnBajaArticulo.setActionCommand("Baja Articulo");
        btnModificarArticulo = new JButton("Modificar Articulo");
        btnModificarArticulo.setActionCommand("Modificar Articulo");
        btnImportarArticulos = new JButton("Importar Articulos");
        btnImportarArticulos.setActionCommand("Importar Articulos");
        btnRellenarStock = new JButton("Rellenar Stock");
        btnRellenarStock.setActionCommand("Rellenar Stock");

        if (GenConexionMod.getCargo().equals("Gerente")) {
            mainPanel.setLayout(new GridLayout(9, 1, 5, 5));

            mainPanel.add(btnCrearUsuario);
            mainPanel.add(btnAltaArticulo);
            mainPanel.add(btnBajaArticulo);
            mainPanel.add(btnModificarArticulo);
            mainPanel.add(btnImportarArticulos);
            mainPanel.add(btnRellenarStock);
        } else {
            mainPanel.setLayout(new GridLayout(3, 1, 5, 5));
        }

        btnVenderArticulo = new JButton("Vender Articulo");
        btnVenderArticulo.setActionCommand("Vender Articulo");
        btnVisualizarArticulos = new JButton("Visualizar Articulos");
        btnVisualizarArticulos.setActionCommand("Visualizar Articulos");
        btnVisualizarVentas = new JButton("Visualizar Ventas");
        btnVisualizarVentas.setActionCommand("Visualizar Ventas");
        mainPanel.add(btnVenderArticulo);
        mainPanel.add(btnVisualizarArticulos);
        mainPanel.add(btnVisualizarVentas);

        frame.add(mainPanel);
    }

    public void setControlador(MenuControlador escucharBoton) {
        btnAltaArticulo.addActionListener(escucharBoton);
        btnBajaArticulo.addActionListener(escucharBoton);
        btnModificarArticulo.addActionListener(escucharBoton);
        btnVenderArticulo.addActionListener(escucharBoton);
        btnImportarArticulos.addActionListener(escucharBoton);
        btnVisualizarArticulos.addActionListener(escucharBoton);
        btnVisualizarVentas.addActionListener(escucharBoton);
        btnCrearUsuario.addActionListener(escucharBoton);
        btnRellenarStock.addActionListener(escucharBoton);
    }

    public void arranca() {
        frame.pack();// coloca los componentes
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
