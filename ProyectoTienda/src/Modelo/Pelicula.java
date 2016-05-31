package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Pelicula extends Articulo {

    private String nombreDirector;
    private String pais;
    private String fechaLanz;
    private int duracion;
    private static ArrayList<Pelicula> peliculas;
    private static String[][] pelicula;

    public Pelicula(String nombreDirector, String pais, String fechaLanz, int duracion, int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
        this.nombreDirector = nombreDirector;
        this.pais = pais;
        this.fechaLanz = fechaLanz;
        this.duracion = duracion;
    }

    public Pelicula(String nombreDirector, String pais, String fechaLanz, int duracion, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(nombre, productora, clasificacion, genero, stock, precio);
        this.nombreDirector = nombreDirector;
        this.pais = pais;
        this.fechaLanz = fechaLanz;
        this.duracion = duracion;
    }

    public Pelicula(String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(nombre, productora, clasificacion, genero, stock, precio);
    }

    public Pelicula(int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
    }

    public Pelicula() {
    }
    
    

    public static JComboBox rellenarComboBoxID() throws SQLException {
        VisualizarMod.genArrayPeliculas();
        JComboBox combo = new JComboBox();
        for (int i = 0; i < peliculas.size(); i++) {
            combo.addItem(peliculas.get(i).getIdArticulo());
        }
        return combo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public String getPais() {
        return pais;
    }

    public String getFechaLanz() {
        return fechaLanz;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFechaLanz(String fechaLanz) {
        this.fechaLanz = fechaLanz;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public static ArrayList<Pelicula> getPeliculas() throws SQLException {

        VisualizarMod.genArrayPeliculas();
        return peliculas;
    }

    public static void setPeliculas(ArrayList<Pelicula> peliculas) {
        Pelicula.peliculas = peliculas;
    }

    public static void anadirPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public static String[][] getPeliculass() throws SQLException {
        VisualizarMod.PeliculasToArray();
        return pelicula;
    }

    public static void setPeliculass(String[][] pel) {
        pelicula=pel;
    }

}
