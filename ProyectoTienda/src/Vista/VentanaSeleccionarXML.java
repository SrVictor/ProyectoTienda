package Vista;

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

public class VentanaSeleccionarXML extends JFrame {

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

    private JPanel contentPane;
    private JTextField textField;
    private static File fichero;
    private static String urlFichero;
    private static JFrame frame;

    class EventoSeleccionar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//Creamos el objeto JFileChooser
            JFileChooser fc = new JFileChooser();

            //Creamos el filtro
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.xml", "xml");

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

            } else {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    }

    class EventoAceptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GestionFicheros.generarXML(urlFichero);
                frame.dispose();
            } catch (Exception ex) {
                Logger.getLogger(VentanaSeleccionarXML.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Create the frame.
     */
    public VentanaSeleccionarXML() {
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 150);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

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

        btSeleccionar.addActionListener(new VentanaSeleccionarXML.EventoSeleccionar());
        btAceptar.addActionListener(new VentanaSeleccionarXML.EventoAceptar());

    }
}
