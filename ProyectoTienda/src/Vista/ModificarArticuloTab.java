/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author David
 */
public class ModificarArticuloTab extends PlantillaVista {

    private static String tipo;
    static JComboBox Jcombo, Jcombos, Jcombop;
    JFrame frame;
    private JDateChooser dateChooser;
    JPanel topPanel, panelSerie, panelPelicula, panelBot, comboPanel;
    private static JButton btnModificar, btnModificars, btnModificarp;
    private static JButton btnCancelar, btnCancelars, btnCancelarp;
    private JTextField Tnombre, Tproductora, Tclasificacion, Tgenero, Tstock, Tprecio;
    private JTextField Tnombres, Tproductoras, Tclasificacions, Tgeneros, Tstocks, Tprecios;
    private JTextField Tnombrep, Tproductorap, Tclasificacionp, Tgenerop, Tstockp, Tpreciop;
    private JTextField TnombreDirector, Tpais, TfechaLanz, Tduracion;
    private JTextField TnCapitulos, TnTemporadas;
    private static JLabel Lnombre, Lproductora, Lclasificacion, Lgenero, Lstock, Lprecio;
    private static JLabel LnombreDirector, Lpais, LfechaLanz, Lduracion;
    private static JLabel LnCapitulos, LnTemporadas;
    private static JLabel LidArticulo, LidArticulos, LidArticulop;

    public ModificarArticuloTab() {
        frame = new JFrame("Modificar Articulos");
        //Parametros asociados a la ventana

        //Creamos el conjunto de pestañas
        JTabbedPane pestañas = new JTabbedPane();

        //Creamos el panel y lo añadimos a las pestañas
        JPanel panel1 = new JPanel();

        //Componentes del panel1
        panel1.add(construyePanelTop());

        //Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Modificar Articulo", panel1);

        //Creamos el panel y lo añadimos a las pestañas
        JPanel panel2 = new JPanel();

        //Componentes del panel1
        panel2.add(construyePanelSerie());

        //Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Modificar Serie", panel2);

        //Creamos el panel y lo añadimos a las pestañas
        JPanel panel3 = new JPanel();

        //Componentes del panel1
        panel3.add(construyePanelPelicula());

        //Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Modificar Pelicula", panel3);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(pestañas);
        frame.pack();
        frame.setLocationRelativeTo(null);// centra la ventana en la pantalla
        frame.setVisible(true);

    }

    JPanel construyePanelTop() {
        try {
            topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(5, 4, 5, 5));
            LidArticulo = new JLabel("idArticulo: ");

            Jcombo = Articulo.rellenarComboBoxID();

            // Accion a realizar cuando el JComboBox cambia de item seleccionado.
            Jcombo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        int idArticulo = (Integer) Jcombo.getSelectedItem();
                        Articulo articulo = VisualizarMod.genArticulo(idArticulo);
                        Tnombre.setText(articulo.getNombre());
                        Tproductora.setText(articulo.getProductora());
                        Tclasificacion.setText(articulo.getClasificacion());
                        Tgenero.setText(articulo.getGenero());
                        Tstock.setText(String.valueOf(articulo.getStock()));
                        Tprecio.setText(String.valueOf(articulo.getPrecio()));

                    } catch (SQLException ex) {
                        Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            Lnombre = new JLabel("Nombre: ");
            Tnombre = new JTextField(20);
            Lproductora = new JLabel("Productora: ");
            Tproductora = new JTextField(20);
            Lclasificacion = new JLabel("Clasificacion: ");
            Tclasificacion = new JTextField(3);
            Lgenero = new JLabel("Genero: ");
            Tgenero = new JTextField(20);
            Lstock = new JLabel("Stock: ");
            Tstock = new JTextField(4);
            Lprecio = new JLabel("Precio: ");
            Tprecio = new JTextField(3);
            btnModificar = new JButton("Modificar");
            btnModificar.setActionCommand("Modificar Articulo");
            btnCancelar = new JButton("Cancelar");
            btnCancelar.setActionCommand("Cancelar");
            topPanel.add(Jcombo);
            topPanel.add(LidArticulo);
            topPanel.add(Lnombre);
            topPanel.add(Tnombre);
            topPanel.add(Lproductora);
            topPanel.add(Tproductora);
            topPanel.add(Lclasificacion);
            topPanel.add(Tclasificacion);
            topPanel.add(Lgenero);
            topPanel.add(Tgenero);
            topPanel.add(Lstock);
            topPanel.add(Tstock);
            topPanel.add(Lprecio);
            topPanel.add(Tprecio);
            topPanel.add(btnModificar);
            topPanel.add(btnCancelar);

        } catch (SQLException ex) {
            Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topPanel;
    }

