package Modelo;

import static Modelo.VisualizarMod.genArticulo;
import Vista.PlantillaVista;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenConexionMod {

    private static Connection conexion;
    private static String servidor = "jdbc:mysql://localhost/";
    private static String bd = "tienda";
    private static String cargo;
    private static String sentenciaSQL;

    private static String regex = "[A-Z]+[a-z][a-z]\\w*[0-9][0-9]+[$]";

    public GenConexionMod() {
    }

    /**
     * Abre la conexion con el servidor.
     *
     * @return
     */
    public boolean abrirConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor + bd, "root", "");
            System.out.println("CONECTADO!");
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
            System.out.println(ex);
            return false;
        }
    }

    public boolean logear(String user, String pass) throws SQLException {
        ResultSet rs = GenConexionMod.ejecutaQuery("SELECT * FROM usuarios Where usuario='" + user + "' AND contrasena ='" + pass + "';");
        rs.beforeFirst();
        if (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
            cargo = rs.getString(4);
            System.out.println("Cargo: " + cargo);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Cierra la conexion con el servidor.
     */
    public void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.err.println("Se ha producido un error, consulta al administrador de la base de datos.");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Comprueba que la contraseña sigue los patrones minimos.
     *
     * @param user
     * @param pass
     * @return
     */
    public boolean comprobarContrasena(String pass) {
        if (pass.matches(regex) && pass.length()>=8) {
            System.out.println("CORRECTO!");
            return true;
        } else {
            System.out.println("NAIN");
            return false;
        }
    }

    public static ResultSet ejecutaQuery(String sentenciaSQL) {
        ResultSet rs = null;
        try {
            Statement st = GenConexionMod.getConexion().createStatement();
            System.out.println(sentenciaSQL);
            rs = st.executeQuery(sentenciaSQL);
            System.out.println("Query Correcto");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public boolean crearUsuario(String usuario, String contrasena,String cargo, String nombre) throws SQLException {
        if (comprobarContrasena(contrasena)) {
            GenConexionMod.ejecutaUpdate("INSERT INTO `usuarios` (`idEmpleado`, `Usuario`, `Contrasena`, `Cargo`, `Nombre`) VALUES (NULL, '"+ usuario+ "' ,'" +contrasena+"' ,'"+cargo+"' , '" +nombre+"');");
            return true;
        } else {
            PlantillaVista.mostrarInfo2("La contraseña no es adecuada.");
            return false;
        }
    }
    
      public static int ejecutaUpdate(String sentenciaSQL) {
        int n = 0;
        try {

            Statement st = conexion.createStatement();
            n = st.executeUpdate(sentenciaSQL);
            System.out.println("Update Correcto.");
            //System.out.println(st.getUpdateCount());
            return n;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return n;
    }

    /**
     * Devuelve la conexion.
     *
     * @return
     */
    public static Connection getConexion() {
        return conexion;
    }

    /**
     * Devuelve el nombre de cargo.
     *
     * @return
     */
    public static String getCargo() {
        return cargo;
    }

}
