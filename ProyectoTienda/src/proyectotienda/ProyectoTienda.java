/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotienda;

import Controlador.UsuariosControlador;
import Modelo.GenConexionMod;
import Vista.Login;

/**
 *
 * @author Computer
 */
public class ProyectoTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // el modelo:
        GenConexionMod modelo = new GenConexionMod();
        // la vista:
        Login vista = new Login();
        // y el control:
        UsuariosControlador control = new UsuariosControlador(vista, modelo);
// configura la vista
        vista.setControlador(control);
// y arranca la interfaz (vista):
        vista.arranca();
    }
}