    JPanel construyePanelSerie() {
        try {
            panelSerie = new JPanel();
            panelSerie.setLayout(new GridLayout(6, 4, 5, 5));
            LidArticulos = new JLabel("idArticulo: ");
            Jcombos = Serie.rellenarComboBoxID();

            // Accion a realizar cuando el JComboBox cambia de item seleccionado.
            Jcombos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        int idArticulo = (Integer) Jcombos.getSelectedItem();
                        Articulo articulo = VisualizarMod.genArticulo(idArticulo);
                        Tnombres.setText(articulo.getNombre());
                        Tproductoras.setText(articulo.getProductora());
                        Tclasificacions.setText(articulo.getClasificacion());
                        Tgeneros.setText(articulo.getGenero());
                        Tstocks.setText(String.valueOf(articulo.getStock()));
                        Tprecios.setText(String.valueOf(articulo.getPrecio()));
                        Serie serie = VisualizarMod.genSerie(idArticulo);
                        TnCapitulos.setText(String.valueOf(serie.getnCapitulos()));
                        TnTemporadas.setText(String.valueOf(serie.getnTemporadas()));

                    } catch (SQLException ex) {
                        Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            Lnombre = new JLabel("Nombre: ");
            Tnombres = new JTextField(20);
            Lproductora = new JLabel("Productora: ");
            Tproductoras = new JTextField(20);
            Lclasificacion = new JLabel("Clasificacion: ");
            Tclasificacions = new JTextField(3);
            Lgenero = new JLabel("Genero: ");
            Tgeneros = new JTextField(20);
            Lstock = new JLabel("Stock: ");
            Tstocks = new JTextField(4);
            Lprecio = new JLabel("Precio: ");
            Tprecios = new JTextField(3);
            LnCapitulos = new JLabel("nCapitulos: ");
            TnCapitulos = new JTextField(4);
            LnTemporadas = new JLabel("nTemporadas:");
            TnTemporadas = new JTextField(2);
            btnModificars = new JButton("Modificar");
            btnModificars.setActionCommand("Modificar Serie");
            btnCancelars = new JButton("Cancelar");
            btnCancelars.setActionCommand("Cancelar");
            panelSerie.add(LidArticulos);
            panelSerie.add(Jcombos);
            panelSerie.add(Lnombre);
            panelSerie.add(Tnombres);
            panelSerie.add(Lproductora);
            panelSerie.add(Tproductoras);
            panelSerie.add(Lclasificacion);
            panelSerie.add(Tclasificacions);
            panelSerie.add(Lgenero);
            panelSerie.add(Tgeneros);
            panelSerie.add(Lstock);
            panelSerie.add(Tstocks);
            panelSerie.add(Lprecio);
            panelSerie.add(Tprecios);
            panelSerie.add(LnCapitulos);
            panelSerie.add(TnCapitulos);
            panelSerie.add(LnTemporadas);
            panelSerie.add(TnTemporadas);
            panelSerie.add(btnModificars);
            panelSerie.add(btnCancelars);

            return panelSerie;
        } catch (SQLException ex) {
            Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        return panelSerie;
    }

    JPanel construyePanelPelicula() {
        try {
            panelPelicula = new JPanel();
            panelPelicula.setLayout(new GridLayout(4, 4, 5, 5));
            LidArticulop = new JLabel("idArticulo: ");
            Jcombop = Pelicula.rellenarComboBoxID();

            // Accion a realizar cuando el JComboBox cambia de item seleccionado.
            Jcombop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        int idArticulo = (Integer) Jcombop.getSelectedItem();
                        Articulo articulo = VisualizarMod.genArticulo(idArticulo);
                        Tnombrep.setText(articulo.getNombre());
                        Tproductorap.setText(articulo.getProductora());
                        Tclasificacionp.setText(articulo.getClasificacion());
                        Tgenerop.setText(articulo.getGenero());
                        Tstockp.setText(String.valueOf(articulo.getStock()));
                        Tpreciop.setText(String.valueOf(articulo.getPrecio()));
                        Pelicula pelicula = VisualizarMod.genPelicula(idArticulo);
                        TnombreDirector.setText(pelicula.getNombreDirector());
                        System.out.println("PAIS" + pelicula.getPais());
                        System.out.println("fecha: 0" + pelicula.getFechaLanz());
                        Tpais.setText(pelicula.getPais());
                        
                        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                        String strFecha = pelicula.getFechaLanz();
                        Date fecha = formatoDelTexto.parse(strFecha);
                        
                        dateChooser.setDate(fecha);
                        Tduracion.setText(String.valueOf(pelicula.getDuracion()));
                    } catch (SQLException ex) {
                        Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            Lnombre = new JLabel("Nombre: ");
            Tnombrep = new JTextField(20);
            Lproductora = new JLabel("Productora: ");
            Tproductorap = new JTextField(20);
            Lclasificacion = new JLabel("Clasificacion: ");
            Tclasificacionp = new JTextField(3);
            Lgenero = new JLabel("Genero: ");
            Tgenerop = new JTextField(20);
            Lstock = new JLabel("Stock: ");
            Tstockp = new JTextField(4);
            Lprecio = new JLabel("Precio: ");
            Tpreciop = new JTextField(3);
            LnombreDirector = new JLabel("Nombre Director: ");
            TnombreDirector = new JTextField(20);
            Lpais = new JLabel("Pais:");
            Tpais = new JTextField(20);
            LfechaLanz = new JLabel("Fecha (aaaa-mm-dd): ");
            dateChooser = new JDateChooser();
            dateChooser.setDateFormatString("yyyy-MM-dd");
            dateChooser.setBounds(20, 20, 200, 20);
            Lduracion = new JLabel("Duracion:");
            Tduracion = new JTextField(3);
            btnModificarp = new JButton("Modificar");
            btnModificarp.setActionCommand("Modificar Pelicula");
            btnCancelarp = new JButton("Cancelar");
            btnCancelarp.setActionCommand("Cancelar");
            panelPelicula.add(LidArticulop);
            panelPelicula.add(Jcombop);
            panelPelicula.add(Lnombre);
            panelPelicula.add(Tnombrep);
            panelPelicula.add(Lproductora);
            panelPelicula.add(Tproductorap);
            panelPelicula.add(Lclasificacion);
            panelPelicula.add(Tclasificacionp);
            panelPelicula.add(Lgenero);
            panelPelicula.add(Tgenerop);
            panelPelicula.add(Lstock);
            panelPelicula.add(Tstockp);
            panelPelicula.add(Lprecio);
            panelPelicula.add(Tpreciop);
            panelPelicula.add(LnombreDirector);
            panelPelicula.add(TnombreDirector);
            panelPelicula.add(Lpais);
            panelPelicula.add(Tpais);
            panelPelicula.add(LfechaLanz);
            panelPelicula.add(dateChooser);
            panelPelicula.add(Lduracion);
            panelPelicula.add(Tduracion);
            panelPelicula.add(btnModificarp);
            panelPelicula.add(btnCancelarp);
        } catch (SQLException ex) {
            Logger.getLogger(ModificarArticuloTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        return panelPelicula;
    }

    public void setControlador(ModificarControladorTab escucharBoton) {
        btnModificar.addActionListener(escucharBoton);
        btnModificars.addActionListener(escucharBoton);
        btnModificarp.addActionListener(escucharBoton);
        btnCancelar.addActionListener(escucharBoton);
        btnCancelars.addActionListener(escucharBoton);
        btnCancelarp.addActionListener(escucharBoton);
    }

    public static String getTipo() {
        return tipo;
    }

    public Serie generarSerie() {
        try {
            Serie serie = new Serie(Integer.valueOf(TnCapitulos.getText()), Integer.valueOf(TnTemporadas.getText()), (int) Jcombos.getSelectedItem(), Tnombres.getText(), Tproductoras.getText(), Tclasificacions.getText(), Tgeneros.getText(), Integer.valueOf(Tstocks.getText()), Float.valueOf(Tprecios.getText()));
            if (Articulo.crearArticulo(serie)) {
                return serie;
            }
        } catch (NumberFormatException nfe) {
            PlantillaVista.mostrarInfo2("ERROR! El formato de carácteres no es válido, no introduzcas letras en donde van números.");

        }
        return null;
    }

    public Pelicula generarPelicula() {
        String formato = dateChooser.getDateFormatString();
        Date date = dateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String fecha = String.valueOf(sdf.format(date));
        try {
            Pelicula pelicula = new Pelicula(TnombreDirector.getText(), Tpais.getText(), fecha, Integer.valueOf(Tduracion.getText()), (int) Jcombop.getSelectedItem(), Tnombrep.getText(), Tproductorap.getText(), Tclasificacionp.getText(), Tgenerop.getText(), Integer.valueOf(Tstockp.getText()), Float.valueOf(Tpreciop.getText()));
            if (Articulo.crearArticulo(pelicula)) {
                if (Pelicula.crearPelicula(pelicula)) {
                    return pelicula;
                }
            }
        } catch (NumberFormatException nfe) {
            PlantillaVista.mostrarInfo2("ERROR! El formato de carácteres no es válido, no introduzcas letras en donde van números.");
        }
        return null;
    }

    public Articulo generarArticulo() {
        try {
            Articulo articulo = new Articulo((int) Jcombo.getSelectedItem(), Tnombre.getText(), Tproductora.getText(), Tclasificacion.getText(), Tgenero.getText(), Integer.valueOf(Tstock.getText()), Float.valueOf(Tprecio.getText()));
            if (Articulo.crearArticulo(articulo)) {
                return articulo;
            }
        } catch (NumberFormatException nfe) {
            PlantillaVista.mostrarInfo2("ERROR! El formato de carácteres no es válido, no introduzcas letras en donde van números.");

        }
        return null;
    }

    public static int getJcombo() {
        return (Integer) Jcombo.getSelectedItem();
    }

    public void cerrarVentana() {
        frame.dispose();
    }
}
