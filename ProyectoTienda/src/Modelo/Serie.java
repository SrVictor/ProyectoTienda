package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Serie extends Articulo {

    private int nCapitulos;
    private int nTemporadas;
    private static ArrayList<Serie> series;

    public Serie(int nCapitulos, int nTemporadas, int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
        this.nCapitulos = nCapitulos;
        this.nTemporadas = nTemporadas;
    }

    public Serie(int nCapitulos, int nTemporadas, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(nombre, productora, clasificacion, genero, stock, precio);
        this.nCapitulos = nCapitulos;
        this.nTemporadas = nTemporadas;
    }

    public int getnCapitulos() {
        return nCapitulos;
    }

    public int getnTemporadas() {
        return nTemporadas;
    }

    public static ArrayList<Serie> getSeries() throws SQLException {
        VisualizarMod.genArraySeries();
        return series;
    }

    public static void setSeries(ArrayList<Serie> series) {
        Serie.series = series;
    }

    public static void anadirSerie(Serie serie) {
        series.add(serie);
    }

}
