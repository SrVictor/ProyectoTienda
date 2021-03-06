package Vista;

import Controlador.ControlarExportacion;
import Controlador.CrearUsuarioControlador;
import Modelo.GestionFicheros;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaSeleccionarTXT{

    /**
     * @return the fichero
     */
    public static File getFichero() {
        return fichero;
    }

    /**
     * @param aFichero the fichero to set
     */
    public static void setFichero(File aFichero) {
        fichero = aFichero;
    }
    private JFileChooser fc;
    private JPanel contentPane;
    private JTextField textField;
    private static File fichero;
    private static String urlFichero;
    private static JFrame frame;

    class EventoSeleccionar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Creamos el objeto JFileChooser
            fc = new JFileChooser();

            //Creamos el filtro
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "txt");

            //Le indicamos el filtro
            fc.setFileFilter(filtro);

            //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
            int seleccion = fc.showOpenDialog(contentPane);

            //Si el usuario, pincha en aceptar
            if (seleccion == JFileChooser.APPROVE_OPTION) {

                //Seleccionamos el fichero
                fichero = fc.getSelectedFile();

                //Ecribe la ruta del fichero seleccionado en el campo de texto
                textField.setText(fichero.getAbsolutePath());

                urlFichero = fichero.getAbsolutePath();
                fc.cancelSelection();
            }
        }
    }

    class EventoAceptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                MostrarExportacion me = new MostrarExportacion(GestionFicheros.leerFicheroTexto(urlFichero));
                ControlarExportacion cuc = new ControlarExportacion(me);
                me.setControlador(cuc);
            } catch (Exception ex) {
                Logger.getLogger(VentanaSeleccionarTXT.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Create the frame.
     */
    public VentanaSeleccionarTXT() {
        //Parametros asociados a la ventana
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 150);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        frame.setContentPane(contentPane);

        textField = new JTextField();
        textField.setToolTipText("Inserta la ruta del fichero de texto");
        textField.setBounds(52, 26, 209, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btSeleccionar = new JButton("Seleccionar...");
        btSeleccionar.setBounds(288, 25, 109, 23);
        contentPane.add(btSeleccionar);

        JButton btAceptar = new JButton("Aceptar");
        btAceptar.setBounds(288, 60, 109, 23);
        contentPane.add(btAceptar);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btSeleccionar.addActionListener(new VentanaSeleccionarTXT.EventoSeleccionar());
        btAceptar.addActionListener(new VentanaSeleccionarTXT.EventoAceptar());

    }
}
