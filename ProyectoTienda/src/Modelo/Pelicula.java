package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pelicula extends Articulo {

    private String nombreDirector;
    private String pais;
    private String fechaLanz;
    private int duracion;
    private static ArrayList<Pelicula> peliculas;
    

    public Pelicula(String nombreDirector, String pais, String fechaLanz, int duracion, int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
        this.nombreDirector = nombreDirector;
        this.pais = pais;
        this.fechaLanz = fechaLanz;
        this.duracion = duracion;
    }

    public Pelicula(String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(nombre, productora, clasificacion, genero, stock, precio);
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

}
