package Modelo;

import static Modelo.VisualizarMod.genArticulo;
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
    private static String usuario;
    private static String contrasenia;
    private static String sentenciaSQL;

    private static String regex = "[0-9][a-zA-z]*\\.user";

    public GenConexionMod() {
    }

    /**
     * Abre la conexion con el servidor.
     *
     * @return
     */
    public boolean abrirConexion(String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor + bd, user, pass);
            System.out.println("CONECTADO!");
            usuario = user;
            contrasenia = pass;
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
        if (pass.matches(regex)) {
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

    public boolean crearUsuario(String nombre, String contrasena) throws SQLException {
        if (comprobarContrasena(contrasena)) {
            GenConexionMod.ejecutaQuery("CREATE USER '" + nombre + "'@'127.0.0.1' IDENTIFIED BY '" + contrasena + "';  GRANT SELECT, EXECUTE ON * . * TO '" + nombre + "'@'127.0.0.1';");
            usuario = nombre;
            contrasenia = contrasena;
            return true;
        } else {
            return false;
        }
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
     * Devuelve el nombre de usuario.
     *
     * @return
     */
    public static String getUsuario() {
        return usuario;
    }

}
