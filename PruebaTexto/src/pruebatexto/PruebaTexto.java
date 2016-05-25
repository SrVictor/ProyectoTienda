/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class PruebaTexto {

    /**
     * @param args the command line arguments
     */
    private void FileTextRead() throws IOException {
        int i = 0;

        FileReader myFile = null;
        try {h
//Leo un Archivo de Texto
            String file = "../FPInstruments/miArchivo.txt";
            myFile = new FileReader(file);
            BufferedReader InputFile = new BufferedReader(myFile);
// Read the first line
            String currentRecord = InputFile.readLine();

            while (currentRecord != null) {
                currentRecord = InputFile.readLine();

                try {
//Copio un valor a la celda 
                    jTable1.setValueAt(currentRecord, 0, i);
//Refresco la Tabla 
                    jTable1.paintImmediately(jTable1.getX(), jTable1.getY(), jTable1.getWidth(), jTable1.getHeight());
                    i = i + 1;

                } catch (Exception ex) {
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alarms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                myFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Alarms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
