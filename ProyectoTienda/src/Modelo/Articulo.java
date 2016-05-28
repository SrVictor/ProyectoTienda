package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Articulo {

    protected int idArticulo;
    protected String nombre;
    protected String productora;
    protected String clasificacion;
    protected String genero;
    protected int stock;
    protected float precio;
    private static ArrayList<Articulo> articulos;
    private static String[][] articul;

    public Articulo(int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.productora = productora;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.stock = stock;
        this.precio = precio;
    }

    public Articulo(String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        this.nombre = nombre;
        this.productora = productora;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.stock = stock;
        this.precio = precio;
    }

    public Articulo(int idArticulo, int stock) {
        this.idArticulo = idArticulo;
        this.stock=stock;
    }

    
    /**
     * Devuelve el id del articulo a través del conocimiento del nombre.
     *
     * @param nombre
     * @return devuelve el id del articulo.
     * @throws SQLException
     */
    public static int getIdArticulo(String nombre) throws SQLException {
        ResultSet rs = null;
        Statement st = GenConexionMod.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        CallableStatement cs;
        cs = GenConexionMod.getConexion().prepareCall("{call getIDArticulo_OUT(?)}");
        //establecemos los valores de los parámetros.
        cs.setString(1, nombre);
        rs = cs.executeQuery();

        rs.beforeFirst();
        rs.next();
        int idArticulo = rs.getInt(1);
        System.out.println("idArticulo: " + idArticulo);
        rs.close();
        return idArticulo;
    }

    Articulo() {

    }

    public static void leerArray(ArrayList<Articulo> articul) {
        for (int i = 0; i < articul.size(); i++) {
            System.out.println("Articulo nº: " + i);
            System.out.println("idArticulo: " + articul.get(i).getIdArticulo());
            System.out.println("Nombre: " + articul.get(i).getNombre());
            System.out.println("Productora: " + articul.get(i).getProductora());
            System.out.println("Clasificación: " + articul.get(i).getClasificacion());
            System.out.println("Genero: " + articul.get(i).getGenero());
            System.out.println("Stock: " + articul.get(i).getStock());
            System.out.println("Precio: " + articul.get(i).getPrecio());
            System.out.println("");
        }
    }

    public static JComboBox rellenarComboBoxID() throws SQLException {
        ArrayList<Integer> idArticulos = VisualizarMod.genIDArticulos();

        JComboBox combo = new JComboBox();
        for (int i = 0; i < idArticulos.size(); i++) {
            combo.addItem(idArticulos.get(i));
        }
        return combo;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProductora() {
        return productora;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public int getStock() {
        return stock;
    }

    public float getPrecio() {
        return precio;
    }

    public static ArrayList<Articulo> getArticulos() throws SQLException {
        return articulos;
    }

    public static void setArticulos(ArrayList<Articulo> articulos) {
        Articulo.articulos = articulos;
    }

    public static void anadirArticulo(Articulo articulo) {
         if (articulos==null){
            articulos = new ArrayList<Articulo>();
        }
        articulos.add(articulo);
    }


    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static String[][] getArticul() throws SQLException {
       VisualizarMod.ArticulosToArray();
        return articul;
    }

    public static void setArticul(String[][] articul) {
        Articulo.articul = articul;
    }
    
    

}
