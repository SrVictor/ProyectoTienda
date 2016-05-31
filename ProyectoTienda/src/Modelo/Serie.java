package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Serie extends Articulo {

    private int nCapitulos;
    private int nTemporadas;
    private static ArrayList<Serie> series;
    private static String[][] serie;

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

    public Serie(int idArticulo, String nombre, String productora, String clasificacion, String genero, int stock, float precio) {
        super(idArticulo, nombre, productora, clasificacion, genero, stock, precio);
    }

    public Serie() {
    }

    public Serie(int nCapitulos, int nTemporadas) {
        this.nCapitulos = nCapitulos;
        this.nTemporadas = nTemporadas;
    }
    
    
    
    public static JComboBox rellenarComboBoxID() throws SQLException {
        VisualizarMod.genArraySeries();
        JComboBox combo = new JComboBox();
        for (int i = 0; i < series.size(); i++) {
            combo.addItem(series.get(i).getIdArticulo());
        }
        return combo;
    }

    public void setnCapitulos(int nCapitulos) {
        this.nCapitulos = nCapitulos;
    }

    public void setnTemporadas(int nTemporadas) {
        this.nTemporadas = nTemporadas;
    }
    
   

    public int getnCapitulos() {
        return nCapitulos;
    }

    public int getnTemporadas() {
        return nTemporadas;
    }

    public static ArrayList<Serie> getSeries() throws SQLException {
        return series;
    }

    public static void setSeries(ArrayList<Serie> series) {
        Serie.series = series;
    }

    public static void anadirSerie(Serie serie) {
        if (series==null){
            series = new ArrayList<Serie>();
        }
        series.add(serie);
    }

    public static String[][] getSerie() throws SQLException {
       VisualizarMod.SeriesToArray();
        return serie;
    }

    public static void setSerie(String[][] serie) {
        Serie.serie = serie;
    }
     
    

}
